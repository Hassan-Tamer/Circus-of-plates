package Model;

import View.Circus;

public interface Observer {
    public void update(int x);
    public void setSubject(Subject sub);
}
