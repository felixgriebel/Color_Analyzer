import java.awt.*;

public class SinglePixelGetter extends ColorGetter {
    public Color getColor(int size) {
        try {
            Robot rob = new Robot();
            Point current = MouseInfo.getPointerInfo().getLocation();

            return rob.getPixelColor(current.x, current.y);


        } catch (Exception e) {
            System.out.println("error");
            return Color.BLACK;
        }
    }
}
