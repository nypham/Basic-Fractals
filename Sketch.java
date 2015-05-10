/*Ny Pham
 * This class will be used to create lines and
 * fractals in a new window.*/
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Sketch
{
  //stores a window
  JFrame frame;
  //stores the canvas that will be drawn on
  Canvas canvas;
  //stores the graphics needed to draw each object
  Graphics graphics;
  
  /*this creates the window that the drawn objects will show up on*/
  public Sketch (int width, int height)
  {
   frame = new JFrame();
   canvas = new Canvas(); 
   canvas.setSize(width, height);
   canvas.setBackground(Color.WHITE);
   frame.getContentPane().add(canvas, "Center");
   frame.setSize(width, height);
   frame.setVisible(true);
  }
  
  /*returns the graphics context that is needed to draw in the new
   * window*/
  public Graphics getGraphics()
  {
    if(graphics != null)
    {
      return graphics;
    }
    else
    {
      graphics = canvas.getGraphics();
      graphics.setColor(Color.BLACK);
      return graphics;
    }
  }
  
  /*draws a line between two points in the new window*/
  public void drawLine (Line line)
  {
   if(graphics == null)
   {
   }
   else
   {
     line.draw(getGraphics());
   }
  }
  
  /*draws a box in the new window if there are no fractals.
   * If there are fractals, a box was the fractal _/\_
   * is drawn on each side with the specified number of layers.
   *
   * @param size - represents the lenght of the sides of the box
   * @param numLayers - represents the number of layers of fractals*/
  public void drawBoxFlake (int size, int numLayers)
  {
    if(graphics == null)
    {
    }
    else
    {
      //stores the width of the canvas being drawn on
      int width = canvas.getWidth();
      //stores the height of the canvas being drawn on
      int height = canvas.getHeight();
      //stores the top line of the square being drawn
      Line topLine = new Line(new Point((int)((width - size) / 2), (int)((height - size) / 2)), new Point((int)((width + size) / 2), (int)((height - size) / 2)));
      //stores the right line of the square being drawn
      Line rightLine = new Line(topLine.getSecondPoint(), new Point((int)((width + size) / 2), (int)((height + size) / 2)));
      //stores the bottom line of the square being drawn
      Line bottomLine = new Line(rightLine.getSecondPoint(), new Point(((int)(width - size) / 2), (int)((height + size) / 2)));
      //stores the left line of the square being drawn
      Line leftLine = new Line(bottomLine.getSecondPoint(), topLine.getFirstPoint());
      if (numLayers <= 0)
      {
        topLine.draw(getGraphics());
        rightLine.draw(getGraphics());
        bottomLine.draw(getGraphics());
        leftLine.draw(getGraphics());
      }
      else
      {
        //stores the top fractal of the fractal being drawn
        Fractal topFractal = new Fractal(topLine, numLayers);
        //stores the right fractal of the fractal being drawn
        Fractal rightFractal = new Fractal(rightLine, numLayers);
        //stores the bottom fractal of the fractal being drawn
        Fractal bottomFractal = new Fractal(bottomLine, numLayers);
        //stores the left fractal of the fractal being drawn
        Fractal leftFractal = new Fractal(leftLine, numLayers);
        topFractal.draw(getGraphics());
        rightFractal.draw(getGraphics());
        bottomFractal.draw(getGraphics());
        leftFractal.draw(getGraphics());
      }
    }
  }
  
  /*draws an equilateral triangle in the new window if 
   * there are no fractals.If there are fractals, a box 
   * was the fractal _/\_is drawn on each side with the
   * specified number of layers.
   *
   * @param size - represents the length of the triangle
   * @param numLayers - represents the number of layers of fractals*/
  public void drawSnowFlake(int size, int numLayers)
  {
    if(graphics == null)
    {
    }
    else
    {
      //stores the width of the canvas being drawn on
      int width = canvas.getWidth();
      //stores the height of the canvas being drawn on
      int height = canvas.getHeight();
      //stores the right line of the triangle being drawn
      Line rightLine = new Line(new Point((int)(width / 2), (int)((height / 2) - ((Math.sqrt(3) * size * 2) / 6))), new Point ((int)((width + size) / 2), (int)((height / 2) + ((Math.sqrt(3) * size) / 6))));
      //stores the bottom line of the triangle being drawn
      Line bottomLine = new Line(rightLine.getSecondPoint(), new Point((int)((width - size) / 2), (int) ((height / 2) + ((Math.sqrt(3) * size) / 6))));
      //stores the left line of the triangle being drawn
      Line leftLine = new Line(bottomLine.getSecondPoint(), rightLine.getFirstPoint());
      if (numLayers <= 0)
      {
        rightLine.draw(getGraphics());
        bottomLine.draw(getGraphics());
        leftLine.draw(getGraphics());
      }
      else 
      {
        //stores the right fractal of the fractal being drawn
        Fractal rightFractal = new Fractal(rightLine, numLayers);
        //stores the bottom fractal of the fractal being drawn
        Fractal bottomFractal = new Fractal(bottomLine,numLayers);
        //stores the left fractal of the fractal being drawn
        Fractal leftFractal = new Fractal(leftLine, numLayers);
        rightFractal.draw(getGraphics());
        bottomFractal.draw(getGraphics());
        leftFractal.draw(getGraphics());
      }
    }
  }
}
