package com.example.colorsandshapes;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

public interface MyShapeInterface {

    //abstract method returns the bounding rectangle of an object in the class hierarchy
    abstract MyRectangle getMyBoundingRectangle();

    //abstract method returns true if a point p is located within or on the boundary of an object in the class hierarchy
    abstract boolean pointInMyShape(MyPoint p1);

    static void DrawBoundingBox(GraphicsContext g, MyShape s)
    {
        MyRectangle bbox = new MyRectangle(s.getMyBoundingRectangle());
        MyPoint p = new MyPoint(bbox.getPoint());
        double h = bbox.getHeight();
        double w = bbox.getWidth();
        g.setFill( MyColor.BLACK.getJavaFXColor() );

        //draw box (point(x), point(y), width, height)
        g.fillRect( p.x, p.y, 1, h ); //left line
        g.fillRect( p.x, p.y, w, 1 ); //top line
        g.fillRect( p.x + w - 1, p.y, 1, h ); //right line
        g.fillRect( p.x, p.y + h - 1, w, 1 ); //bottom line
    }

    //returns true if two MyShape objects S1 and S2 are similar
    static boolean SimilarObjects(MyShape s1, MyShape s2)
    {
        //check if they are same class
//        System.out.println(s1.toString() + " " + s2.toString());
        if(s1.toString() != s2.toString()) return false;
        //check if they have same parameters
        else return (s1.getArea() == s2.getArea()) && (s1.getPerimeter() == s2.getPerimeter());
    };

    //static method returns the intersection of two MyRectangles objects R1 and R2 if they do overlap, and null otherwise
    static List<MyPoint> intersectMyRectangles(MyRectangle r1, MyRectangle r2)
    {
        MyPoint initP = new MyPoint(r1.getPoint());
        MyPoint endP = new MyPoint(r1.getPoint().getX() + (int)r1.getWidth(), r1.getPoint().getY() + (int)r1.getHeight());
        List<MyPoint> p_list = new ArrayList<MyPoint>();

        for(int x = initP.getX(); x < endP.getX(); x++)
        {
            for(int y = initP.getY(); y < endP.getY(); y++)
            {
                //changing old point will change all point in list. must make new point
                MyPoint p = new MyPoint(x, y);
                if(r2.pointInMyShape(p))
                    p_list.add(p);
            }
        }

        return p_list;
    };

    //static method returns the set of all points on or within the boundary of the area of intersection of two
    //MyShape objects S1 and S2 if they do overlap, and null otherwise
    static List<MyPoint> intersectMyShape(MyShape s1, MyShape s2, List<MyPoint> p_list)
    {
        List<MyPoint> p2_list = new ArrayList<MyPoint>();

        for(MyPoint p: p_list)
            if(s1.pointInMyShape(p) && s2.pointInMyShape(p)) p2_list.add(p);

        return p2_list;
    }

    //default method returns a canvas with a drawing of the intersection of two objects in the class hierarchy if they do overlap
    default void drawIntersectMyShapes(GraphicsContext g, List<MyPoint> p_list)
    {
        for(MyPoint p: p_list)
        {
            g.setFill( MyColor.PURPLE.getJavaFXColor() );
            g.fillOval( p.x, p.y, 1, 1 );
        }
    }
}
