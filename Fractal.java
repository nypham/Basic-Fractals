/*Ny Pham
 * This class will represent the two-dimensional fractal shape _/\_ 
 * The first _ and last _ will be represented by line1 and line4, respectively.
 * The / and \ will be represented by line2 and line3, respectively.*/
import java.awt.Graphics;

public class Fractal
{
  //stores information on line 1 of the fractal.
  private Line line1;
  //stores information on line 2 of the fractal.
  private Line line2;
  //stores information on line 3 of the fractal.
  private Line line3;
  //stores information on line 4 of the fractal.
  private Line line4;
  //stores information on fractal 1*/
  private Fractal fractal1;
  //stores information on fractal 2*/
  private Fractal fractal2;
  //stores information on fractal 3*/
  private Fractal fractal3;
  //stores information on fractal 4*/
  private Fractal fractal4;
  
  /*initilizes the lines and fractals*/
  public Fractal (Line line, int numberOfFractals)
  {
    //stores the first point of the line, also represents the first point of line 1
    Point point1 = line.getFirstPoint();
    //stores the second point of the line, also represents the last point of line 4
    Point point5 = line.getSecondPoint();
    //stores the second point of line 1
    Point point2 = new Point(point1.getX() + ((point5.getX() - point1.getX()) / 3), point1.getY() + ((point5.getY() - point1.getY()) / 3));
    //stores the first point of line 4
    Point point4 = new Point(point1.getX() + ((point5.getX() - point1.getX()) * 2 / 3), point1.getY() + ((point5.getY() - point1.getY()) * 2 / 3));
    //adjust and temporarily stores the point that is to be rotated
    Point temporaryPoint = new Point(point2.getX() - point4.getX(), point2.getY() - point4.getY());
    temporaryPoint.rotate(Math.PI / 3);
    //stores the point of the tip of the equilateral triangle formed by the fractal
    Point point3 = new Point(temporaryPoint.getX() + point4.getX(), temporaryPoint.getY() + point4.getY());
    line1 = new Line(point1, point2);
    line2 = new Line(point2, point3);
    line3 = new Line(point3, point4);
    line4 = new Line(point4, point5);
    if (numberOfFractals > 1)
    { 
      fractal1 = new Fractal(line1, numberOfFractals - 1);
      fractal2 = new Fractal(line2, numberOfFractals - 1);
      fractal3 = new Fractal(line3, numberOfFractals - 1);
      fractal4 = new Fractal(line4, numberOfFractals - 1);
    }
  }
  
  /*returns line 1 of the fractal*/
  public Line getLine1()
  {
    return line1;
  }
  
  /*returns line 2 of the fractal*/
  public Line getLine2()
  {
    return line2;
  }
  
  /*returns line 3 of the fractal*/
  public Line getLine3()
  {
    return line3;
  }
  
  /*returns line 4 of the fractal*/
  public Line getLine4()
  {
    return line4;
  }
  
  /*returns fractal 1 of the fractal*/
  public Fractal getFractal1()
  {
    return fractal1;
  }
  
  /*returns fractal 2 of the fractal*/
  public Fractal getFractal2()
  {
    return fractal2;
  }
  
  /*returns fractal 3 of the fractal*/
  public Fractal getFractal3()
  {
    return fractal3;
  }
  
  /*returns fractal 4 of the fractal*/
  public Fractal getFractal4()
  {
    return fractal4;
  }
  
  /*draws the fractal formed by the constructor*/
  public void draw (Graphics graphics)
  {
    if(fractal1 != null)
    {
      getFractal1().draw(graphics);
    }
    else
    {
      getLine1().draw(graphics);
    }
    if(fractal2 != null)
    {
      getFractal2().draw(graphics);
    }
    else
    {
      getLine2().draw(graphics);
    }
    if(fractal3 != null)
    {
      getFractal3().draw(graphics);
    }
    else
    {
      getLine3().draw(graphics);
    }
    if(fractal4 != null)
    {
      getFractal4().draw(graphics);
    }
    else
    {
      getLine4().draw(graphics);
    }
  }
}
