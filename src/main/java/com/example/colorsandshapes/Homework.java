package com.example.colorsandshapes;

public class Homework {

    class Homework3{

        /*
        1- Implement a Java class HistogramAlphaBet that calculates the frequencies and
        probabilities of the alphabet characters in by Leo Tolstoy’s “War and Peace” (file War and
        Peace.txt). The HistogramAlphaBet class utilizes Map collections, Map<Character,
        Integer> and Map<Character, Double> and stream operations, for statistical
        calculations and sorting of the frequencies and probabilities. It also includes a
        MyPieChart class as a non-static inner class.

        2- Class MyPieChart displays a pie chart of the probabilities of the n most frequent
        occurrences of an event – the frequency of characters in a document. The probability of
        event is given by:

                Probability of Event = Frequency of Event / Summation Frequencies of all Events

        In the pie chart:
        i. Each event is represented by a slice of the pie chart. The size of the slice is
        proportional to the probability of the corresponding event:


                Probability of Event = Central Angle of slice / 2pi

        ii. Each slice has a different color of your choice of type enum MyColor;
        iii. Each slice has a legend showing the corresponding event and its probability;
        iv. The slices are displayed in order of decreasing probability;
        v. The last slice represents “All Other Events” and their cumulative probability. As an
        example, in the graph below where the event is the occurrence of a letter in a text: n
        = 3, and the probability of All Other Events is one minus the sum of the probabilities
        of events e, s, and i.

        3- Class MyPieChart utilizes a Map collection Map<Character, Slice>, and includes
        appropriate constructors and a method draw that draws the pie chart. The drawing
        canvas includes appropriate GUI components to input the number of events, n (variable),
        and displays the pie chart together with the characters and their probabilities.

        4- Class Slice utilizes the MyArc class in the MyShape class hierarchy, and includes
        appropriate constructors and methods, including methods that perform the following
        operations:
        a. toString— returns a string representation of a Slice object;
        b. draw— draws a Slice object.
        5- You may only use JavaFX graphics and your own classes and methods for the operations
        included. Further,
        a. The code is applicable to canvases of variable height and width;
        b. The size of the pie chart is proportional to the smallest dimension of the canvas.
        6- Explicitly specify all the classes imported and used in your Java code.

         */

    }
    class Homework4{
        /**
         Department of Computer Science
         The City College of CUNY

         CSc 22100 L24141: Software Design Laboratory [Fall 2022]

         Project 4

         A PDF or MS Word report showing:

         [1] The full code of the Java application developed,
         [2] The database ER diagram
         [3] The DDL and SQL statements used (separately from the Java code), and
         [4] The outputs produced for the tasks indicated,

         is due by 11:59 pm on Sunday, 11 December 2022.  The deadline is strictly observed.

         Online demonstration of your application will take place during regular class time on Tuesday, 13 December 2022.  Further details, including the Zoom link for the online demonstration, will be provided in a Blackboard announcement.


         1. Consider the database schema below.

         Students(empID, firstName, lastName, email, gender)
         Courses(courseID, courseTitle, department)
         Classes(courseID, studentID, sectionNo, year, semester, grade)

         The underlined attributes are the primary keys of their corresponding tables.  The value of attribute gender may only be F, M, or U, referring, respectively, for female, male, or unidentified.  The only letter grades allowed in the database are A, B, C, D, F, or W.

         Further you are provided the class schedule for the Spring 2022 semester in file scheduleSpring2022.txt.  The key to the data in scheduleSpring2022 is (courseID, sectionNo).

         2. Using a Relational Database Management System (RDBMS) of your choice, your tasks are to:

         A. Create and populate a Schedule table using the data provided in file scheduleSpring2022.txt.

         B. Create and populate Courses and Classes tables using the data in table Schedule.

         C. Create and populate Students and Classes tables using data of your own together with the data in table Schedule.

         D. Using GROUP BY, Calculate and output the number of students for each letter grade in CSc 22100 [Introdcution to Database Systems] in the Spring 2022 semester.

         3. Build and test a Java application that [1] connects to the database, [2] creates, [3] populates, and [4] updates the Students, Courses, Classes, and AggregateGrades tables. The application should utilize PreparedStatement objects for the execution of DDL statements and SQL queries.

         A. The Java application utilizes a class StudentsDatabase which includes inner classes Schedule, Students, Courses, Classes, and AggregateGrades, corresponding, respectively, to database Tables Schedule, Students, Classes, and AggregateGrades.  The constructor of class Database may be utilized to establish a connection to the RDBMS, while the constructors of the inner classes may be used to create and populate the corresponding database Tables.

         B. Classes StudentsDatabase and Classes also include update methods that update, respectively, the instructor of a class and grade of a student.

         C. Class Database implements interfaces StudentsDatabaseInterface and TableInterface which include constants, and abstract, and static methods that define the DDL and SQL expressions used for creating, populating, and querying the database tables.

         D. Utilize the classes in Assignment 3, including HistogramAlphaBet and MyPieChart, to build and display a pie chart showing the proportion of students for each letter grade.  In the pie chart:

         a. Each segment has a different color;
         b. Each segment has a legend showing the corresponding grades and number of students;
         c. The segments for the grades are displayed in alphabetical order.

         4. The report should show [1] sample input tables, [2] output table for the aggregated grades and corresponding pie chart for a sufficient amount of input data, and [3] example[s] of the use of the update function.

         5. You may only use JavaFX graphics and your own classes and methods for the operations included.  Further,

         a. The code is applicable to canvases of variable height and width;
         b. The size of the pie chart is proportional to the smallest dimension of the canvas;
         c. The segments of the pie chart are filled with different colors of your choice, specified through a MyColor enum reference type.

         6. Explicitly specify all the classes imported and used in your Java application.

         Best wishes!
         Hesham A Auda
         20 November 2022
         */
    }
}
