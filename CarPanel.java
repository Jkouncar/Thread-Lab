import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class CarPanel extends JComponent {
    private Car car1;
    private int x, y, delay;
    private CarQueue carQueue;
    private int direction;

    // Constructor for initializing the CarPanel
    public CarPanel(int initialX, int initialY, int animationDelay, CarQueue queue) {
        delay = animationDelay;
        x = initialX;
        y = initialY;
        car1 = new Car(x, y, this);
        carQueue = queue;
    }

    // Method to start the animation
    public void startAnimation() {
        // Runnable for handling the animation logic
        Runnable animationRunnable = () -> {
            try {
                // Run the animation for a fixed number of iterations (e.g., 10 times)
                for (int i = 0; i < 10; i++) {
                    Integer directionInteger = carQueue.deleteQueue();

                    if (directionInteger != null) {
                        // Retrieve the direction from the queue
                        direction = directionInteger.intValue();
                        
                        // Update the car's position based on the direction
                        updateCarPosition();
                        
                        // Repaint the component to reflect the new position
                        repaint();
                        
                        // Introduce a delay to control the animation speed
                        Thread.sleep(delay * 1000);
                    } else {
                        // Handle the case when the queue is empty
                        // For example, you might want to break out of the loop or add more directions to the queue
                    }
                }
            } catch (InterruptedException exception) {
                // Handle the exception if needed
            } finally {
                // Any cleanup code can go here
            }
        };

        // Create a new thread for running the animation
        Thread animationThread = new Thread(animationRunnable);
        animationThread.start();
    }

    // Method to update the car's position based on the current direction
    private void updateCarPosition() {
        switch (direction) {
            case 0:
                y = Math.max(0, y - 10); // Move upward
                break;
            case 1:
                y = Math.min(getHeight() - 30, y + 10); // Move downward
                break;
            case 2:
                x = Math.min(getWidth() - 60, x + 10); // Move rightward
                break;
            case 3:
                x = Math.max(0, x - 10); // Move leftward
                break;
        }
    }

    // Override the paintComponent method to draw the car
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        car1.draw(g2, x, y);
    }
}
