package com.example.colorsandshapes;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public enum MyColor {
    PINK     (255, 115, 222, 1),
    SKYBLUE    (139, 217, 255, 1),
    ORANGE   (255, 201, 15, 1),
    YELLOW (255, 251, 161, 1),
    PURPLE (241, 147, 255, 1),
    WHITE   (255, 255, 255, 1),
    BLACK (0, 0, 0, 1);

    int r;
    int g;
    int b;
    int a;
    int argb;

    //Sets
    public void setARGB(int r, int g, int b, int a){
        this.argb = (a << 24) & 0xFF000000 |
                    (r << 16) & 0x00FF0000 |
                    (g << 8) & 0x0000FF00 |
                    b;
    }
    MyColor(int r, int g, int b, int a)
    {
        this.r = r; this.g = g; this.b = b; this.a = a;
        setARGB(r, g, b, a);
    }
    public void setR(int r) { if ( r >= 0 && r <= 255 ) this.r = r; }
    public void setG(int g) { if ( g >= 0 && g <= 255 ) this.g = g; }
    public void setB(int b) { if ( b >= 0 && b <= 255 ) this.b = b; }
    public void setA(int a) { if ( a >= 0 && a <= 255 ) this.a = a; }

    //Gets
    public int getR() { return r; }
    public int getG() { return g; }
    public int getB() { return b; }
    public int getA() { return a; }
    public int getARGB() { return argb; }
    public String getHexColor() { return Integer.toHexString(argb).toUpperCase(); }

//    public Color getAllColor() { return Color.decode(Integer.toString(argb)); }

    public static MyColor[] getMyColor() { return MyColor.values(); }
    public Color getJavaFXColor()
    {
        return new Color(r / 255.0, g / 255.0, b / 255.0, a);
    }
}

