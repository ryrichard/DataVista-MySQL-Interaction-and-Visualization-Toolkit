package com.example.colorsandshapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class Slice extends MyArc{

    MyColor color;
    MyCircle circle;
    MyPoint point;
    double startAngle;
    double endAngle;
    double radius;
    public Slice(MyCircle circle, double startAngle, double endAngle, MyColor color)
    {
        super(circle, startAngle, endAngle, color);
        this.point = new MyPoint(super.p);
        this.color = super.c;
        this.circle = new MyCircle(circle);
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        Debug();
    }

    public void Draw( GraphicsContext g )
    {
        g.setFill(color.getJavaFXColor());
        g.fillArc(point.x, point.y, circle.getWidth(), circle.getHeight(), startAngle, endAngle, ArcType.ROUND);
    }

    public String toString() { return "Slice"; }

    public void Debug()
    {
        System.out.print("---------SLICE INFO---------" +
                        "\nMyPoint:" + point.toString() +
                        "\nStartAngle: " + startAngle +
                        "\nEngAngle: " + endAngle +
                        "\nMyColor: " + color + "\n");
    }
}
