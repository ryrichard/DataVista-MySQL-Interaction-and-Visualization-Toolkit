    package com.example.colorsandshapes;
    //import javafx.scene.paint.Color;
    import javafx.scene.canvas.GraphicsContext;
    import java.lang.Math;

    public class MyOval extends MyShape{
        double h;
        double w;
        double r;
        MyPoint p;
        MyColor c;
        boolean debug = true;
        public MyOval(){};
        public MyOval(MyPoint p, double h, double w, MyColor c)
        {
            super(p, c);
            this.p = new MyPoint();

            this.p.setPoint(super.p);
            setColor(super.c);
            this.h = h;
            this.w = w;
            this.r = h / 2;
        }

        //Copy Constructor
        public MyOval(MyOval oval)
        {
            this.h = oval.getHeight();
            this.w = oval.getWidth();
            this.r = oval.getRadius();
            this.p = oval.getPoint();
            this.c = oval.getColor();
        }

        //Set
        @Override
        public void setDebug(boolean debug) { this.debug = debug; }
        //as of now, radius is treated as height and width, i.e. ovals are circles
        public void setRadiusX(double rx) { this.h = rx; }
        public void setRadiusY(double ry) { this.w = ry; }
        public void setColor(MyColor c) { this.c = c; }
        public void setPoint(MyPoint p) { this.p.setPoint(p); }

        //Get
        public MyPoint getPoint() { return new MyPoint(p); }
        public double getRadius() { return r; }
        public double getHeight() { return h; }
        public double getWidth() { return w; }
        public double getUpperLeftX() { return getCenter().x - (Math.cos(Math.toRadians(45)) * getRadius()); } // get upperleft(x) bound
        public double getUpperLeftY() { return getCenter().y - (Math.cos(Math.toRadians(45)) * getRadius()); } // get upperleft(y) bound
        public double getDiameterX() { return h; }
        public double getDiameterY() { return w; }

    //    public MyPoint getCenter() {return new MyPoint(h/2, w/2);} //leftover, may be relevant
        public MyPoint getCenter() {return new MyPoint((int)h/2 + p.y, (int)w/2 + p.x);} //with oval's position on canvas in mind

        public MyPoint getUpperLeft()
        {
    //        double rx = getWidth();
    //        double ry = getHeight();
    //        double x = h - (Math.cos(Math.toRadians(45)) * rx);
    //        double y = w - (Math.sin(Math.toRadians(45)) * ry);
            int x = (int)getUpperLeftX();
            int y = (int)getUpperLeftY();
    //        System.out.println("x: " + x + " y: " + y);
            return new MyPoint(x, y);
        }
        public MyColor getColor() { return c; }
        @Override
        public double getArea() { return Math.PI * Math.pow(getRadius(), 2); }
        @Override
        public double getPerimeter() { return 2 * Math.PI * getRadius(); }
        @Override
        public MyRectangle getMyBoundingRectangle() //return the box that surrounds the oval
        {
            MyRectangle bbox = new MyRectangle(getPoint(), getWidth(), getHeight(), MyColor.BLACK);
            return bbox;
        }
        public String toString() { return "class MyOval"; }

        //Methods
        @Override
        public void Draw(GraphicsContext gc)
        {
            gc.setFill( c.getJavaFXColor() );
            gc.fillOval( p.x, p.y, h, w );
    //        gc.fillOval( p.x - rx, p.y - ry, p.x + rx, p.y + ry );
        }
        public boolean pointInMyShape(MyPoint p1)
        {
            double x = p1.x - getCenter().getX();
            double y = p1.y - getCenter().getY();
            double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            System.out.println("Sqrt(" + x + "^2 + " + y + "^2 = " + r + " < " + getRadius());

            return (r <= getRadius());
        }
        public void debugThis()
        {
            if(debug)
            {
                System.out.println("----MyOval Info----" + '\n' +
                                   "MyPoints:" + p.toString() + '\n' +
                                   "MyColor: " + getColor() + '\n' +
                                   "Diameter: " + getHeight() + '\n' +
                                   "Perimeter: " + getPerimeter() + '\n' +
                                   "Area: " + getArea());
            }
        }
    }
