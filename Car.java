import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

/**
 * A representation of a car that can be positioned on the screen.
 */
public class Car {
    private int xLeft;
    private int yTop;
    private JComponent component;

    /**
     * Constructs a car with a specified top-left corner.
     *
     * @param x the x-coordinate of the top-left corner
     * @param y the y-coordinate of the top-left corner
     * @param aComponent the JComponent associated with the car
     */
    public Car(int x, int y, JComponent aComponent) {
        xLeft = x;
        yTop = y;
        component = aComponent;
    }

    /**
     * Draws the car on the screen.
     *
     * @param g2 the graphics context
     * @param xLeft the x-coordinate of the top-left corner of the car
     * @param yTop the y-coordinate of the top-left corner of the car
     */
    public void draw(Graphics2D g2, int xLeft, int yTop) {
        try {
            Rectangle body = new Rectangle(xLeft, yTop + 10, 60, 10);
            Ellipse2D.Double frontTire = new Ellipse2D.Double(xLeft + 10, yTop + 20, 10, 10);
            Ellipse2D.Double rearTire = new Ellipse2D.Double(xLeft + 40, yTop + 20, 10, 10);

            // Define points for car windshield and roof
            Point2D.Double r1 = new Point2D.Double(xLeft + 10, yTop + 10); // Bottom of the front windshield
            Point2D.Double r2 = new Point2D.Double(xLeft + 20, yTop);      // Front of the roof
            Point2D.Double r3 = new Point2D.Double(xLeft + 40, yTop);      // Rear of the roof
            Point2D.Double r4 = new Point2D.Double(xLeft + 50, yTop + 10); // Bottom of the rear windshield

            Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
            Line2D.Double roofTop = new Line2D.Double(r2, r3);
            Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

            // Draw the car components
            g2.draw(body);
            g2.draw(frontTire);
            g2.draw(rearTire);
            g2.draw(frontWindshield);
            g2.draw(roofTop);
            g2.draw(rearWindshield);
        } finally {
            // Any necessary cleanup code can be added here
        }
    }
}
