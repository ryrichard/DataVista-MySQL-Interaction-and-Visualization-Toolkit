package com.example.colorsandshapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.ResultSet;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //Default Example
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        Group root = new Group();
//        stage.show();

//        Group root = new Group();
//        Scene s = new Scene(root, 600, 600);
//        stage.setTitle("Hello!");
//        stage.setScene(s);
//        stage.show();

        //Point works
//        MyPoint p = new MyPoint(10,10);
//        Group root = new Group();
//        Scene s = new Scene(root, 300, 300 );
//        final Canvas canvas = new Canvas(250,250);
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        p.Draw(gc);
//        root.getChildren().add(canvas);
//        stage.setScene(s);
//        stage.show();

        //Old way
//        MyColor c = MyColor.RED;
//        Canvas canvas = new Canvas(H, W);
//        Pane pane = new Pane(canvas);

//        Test(stage);
//        Assignment1(stage);

        //assignment 4 values
        final String url = "jdbc:mysql://localhost:3306/StudentDatabase";
        final String user = "root";
        final String password = "abcd1234";

        TextField textfield = new TextField("Input Numbers 1-6 Here");
        stage.setTitle("MyPieChart");
        TilePane r = new TilePane();
        TextInputDialog td = new TextInputDialog("enter any text");
        td.setHeaderText("enter a number");
        Label label = new Label();
        Button button = new Button("click");
        button.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                try {
                    int intValue = Integer.parseInt(textfield.getText());
                    Assignment4(stage, url, user, password, intValue);
                } catch (NumberFormatException error) {
                    label.setText("Not an integer, please try again.");
                }

//                // show the text input dialog
//                if(textfield.getText())
//                label.setText(textfield.getText());
//                // Add drop down and button
            }
        });
//        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent e)
//            {
//                // show the text input dialog
//                label.setText(textfield.getText());
//                // Add drop down and button
//            }
//        };

//        textfield.setOnAction(event);
        r.getChildren().add(button);
        r.getChildren().add(textfield);
        r.getChildren().add(label);
        Scene sc = new Scene(r, 500, 300);
        stage.setScene(sc);
        stage.show();
    }

    public void Test(Stage stage)
    {
        int H = 700, W = 700;

        System.out.println("Creating Canvas");
        Canvas canvas = new Canvas(H, W);

        System.out.println("Creating Graphics Context");
        GraphicsContext gc = canvas.getGraphicsContext2D();

        MyPoint p = new MyPoint(10, 10);
        MyCircle c = new MyCircle(p, 100, 100, MyColor.BLACK);
        Slice s = new Slice(c, 0, 90, MyColor.PINK);
        s.Draw(gc);
//        MyPoint pt = new MyPoint(200, 200);
//        MyCircle c = new MyCircle(pt, 300, 300, MyColor.PINK);
//
//        c.Draw(gc);
//        MyShapeInterface.DrawBoundingBox(gc, c);

        System.out.println("Creating Pane");
        Pane pane = new Pane(canvas);

        System.out.println("Adding Pane to root");
        Group root = new Group();
        root.getChildren().add(pane);

        System.out.println("Displaying stage");
        Scene scene = new Scene(root, H, W);
        stage.setScene(scene);
        stage.show();

        System.out.println("Everything Is Fine");
    }

    public void Assignment1(Stage stage)
    {
        int H = 500;
        int W = 500;
        int NUM_OF_REC = 2;
        int NUM_OF_OVAL = 3;
        int NUM_OF_SHAPES = 5;

        System.out.println("Creating Points and Shapes");
        MyPoint p = new MyPoint();

        MyPoint p_rec_list[] = new MyPoint[NUM_OF_REC]; //List of Square points
        MyRectangle r_list[] = new MyRectangle[NUM_OF_REC];
        MyPoint p_cir_list[] = new MyPoint[NUM_OF_OVAL]; //List of Circle points
        MyOval o_list[] = new MyOval[NUM_OF_OVAL];

        //Create First Circle
        p_cir_list[0] = new MyPoint(0, 0);
        o_list[0] = new MyOval(p_cir_list[0],
                H - (2 * p_cir_list[0].getX()),
                W - (2 * p_cir_list[0].getY()),
                MyColor.PINK);

        //Create First Square
        p_rec_list[0] = new MyPoint(o_list[0].getUpperLeft());
        r_list[0] = new MyRectangle(p_rec_list[0],
                H - (2 * p_rec_list[0].getX()),
                W - (2 * p_rec_list[0].getY()),
                MyColor.ORANGE);

        //Create Second Circle
        p_cir_list[1] = new MyPoint(r_list[0].getPoint());
        o_list[1] = new MyOval(p_cir_list[1],
                H - (2 * p_cir_list[1].getX()),
                W - (2 * p_cir_list[1].getY()),
                MyColor.SKYBLUE);

        //Create Second Square
        p_rec_list[1] = new MyPoint(o_list[1].getUpperLeft());
        r_list[1] = new MyRectangle(p_rec_list[1],
                H - (2 * p_rec_list[1].getX()),
                W - (2 * p_rec_list[1].getY()),
                MyColor.WHITE);

        //Create Third Circle
        p_cir_list[2] = new MyPoint(r_list[1].getPoint());
        o_list[2] = new MyOval(p_cir_list[2],
                H - (2 * p_cir_list[2].getX()),
                W - (2 * p_cir_list[2].getY()),
                MyColor.YELLOW);

        System.out.println("Creating Canvas List");
        Canvas canvas = new Canvas(H, W);

        System.out.println("Creating Graphics Context");
        GraphicsContext gc = canvas.getGraphicsContext2D();

        System.out.println("Creating drawing");
        for(int i = 0; i < NUM_OF_SHAPES; i++)
        {
            if(i % 2 == 0) o_list[i / 2].Draw(gc);
            else r_list[i / 2].Draw(gc);
        }

        System.out.println("Creating Pane List");
        Pane pane = new Pane(canvas);

        System.out.println("Adding Pane to root");
        Group root = new Group();
        root.getChildren().add(pane);

        System.out.println("Displaying stage");
        Scene scene = new Scene(root, H, W);
        stage.setScene(scene);
        stage.show();

        System.out.println("Everything is fine");
    }

    public void Assignment2(Stage stage)
    {
        int H = 700, W = 700;

        System.out.println("Creating Canvas");
        Canvas canvas = new Canvas(H, W);

        System.out.println("Creating Graphics Context");
        GraphicsContext gc = canvas.getGraphicsContext2D();

        System.out.println("Drawing Pie");
        int RADIUS = 0;
        MyPoint point = new MyPoint(300, 200);
        MyCircle circle = new MyCircle(point, 350, 350, MyColor.WHITE);
        int NUM_OF_ARC = 6;
        List<Integer> list = new ArrayList<>(Arrays.asList(40, 90, 80, 60, 30, 60)); //=360
        List<MyColor> colors = new ArrayList<>(Arrays.asList(MyColor.ORANGE,
                                                            MyColor.PINK,
                                                            MyColor.PURPLE,
                                                            MyColor.SKYBLUE,
                                                            MyColor.YELLOW,
                                                            MyColor.WHITE));
        MyArc[] arc_list = new MyArc[NUM_OF_ARC];
        for(int i = 0; i < NUM_OF_ARC; i++)
        {
            arc_list[i] = new MyArc(circle, RADIUS, list.get(i), colors.get(i));
            RADIUS += list.get(i);
            arc_list[i].Draw(gc);
        }


        System.out.println("Drawing two Rectangle");
        MyPoint r1_point = new MyPoint(50, 50);
        MyPoint r2_point = new MyPoint(100, 100);
        MyRectangle rec1 = new MyRectangle(r1_point, 100, 100, MyColor.ORANGE);
        MyRectangle rec2 = new MyRectangle(r2_point, 150, 150, MyColor.SKYBLUE);
        rec1.Draw(gc);
        rec2.Draw(gc);
        MyShapeInterface.DrawBoundingBox(gc, rec1);
        MyShapeInterface.DrawBoundingBox(gc, rec2);
        List<MyPoint> p_list = new ArrayList<MyPoint>();
        List<MyPoint> p2_list = new ArrayList<MyPoint>();
        p_list = MyShapeInterface.intersectMyRectangles(rec1.getMyBoundingRectangle(),
                                                        rec2.getMyBoundingRectangle());
        p2_list = MyShapeInterface.intersectMyShape(rec1, rec2, p_list);
        rec1.drawIntersectMyShapes(gc, p2_list);


        System.out.println("Drawing Rectangle and Circle");
        MyPoint r3_point = new MyPoint(50, 450);
        MyPoint c1_point = new MyPoint(100, 500);
        MyRectangle rec3 = new MyRectangle(r3_point, 100, 100, MyColor.YELLOW);
        MyCircle cir = new MyCircle(c1_point, 150, 150, MyColor.PINK);
        rec3.Draw(gc);
        cir.Draw(gc);
        MyShapeInterface.DrawBoundingBox(gc, rec3);
        MyShapeInterface.DrawBoundingBox(gc, cir);
        List<MyPoint> p3_list = new ArrayList<MyPoint>();
        List<MyPoint> p4_list = new ArrayList<MyPoint>();
        p3_list = MyShapeInterface.intersectMyRectangles(rec3.getMyBoundingRectangle(),
                                                        cir.getMyBoundingRectangle());
        p4_list = MyShapeInterface.intersectMyShape(rec3, cir, p3_list);
        rec3.drawIntersectMyShapes(gc, p4_list);



        System.out.println("Creating Pane");
        Pane pane = new Pane(canvas);

        System.out.println("Adding Pane to root");
        Group root = new Group();
        root.getChildren().add(pane);

        System.out.println("Displaying stage");
        Scene scene = new Scene(root, H, W);
        stage.setScene(scene);
        stage.show();

        System.out.println("Everything Is Fine");
    }

    public void Assignment3(Stage stage, int numOfSlices)
    {
        //set stage
        int H = 700;
        int W = 700;

        System.out.println("Creating Canvas");
        Canvas canvas = new Canvas(H, W);

        System.out.println("Creating Graphics Context");
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //get file
        MyPoint point = new MyPoint(150, 150);
        MyCircle circle = new MyCircle(point, 450, 450, MyColor.BLACK);

        System.out.println("Grabbing file");
        File f = new File("/Users/idriod/Documents/Skool/CityCollege/2022 Fall/Software Design/code/JavaFX3/WarAndPeace.txt");

        //Creating Group root
        Group root = new Group();

        System.out.println("Creating Histogram and MyPieChart");

        HistogramAlphaBet h = new HistogramAlphaBet(circle);
        HistogramAlphaBet.MyPieChart myPieChart = h.new MyPieChart(numOfSlices);
        h.AddToMap(f);
        myPieChart.DrawChart(gc, root);

        System.out.println("Creating Pane");
        Pane pane = new Pane(canvas);

        System.out.println("Adding Pane to root");
        root.getChildren().add(pane);

        System.out.println("Displaying stage");
        Scene scene = new Scene(root, H, W);
        stage.setScene(scene);
        stage.show();

        System.out.println("Everything Is Fine");
    }

    public void InsertIntoStudentsTable(StudentsDatabase sdb)
    {
        String[][] studentData = {
                {"Pubret", "Adams", "pubAdams@school.com", "M"},
                {"Gomez", "Adams", "goAdams@school.com", "M"},
                {"Snow", "White", "sleepy@school.com", "F"},
                {"Thomas", "Tank", "chuchu@school.com", "U"},
                {"Decep", "DaCon", "TopG@school.com", "U"},
                {"Mount", "Ain", "everest8848@school.com", "U"},
                {"Ben", "Dover", "bdover@school.com", "M"},
                {"Ei", "lean", "wall@school.com", "F"},
                {"Peredwus", "Eckersley", "pereEck@school.com", "M"},
                {"Thai", "Wintjen", "thaiWin@school.com", "M"},
                {"Geroge", "Hosten", "gHost@school.com", "M"},
                {"Mana", "Menner", "maname@school.com", "F"},
                {"Darlene", "Ickerson", "ickersonD@school.com", "F"},
                {"Noelle", "Minniear", "NoMin@school.com", "F"},
                {"Shaylynn", "Bachman", "sBach@school.com", "F"},
                {"Keira", "Noble", "knob@school.com", "F"},
                {"Bella", "Enderson", "bellend@school.com", "F"},
                {"Blu", "Waffle", "bluWaffle@school.com", "F"},
                {"Noe", "Wuan", "whosThere@school.com", "M"},
                {"Bask", "EtBall", "sports1@school.com", "U"},
                {"Soc", "Err", "sports2@school.com", "U"},
                {"Fut", "Bal", "soccer@school.com", "U"},
                {"Fortee", "Two", "answer@school.com", "U"},
                {"Dex", "Ter", "laboratory@school.com", "M"},
                {"Ed", "Edd", "Eddy@school.com", "M"},
                {"Sweet", "Suger", "chemX@school.com", "F"},
                {"Blus", "Clue", "steve@school.com", "U"}};

        for(int i = 0; i < studentData.length; i++)
            StudentsDatabaseInterface.InsertIntoStudentsTable(
                    sdb.connection, studentData[i][0], studentData[i][1],
                    studentData[i][2], studentData[i][3]);
    }

    public void InsertIntoClassesTable(StudentsDatabase sdb)
    {
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "A");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "B");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "F");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "C");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "F");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "W");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "D");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "D");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "B");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "C");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "A");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "D");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "A");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "D");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "A");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "W");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "C");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "A");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "B"  );
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "A");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "A");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "C");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "D" );
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "A");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "F");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "B");
        StudentsDatabaseInterface.InsertIntoClassesTable(sdb.connection, "22100P", 32132,2017, "Spring", "A" );
    }

    public void Assignment4(Stage stage, String url, String user, String password, int numOfSlices)
    {
        int H = 1000;
        int W = 1000;

        System.out.println("Creating Canvas");
        Canvas canvas = new Canvas(H, W);

        System.out.println("Creating Graphics Context");
        GraphicsContext gc = canvas.getGraphicsContext2D();

        System.out.println("Creating Group root");
        Group root = new Group();

        //Creating outer class
        StudentsDatabase sdb = new StudentsDatabase(url, user, password);

        //Delete old table to create Fresh Tables
        TableInterface.DropAllTables(sdb.connection);

        //inner class schedule
        StudentsDatabase.Schedule schedule = sdb.new Schedule();
        TableInterface.InsertIntoScheduleTable(sdb.connection);
        sdb.GetAllResultsTable("Schedule");
        sdb.UpdateTable("Schedule", "Instructor", "Ms. Frizzle", "Instructor", "Jun Wu");
        sdb.GetAllResultsTable("Schedule");

        //Inner class students
        StudentsDatabase.Students students = sdb.new Students();
        InsertIntoStudentsTable(sdb);
        sdb.GetAllResultsTable("Students");

        //Inner class courses
        StudentsDatabase.Courses courses = sdb.new Courses();
        StudentsDatabaseInterface.InsertIntoCoursesTable(sdb.connection, "10000PP", 34143, "Introduction to Programming & Computer Science", "Computer Science");
        StudentsDatabaseInterface.InsertIntoCoursesTable(sdb.connection, "10200CC1", 32120, "Introduction to Computing", "Computer Science");
        StudentsDatabaseInterface.InsertIntoCoursesTable(sdb.connection, "22100P", 32132, "Software Design Laboratory", "Computer Science");
        sdb.GetAllResultsTable("Courses");

        //Inner class classes
        StudentsDatabase.Classes classes = sdb.new Classes();
        InsertIntoClassesTable(sdb);
        sdb.GetAllResultsTable("Classes");
        classes.UpdateGrades("grade", "A", "studentId", 5);
        sdb.GetAllResultsTable("Classes");

        //Inner Class AggregateGrade
        StudentsDatabase.AggregateGrade aggregateGrade = sdb.new AggregateGrade();
        TableInterface.InsertIntoAggregateGradeTable(sdb.connection);
        aggregateGrade.UpdateTable();
        sdb.GetAllResultsTable("AggregateGrade");
        Map<Character, Integer> map = aggregateGrade.getResultSetAsMap();

        System.out.println("Creating Histogram and PieChart");
        int HEIGHT = 500;
        int WIDTH = 500;
        MyPoint myPoint = new MyPoint(250, 250);
        MyCircle myCircle = new MyCircle(myPoint, HEIGHT, WIDTH, MyColor.BLACK);
        HistogramAlphaBet histogramAlphaBet = new HistogramAlphaBet(myCircle);
        HistogramAlphaBet.MyPieChart myPieChart = histogramAlphaBet.new MyPieChart(numOfSlices);
        histogramAlphaBet.easySetUp(map);
        myPieChart.DrawChart(gc, root);

        System.out.println("Creating Pane");
        Pane pane = new Pane(canvas);

        System.out.println("Adding Pane to root");
        root.getChildren().add(pane);

        System.out.println("Displaying stage");
        Scene scene = new Scene(root, H, W);
        stage.setScene(scene);
        stage.show();

        System.out.println("Everything Is Fine");
    }




    public static void main(String[] args)
    {
        launch();

        //Project ask us to create methods to update instructor, but database does not have instructor in it
        //Project ask for constant methods in interface
//        String intData = "s";
//        String type = ((Object)intData).getClass().getSimpleName();
//        System.out.println(intData + " is of type " + ((Object)intData).getClass().getSimpleName());
//        if(type.equals("String"))
//        {
//            type = """ + type + """;
//            System.out.println(type);
//        }
//        else System.out.println("False");
//
//        try
//        {
//            Connection connection = DriverManager.getConnection(url, user, password);
//            Statement stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery(
//                    "SELECT COUNT(Classes.grade), grade " +
//                    "FROM Classes " +
//                    "GROUP BY grade " +
//                    "ORDER BY grade");
//
//
//            while(resultSet.next())
//                System.out.println(resultSet.getString("grade") +
//                                   "\t" +
//                                   resultSet.getInt("COUNT(Classes.grade)"));
//
//        } catch (SQLException e)
//        {
//            e.printStackTrace();
//        }

//
//        double d = 259;
//        double a = Math.sin(Math.toRadians(d));
//        System.out.print(a);

//        MyPoint p1 = new MyPoint(5,5);
//        MyPoint p2 = new MyPoint(10,10);
//        System.out.println(p1.angleOfPointToXAxis(p2));
//
//        MyRectangle r1 = new MyRectangle(p1, 100, 100, MyColor.PINK);
//        MyRectangle r2 = new MyRectangle(p1, 100, 100, MyColor.BLACK);
//        MyRectangle r3 = new MyRectangle(p1, 40, 20, MyColor.BLACK);
//        MyOval o1 = new MyOval(p1, 100, 100, MyColor.PINK);
//        MyOval o2 = new MyOval(p1, 100, 100, MyColor.PINK);
//        MyCircle c1 = new MyCircle(p1, 100, 100, MyColor.BLACK);
//        MyCircle c2 = new MyCircle(p1, 100, 100, MyColor.BLACK);
//        r1.setDebug(false);
//        r2.setDebug(false);
//        o1.setDebug(false);
//        o2.setDebug(false);
//        c1.setDebug(false);
//        c2.setDebug(false);

//        System.out.println(MyShapeInterface.SimilarObjects(r1, r2));
//        System.out.println(MyShapeInterface.SimilarObjects(r2, r3));
//        System.out.println(MyShapeInterface.SimilarObjects(c1, o2));
//        List<MyPoint> p_list = new ArrayList<MyPoint>();
//        MyPoint p1 = new MyPoint(10, 20);
//        p1.setX(123);
//        p1.setY(131);

//        p_list.add(p1);
//        p1.setX(1414);
//        p1.setY(513);
//        p_list.add(p1);
//
//        for(MyPoint p: p_list)
//            System.out.println(p.getX() + " " + p.getY());

//        Map<Character, Integer> alpha = new HashMap<Character, Integer>();
//        int total = 0;
//        try
//        {
//            File f = new File("/Users/idriod/Documents/Skool/CityCollege/2022 Fall/Software Design/code/JavaFX3/WarAndPeace.txt");
////            System.out.print(f.exists());
//            int iter = 5;
//            char c;
//            Scanner s = new Scanner(f); //needs to use FileNotFoundException
//            String data;
//            Pattern p = Pattern.compile("[a-zA-Z]+"); //creates patterns to follow
//            Matcher m1 = p.matcher(data); //creates the group of words
//            System.out.print(data);
//            while(s.hasNext() && iter > 0)
//            {
//                data = s.nextLine();
//                data = data.toLowerCase();
//                data = data.replaceAll("[^a-zA-Z0-9]", ""); //removes everything but letters and numbers
//                System.out.println(data);
//                for(int i = 0; i < data.length(); i++)
//                {
//                    c = data.charAt(i);
//                    if(alpha.containsKey(c)) alpha.replace(c, alpha.get(c)+1 );
//                    else alpha.put(c, 1);
//                    total += 1;
//                }
//                iter--;
//            }
//        }
//        catch(FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//
//        System.out.print(total);

//        Map<String, Integer>test = new HashMap<String, Integer>();
//        test.put("test", 10);
//        test.put("test1", 120);
//
//        String t = "er";
//        System.out.println(test);
//
//        if(test.containsKey(t))
//            test.put(t, 90);
//        else
//            test.put(t, 100000);
//
        System.exit(0); //force exit

    }
}