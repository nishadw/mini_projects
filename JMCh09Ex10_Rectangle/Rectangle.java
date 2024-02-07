/**
 * Create Rectangle class per instructions in lab.
 *
 * @author TODO
 * @version TODO
 * @author Period: TODO
 * @author Assignment: JMCh09Ex10_Rectangle
 */

public class Rectangle {
    private int width, height;

    public Rectangle (int w, int h) {
        width = w;
        height = h;
        if (w <= 0 || h <= 0) {
            throw new IllegalArgumentException("Width or Height = 0");
        }
    }

    public Rectangle (int s) {
        width = s;
        height = s;
        if (s <= 0) {
            throw new IllegalArgumentException("Width or Height = 0");
        }
    }

    public Rectangle () {
        width = 1;
        height = 1;
    }

    public boolean isSquare () {
        //width = w;
        //height = h;
        if (width == height) {
            return true;
        }
        return false;
    }

    public void quadratize () {
        double area = width * height;
        double s = Math.sqrt(area);
        int x = (int) Math.round(s);
        width = x;
        height = x;
        //System.out.println(x);
    }

    public String toString() {
        return width + " x " + height;
    }
}