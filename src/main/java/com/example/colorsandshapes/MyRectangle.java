package com.example.colorsandshapes;
//import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape {
    private double h;
    private double w;
    private MyPoint p;
    private MyColor c;
    boolean debug = true;
    public MyRectangle(MyPoint p, double h, double w, MyColor c)
    {
        super(p, c);
        this.p = new MyPoint();
        this.p.setPoint(super.p);
        setColor(super.c);
        this.h = h;
        this.w = w;
    }

    //Copy Constructor
    public MyRectangle(MyRectangle rectangle)
    {
        h = rectangle.getHeight();
        w = rectangle.getWidth();
        p = rectangle.getPoint();
        c = rectangle.getColor();
    }

    //Set
    @Override
    public void setDebug(boolean debug) { this.debug = debug; }
    public void setWidth(double w) { this.w = w; }
    public void setHeight(double h) { this.h = h; }
    public void setParameters(double h, double w) { this.w = w; this.h = h; }
    public void setColor(MyColor c) { this.c = c; }
    public void setPoint(MyPoint p) { this.p.setPoint(p); }

    //Get
    public MyPoint getPoint() { return new MyPoint(p); }
    public double getWidth() { return w; }
    public double getHeight() { return h; }
    public MyColor getColor() { return c; }
    public double getSideOfSquare(double d)
    {
        return (Math.cos(Math.toRadians(45)) * d);
    }
    @Override
    public double getPerimeter() { return (2*h) + (2*w); }
    @Override
    public double getArea() { return h * w; }
    @Override
    public MyRectangle getMyBoundingRectangle()
    {
//        MyRectangle bbox = new MyRectangle(getPoint(), getHeight(), getWidth(), MyColor.BLACK);
        return this;
    }
    @Override
    public String toString() {return "class MyRectangle";}


    //Methods
    @Override
    public void Draw(GraphicsContext gc)
    {
        gc.setFill( c.getJavaFXColor() );
        gc.fillRect( p.x, p.y, h, w );
    }

    public boolean pointInMyShape(MyPoint p1)
    {
        return (p1.x >= p.x && p1.x <= p.x + getWidth()) &&
                (p1.y >= p.y && p1.y <= p.y + getHeight());
    }
    public void debugThis()
    {
        if(debug)
        {
            System.out.println("----MyRectangle Info----" + '\n' +
                    "MyPoints:" + p.toString() + '\n' +
                    "MyColor: " + c + '\n' +
                    "Height: " + getHeight() + '\n' +
                    "Width: " + getWidth() + '\n' +
                    "Perimeter: " + getPerimeter() + '\n' +
                    "Area: " + getArea());
        }
    }
}
