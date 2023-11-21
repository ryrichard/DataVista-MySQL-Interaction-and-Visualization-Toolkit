package com.example.colorsandshapes;
//import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class MyPoint {

    boolean debug = false;
    int x;
    int y;
    MyColor color;

    //Empty constructor
    public MyPoint() {}

    //Constructor and Set methods
    public MyPoint(int x, int y) {
        this.x = x; this.y = y;
        color = MyColor.BLACK;

        if(debug)
            System.out.println("MyPoint: x=" + this.x + ", y=" + this.y);
    }

    public MyPoint(MyPoint p)
    {
        this.x = p.x;
        this.y = p.y;
    }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setPoint(int x, int y) { this.x = x; this.y = y; }
    public void setPoint(MyPoint p) { x = p.getX(); y = p.getY(); }
    public void setColor(MyColor c) { color = c; }

    //Get methods
    public int getX() { return x; }
    public int getY() { return y; }
    public MyPoint getPoint() { return new MyPoint(x, y); }
    public MyColor getColor() { return color; }

    //shift point
    public void shift(int x, int y) { setPoint(this.x += x, this.y += y); }

    //get distance from origin
    public double distanceToOrigin() { return Math.sqrt(x * x + y * y); }

    public double distanceToPoint(MyPoint p) {
        double newX = x - p.getX();
        double newY = y - p.getY();
        return Math.sqrt(newX * newX + newY * newY);
    }

    public void Draw(GraphicsContext gc)
    {
        gc.setFill( color.getJavaFXColor() );
        gc.fillOval( x, y,1,1 );
    }

    public double angleOfPointToXAxis(MyPoint p1) //angle from this.point to parameter point
    {
        double angle =  (double) Math.toDegrees(
                Math.atan2(p1.x - x, p1.y - y));

        if(angle < 0) { angle += 360; } //adds 360 if neg, otherwise get results like -90.

        return angle;
    }

    public String toString() { return "(" + x + ", "+ y +")" ;}

}
