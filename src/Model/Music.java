package Model;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Music extends Thread{

    private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    private String filename;
    private FloatControl fc;
    private float fv;


    public Music(String filename , float fv){
        this.filename = filename;
        this.fv = fv;
    }

    public Music(String filename){
        this.filename = filename;
        fv = 6.0f;
    }

    public synchronized void playSound(){


        try {
            soundFile = new File(filename);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
            fc = ((FloatControl)sourceLine.getControl(FloatControl.Type.MASTER_GAIN));
            fc.setValue(fv);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }

    public void run(){
        this.playSound();
    }

    public void run(int i){
        while(true) 
            this.playSound();
    }

    public static void backgroundMusic(){
        Music intro = new Music("Assets\\tadaa.wav");
        intro.playSound();
        Music backMusic = new Music("Assets\\circus.wav",-10.0f);
        backMusic.run(1);
    }
}