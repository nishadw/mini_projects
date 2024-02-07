import java.awt.*;
import javax.swing.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.
  
   @author  TODO Your Name
   @version TODO Date

   Period - TODO Your Period
   Assignment - A12.6 - ParallelLines

   Sources - TODO list collaborators
 */
public class ParallelLines extends JPanel
{
  // TODO Your Instance Variables Here
    
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    
    int width = getWidth();    
    int height = getHeight();
    
    drawIllusion(g, width, height);
  }

  /**
     TODO Write your method description here.
     @param g
     @param width
     @param height
     @param size
   */
  public void drawIllusion(Graphics g, int width, int height)
  {
    // TODO Your Code Here
    // initialize horizontal offset
    int hoffset; 
    for ( int row = 0; row < 8; row++ )
    {
      // calculate and add a horizontal offset
      if (row == 0 || row == 4) {
        hoffset = 0;
      }
      else if (row == 1 || row == 3 || row == 5 || row == 7 ) {
        hoffset = width / 42;
      }
      else {
        hoffset = width / 21;
      }

      for ( int col = 0; col < 7; col++ ) {
        // draw the square
        g.fillRect((col * (width/7)) + hoffset, (row) * (height / 8), width / 14, height / 8);
      }
      
      // calculate the location and draw the line
      g.drawLine(0, (row + 1) * (height / 8), width, (row + 1) * (height / 8));
    }
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("ParallelLines");
    w.setBounds(100, 100, 640, 480); //100, 100, 640, 480
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ParallelLines panel = new ParallelLines();
    panel.setBackground(Color.WHITE);
    Container c = w.getContentPane();
    c.add(panel);
    w.setResizable(true);
    w.setVisible(true);
  }
}
