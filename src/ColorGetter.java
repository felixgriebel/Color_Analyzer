import java.awt.*;

public abstract class ColorGetter {
    public static String getHEX(Color color) {
        StringBuilder builder = new StringBuilder();
        builder.append('#');
        builder.append(Integer.toHexString(color.getRGB()).substring(2));

        return builder.toString();
    }

    public abstract Color getColor(int size);
}
