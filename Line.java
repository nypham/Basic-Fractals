/*Ny Pham
 * This class will represent a two-dimensional line segment.
 * Points from the line can be obtained and manipulated from 
 * this class*/
import java.awt.Graphics;

public class Line 
{
  //stores information on the starting point of the line
  private Point start;
  //stores information on the ending point of the line
  private Point end;
  
  /*initilizes the starting and ending point of the line*/
  public Line (Point start, Point end)
  {
    this.start = start;
    this.end = end;
  }
  
  /*assigns coordinate points to starting and ending point*/
  public Line (int x1, int y1, int x2, int y2)
  {
    start = new Point(x1,y1);
    end = new Point(x2,y2);
  }
  
  /*returns the value of first point on line segment*/
  public Point getFirstPoint()
  {
    return start;
  }
  
  /*sets the values for the first point on the line segment*/
  public void setFirstPoint (Point point)
  {
    start = point;
  }
  
  /*returns the value of second point on line segment*/
  public Point getSecondPoint()
  {
    return end;
  }
  
  /*sets the values for the second point on the line segment*/
  public void setSecondPoint(Point point)
  {
    end = point;
  }
  
  /*draws a straight line between the two points*/
  public void draw(Graphics graphics)
  {
    graphics.drawLine((getFirstPoint().getX()), (getFirstPoint().getY()), (getSecondPoint().getX()), (getSecondPoint().getY()));
  }
}

    