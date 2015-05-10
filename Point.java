/*Ny Pham
 * This class will represent a two-dimensional point.The point can be 
 * rotated and manipulated with methods in this class.*/
public class Point
{
  
  //stores x-coordinate of point
  private int x = 0;
  //stores y-coordinate of point
  private int y = 0;
  
  /*initializes the x and y-component of the point*/
  public Point (int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  
  /*returns the value of x-coordinate of point*/
  public int getX()
  {
    return x;
  }
  
  /*changes x-coordinate of the point*/
  public void setX (int x)
  {
    this.x = x;
  }
  
  /*returns the value of y-coordinate of point*/
  public int getY()
  {
    return y;
  }
  
  /*changes y-coordinate of the point*/
  public void setY (int y)
  {
    this.y = y;
  }
  
  /*returns the angle,in radians, between the positive 
   * x-axis and the vector from the origin to the point. This is 
   * supposing the vector was rotated counter-clockwise from the 
   * positive x-axis*/
  public double getAngle()
  {
    /*the conditonal statements are to adjust for the different directions
     * the program tries to obtain the angle from. For example, for an angle
     * greater than 270 degrees or 3Pi/2, the program would take the angle clockwise.*/
    if (x >= 0)
    {
      if (y >= 0) 
      {
        return Math.acos(x / (Math.sqrt((x * x) + (y * y))));
      }
      else
      {
        return ((Math.PI) * 2) + Math.asin(y / (Math.sqrt((x * x) + (y * y))));
      }
    }
    else 
    {
      if (y > 0)
      {
        return Math.PI -  Math.asin(y / (Math.sqrt((x * x) + (y * y))));
      }
      else if (y < 0)
      {
        return (2 * Math.PI) - Math.acos(x / (Math.sqrt((x * x) + (y * y))));
      }
      else
      {
        return Math.PI;
      }
    }
  }
  
  /*rotates the vector from the origin to the original point by input angle*/
  public void rotate(double angle)
  {
    //temporarily stores the new x-coordinate
    double newX = (x * Math.cos(angle)) - (y * Math.sin(angle)); 
    //temporarily stores the new y-coordinate
    double newY = (x * Math.sin(angle)) + (y * Math.cos(angle));
    //stores the decimal place of the new x-coordinate
    double xDecimal = newX - (int) newX;
       if (xDecimal >= 0.5)                                               
       {
         x = (int) newX + 1;
       }
       else 
       {
         x = (int) newX;
       }
    //stores the decimal place of the new y-coordinate
    double yDecimal = newY - (int) newY;                                   
       if (yDecimal >= 0.5) 
       {
         y = (int) newY + 1;
       }
       else 
       {
         y = (int) newY;
       }
  }
}
