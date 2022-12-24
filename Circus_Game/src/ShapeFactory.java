import java.awt.*;

public class ShapeFactory {
public static Shapes getShapes(String type, Color color){
  if(type.equalsIgnoreCase("plate"))
      return new Plate(color);
  return null;
}
}
