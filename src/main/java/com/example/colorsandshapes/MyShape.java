package com.example.colorsandshapes;
import javafx.scene.canvas.GraphicsContext;

abstract class MyShape extends Object implements MyShapeInterface{
    public MyPoint p; //must be overridden
    public MyColor c; //must be overridden
    private boolean debug = true;
    public MyShape(){};
    public MyShape(MyShape s){};
    public MyShape(MyPoint p, MyColor c)
    {
        this.p = new MyPoint();
        this.p.setPoint(p);
        this.c = c;
    }

    //get
    abstract double getArea();
    abstract double getPerimeter();
    abstract MyPoint getPoint();

    //set
    abstract void setDebug(boolean debug);
    public void setPoint(MyPoint p) { this.p = p; }
    public void setColor(MyColor c) { this.c = c; }
    public String toString(){ return "This is MyShape Object"; }
    abstract void Draw(GraphicsContext g);
}
