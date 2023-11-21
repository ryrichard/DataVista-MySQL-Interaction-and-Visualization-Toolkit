package com.example.colorsandshapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class MyArc extends MyShape{

    boolean debug = true;
    MyPoint p;
    MyColor c;
    double r;
    double startAngle;
    double endAngle;
    MyOval oval;
    public MyArc(MyOval oval, double startAngle, double endAngle, MyColor c)
    {
        super(oval.getPoint(), c);
        this.p = new MyPoint();
        this.p.setPoint(super.p);
        setColor(super.c);
        this.c = super.c;
        this.oval = new MyOval(oval);
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

//    public MyArc(MyArc arc)
//    {
//        p = arc.getPoint();
//        c = arc.getColor();
//        r = arc.getRadius();
//        startAngle = arc.getStartAngle();
//        endAngle = arc.GetEndAngle();
//        oval = arc.GetOval();
//    }

    //Set
    @Override
    public void setDebug(boolean debug) { this.debug = debug; }
    public void setPoint(MyPoint p) { this.p.setPoint(p); }
    public void setColor(MyColor c) {this.c = c; }

    //Get
    double getRadius() { return r; }
    double getAngle() { return endAngle - startAngle; }
    @Override
    double getPerimeter() { return 2 * getRadius() + getLength(); }
    public MyPoint getPoint() { return p; }
    @Override
    public double getArea()
    {
        double angle = endAngle - startAngle;
        double area = Math.pow(r, 2) * (angle - Math.sin(angle));
        return area;
    }
    public double getLength() { return (2*Math.PI * r) * (getAngle() / 360.0); }
    public MyRectangle getMyBoundingRectangle()
    {
        MyRectangle bbox = new MyRectangle(oval.getPoint(), oval.getWidth(), oval.getHeight(), MyColor.BLACK);
        return bbox;
    }

    //Method
    @Override
    public void Draw( GraphicsContext g )
    {
        g.setFill(c.getJavaFXColor());
        g.fillArc(p.x, p.y, oval.getWidth(), oval.getHeight(), startAngle, endAngle, ArcType.ROUND);
    }
    public boolean pointInMyShape(MyPoint p1)
    {
        double x = p1.x - p.x;
        double y = p1.y - p.y;
        double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        boolean withinRadius = getRadius() > r;

        double angle = p.angleOfPointToXAxis(p1);

        return (angle < endAngle && angle > startAngle) && r <= getRadius();
    }
    public String toString() { return "MyArc"; }

    public void debugThis()
    {
        if(debug) System.out.println("----MyArc Info----" + '\n' +
                                    "MyPoints:" + p.toString() + '\n' +
//                                  "MyColor: " + getColor() + '\n' +
//                                  "Diameter: " + getHeight() + '\n' +
                                    "Perimeter: " + getPerimeter() + '\n' +
                                    "Area: " + getArea());
    }

}


/*
* Javafx > fillArc: https://www.demo2s.com/java/javafx-graphicscontext-fillarc-double-x-double-y-double-w-double-h.html
* */
