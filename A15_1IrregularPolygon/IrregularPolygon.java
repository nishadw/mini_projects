// import java.awt.Color;

import java.awt.geom.*;
import java.util.*;
import gpdraw.*;

/**
 * @author Nishad
 * @version 11/8
 * @author Period - 6
 * @author Assignment - irregular polygon
 * @author Sources - me
 */
public class IrregularPolygon
{
    private DrawingTool               pen; // = new DrawingTool( new SketchPad(
                                           // 300, 300, 0 ) );
    private ArrayList<Point2D.Double> myPolygon;

    // constuctors
    /**
     * creates the polygon with the arraylist
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();

    }

    // public methods


    /**
     * @param aPoint
     *            adds a point to the list
     */
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }


    /**
     * @return the perimeter of polygon
     */
    public double perimeter()
    {
        double perimeter = 0.0;
        double x = 0.0;
        double y = 0.0;
        for (int i = 0; i < myPolygon.size(); i++)
        {
            if (i + 1 == myPolygon.size())
            {
                x = Math.pow(myPolygon.get(i).getX() - 
                                myPolygon.get(0).getX(), 2);
                y = Math.pow(myPolygon.get(i).getY() - 
                                myPolygon.get(0).getY(), 2);
                perimeter += Math.sqrt(x + y);
            }

            else
            {
                x = Math.pow(myPolygon.get(i + 1).getX() - 
                                myPolygon.get(i).getX(), 2);
                y = Math.pow(myPolygon.get(i + 1).getY() - 
                                myPolygon.get(i).getY(), 2);
                perimeter += Math.sqrt(x + y);
            }
        }
        return perimeter;
    }


    /**
     * @return the area
     */
    public double area()
    {
        double areaX = 0.0;
        double areaY = 0.0;
        double finalArea = 0.0;

        for (int i = 0; i < myPolygon.size(); i++)
        {
            if (i + 1 == myPolygon.size())
            {
                areaX += myPolygon.get(i).getX() * 
                            myPolygon.get(0).getY();
            }
            else
            {
                areaX += myPolygon.get(i).getX() * 
                            myPolygon.get(i + 1).getY();
            }
        }

        for (int i = 0; i < myPolygon.size(); i++)
        {
            if (i + 1 == myPolygon.size())
            {
                areaY += myPolygon.get(0).getX() * 
                            myPolygon.get(i).getY();
            }
            else
            {
                areaY += myPolygon.get(i + 1).getX() * 
                            myPolygon.get(i).getY();
            }
        }

        finalArea = Math.abs(areaX - areaY) * 0.5;
        return finalArea;

    }


    /**
     * draws the polygon
     */
    public void draw()
    {
        pen.up(); // no draw
        pen.move(myPolygon.get(0).getX(), 
                myPolygon.get(0).getY()); // original
                                          // coord
        pen.down(); // yes draw

        for (int i = 1; i < myPolygon.size(); i++)
        {
            pen.move(myPolygon.get(i).getX(), 
                    myPolygon.get(i).getY());
        }

        pen.move(myPolygon.get(0).getX(), 
                myPolygon.get(0).getY());
    }
}
