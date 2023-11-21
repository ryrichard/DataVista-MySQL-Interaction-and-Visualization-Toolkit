package com.example.colorsandshapes;

import javafx.scene.canvas.GraphicsContext;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.Math;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class HistogramAlphaBet {

//    Pattern p;
//    Matcher m;
    boolean debug = true;
    Map<Character, Integer> alphabet;
    Map<Character, Double> frequency;
    Map<Character, Double> orderedFrequency;
    MyCircle circle;
    int totalChar = 0;
    public HistogramAlphaBet(MyCircle circle)
    {
        this.circle = new MyCircle(circle);
        alphabet = new HashMap<Character, Integer>();
        frequency = new HashMap<Character, Double>();
        orderedFrequency = new LinkedHashMap<>();
    };

    public String CleanText(String s)
    {
        //removes anything not a letter or number or space, and lower case every letter
        return s.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }
    public void AddToMap(File file)
    {
        char letter;
        String sentence;
        int length;

        //fill alphabet map with letters from text
        //'War and Peace' has a total of 3.2m characters
        try
        {
            Scanner s = new Scanner(file); //requires FileNotFoundException
            while (s.hasNext())
            {
                sentence = s.nextLine();
                sentence = CleanText(sentence);
                length = sentence.length();
                totalChar += length;
                for(int i = 0; i < length; i++)
                {
                    letter = sentence.charAt(i);
                    if ( alphabet.containsKey(letter)) {alphabet.put(letter, alphabet.get(letter) + 1); }
                    else { alphabet.put(letter, 1); }
                }
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

        //Find Frequncies of each letter and puts them on the map
        double freq = 0.0;
        for (Map.Entry<Character,Integer> entry : alphabet.entrySet())
        {
            freq = (double)entry.getValue() / totalChar;
            frequency.put(entry.getKey(), freq);
        }

        //Reorganize the frequency maps in desc order
        frequency.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> orderedFrequency.put(x.getKey(), x.getValue()));
    }

    //set methods
    public void setTotalChar(Map<Character, Integer> m)
    {
        for (Map.Entry<Character, Integer> entry : m.entrySet())
        {
            totalChar += entry.getValue();
        }
    }

    public void setFrequency(Map<Character, Integer> m)
    {
        double freq = 0.0;
        for (Map.Entry<Character,Integer> entry : m.entrySet())
        {
            freq = (double)entry.getValue() / totalChar;
            System.out.println((double)entry.getValue() + "/" + totalChar + " = " + freq);
            frequency.put(entry.getKey(), freq);
        }
    }

    public void setOrderedFrequency(Map<Character, Double> f)
    {
        f.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> orderedFrequency.put(x.getKey(), x.getValue()));
    }

    public void easySetUp(Map<Character, Integer> m)
    {
        setTotalChar(m);
        setFrequency(m);
        setOrderedFrequency(getFrequency());
    }

    //get methods
    public Map<Character, Double> getFrequency(){return frequency;}
    public Map<Character, Double> getOrderedFrequency(){return orderedFrequency;}

    class MyPieChart{

        int numOfSlices;
        double modifier; //how far the text will be from the pie chart

        MyColor c_List[]; //Create list of colors so it can be randomly selected

        public MyPieChart(int numOfSlices)
        {
            this.numOfSlices = numOfSlices;
            modifier = 15.0f;

            c_List = new MyColor[5];
            c_List[0] = MyColor.PINK;
            c_List[1] = MyColor.SKYBLUE;
            c_List[2] = MyColor.ORANGE;
            c_List[3] = MyColor.PINK;
            c_List[4] = MyColor.PURPLE;
        }

        public void DrawChart(GraphicsContext g, Group root)
        {
            //create new slices and draws them and labels them
            Slice slice;
            double currentAngle = 0;
            double s;
            int i = 0;
            int colorNum = orderedFrequency.size() + 1;
            double radius = circle.getRadius() + modifier;
            double midPointX = circle.getPoint().x + circle.getRadius();
            double midPointY = circle.getPoint().y + circle.getRadius();
            Text t;
            String string;
            double newX;
            double newY;
            double midAngle;
            double unlistedTotal = 0.0;
            System.out.println("Midpoint: " + midPointX + ", " + midPointY);
            for (Map.Entry<Character,Double> entry : orderedFrequency.entrySet())
            {
                System.out.println("Interation #" + i);
                if (i < numOfSlices)
                {
                    string = entry.getKey() + ": " + entry.getValue();
                    //Adding slice
                    s = Math.toDegrees(entry.getValue() * (2 * Math.PI));
                    if(i == orderedFrequency.size() - 1)
                        while(c_List[i % 5] == c_List[0] || c_List[i % 5] == c_List[(i - 1) % 5])  i++;
                    slice = new Slice(circle, currentAngle, s, c_List[i % 5]);
                    System.out.println(string + " " + i);
                    slice.Draw(g);

                    //Adding text
                    midAngle = (s/2) + currentAngle;
                    //Adjust y based on angle
                    if(midAngle < 180)
                        newY = midPointY - (radius * Math.abs(Math.sin(Math.toRadians(midAngle))));
                    else
                        newY = midPointY + (radius * Math.abs(Math.sin(Math.toRadians(midAngle))));
                    //Adjust x based on angle
                    if(midAngle > 95 && midAngle < 275)
                        newX = midPointX - (radius * Math.abs(Math.cos(Math.toRadians(midAngle)))) - (string.length() * 5);
                    else
                        newX = midPointX + (radius * Math.abs(Math.cos(Math.toRadians(midAngle))));

//                    System.out.println("Midangle: " + midAngle);
//                    System.out.println(midPointX + " + " + radius + " * " + Math.cos(midAngle) + " = " + newX);
//                    System.out.println("Adding " + entry.getKey() + " to points: " + newX + ", " + newY);

                    t = new Text(newX, newY, string);
                    t.setFill(c_List[i % 5].getJavaFXColor());
                    t.setFont(Font.font("Times New Roman", 10));
                    root.getChildren().add(t);
                    currentAngle += s;
                }
                else if(i >= numOfSlices && i < orderedFrequency.size())
                {
                    if(colorNum == orderedFrequency.size() + 1) colorNum = i; //record last color used
                    unlistedTotal += entry.getValue();
                }

                if(i == orderedFrequency.size() - 1 && unlistedTotal > 0.0)
                {
                    string = "Other : " + unlistedTotal;
                    //Adding last slice
                    //Makes sure that the slice is the same color is the first slice and previous slice
//                    while(c_List[i % 5] == c_List[0] || c_List[i % 5] == c_List[colorNum % 5])  i++;
                    while(c_List[colorNum % 5] == c_List[0]) colorNum += 1;
                    slice = new Slice(circle, currentAngle, 360-currentAngle, c_List[colorNum % 5]);
                    System.out.println(string);
                    slice.Draw(g);
                    //Adding last text
                    midAngle = ((360 - currentAngle)/2) + currentAngle;

                    //Adjust y based on angle
                    if(midAngle < 180)
                        newY = midPointY - (radius * Math.abs(Math.sin(Math.toRadians(midAngle))));
                    else
                        newY = midPointY + (radius * Math.abs(Math.sin(Math.toRadians(midAngle))));

                    //Adjust x based on angle
                    if(midAngle > 95 && midAngle < 275)
                        newX = midPointX - (radius * Math.abs(Math.cos(Math.toRadians(midAngle)))) - (string.length() * 5);
                    else
                        newX = midPointX + (radius * Math.abs(Math.cos(Math.toRadians(midAngle))));

//                    System.out.println("Midangle: " + midAngle);
//                    System.out.println(midPointX + " + " + radius + " * " + Math.cos(Math.toRadians(midAngle)) + " = " + newX);
//                    System.out.println(midPointY + " + " + radius + " * " + Math.sin(Math.toRadians(midAngle)) + " = " + newY);
//                    System.out.println("Adding " + entry.getKey() + " to points: " + newX + ", " + newY);

                    t = new Text(newX, newY, string);
                    t.setFill(c_List[i % 5].getJavaFXColor());
                    t.setFont(Font.font("Times New Roman", 10));
                    root.getChildren().add(t);
                    break;
                }

                i++;
            }
        }
    }

    public void Debug()
    {
        if(debug)
        {
            System.out.println(alphabet);
            System.out.println(frequency);
        }
    }
}
