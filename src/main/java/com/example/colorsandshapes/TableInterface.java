package com.example.colorsandshapes;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

//General Use Interface
public interface TableInterface {

    String ScheduleCol = "CourseId, SectionNo, Title, Year, Semester, Instructor, Department, Program";
    String CourseCol = "CourseId, SectionNo, Title, Department";
    String StudentCol = "EmpId, FirstName, LastName, Email, Gender";
    String ClassCol = "StudentId, CourseId, SectionNo, Year, Semester, Grade";
    String AggGradeCol = "Grade, Count(grade)";

    String[] letterGrade = {"A", "B", "C" , "D", "F", "W"};

    String CreateScheduleTableSTMT  = "CREATE TABLE Schedule " +
                             "(CourseId varchar(10) NOT NULL, " +
                             "SectionNo Integer NOT NULL, " +
                             "Title varchar(100) NOT NULL, " +
                             "Year Integer NOT NULL, " +
                             "Semester varchar(10) NOT NULL, " +
                             "Instructor varchar(50) NOT NULL, " +
                             "Department varchar(50) NOT NULL, " +
                             "Program varchar(20) NOT NULL, " +
                             "PRIMARY KEY(CourseId, SectionNo));";

    String CreateCoursesTableSTMT = "CREATE TABLE Courses " +
                                    "(courseID varChar(100) NOT NULL, " +
                                    "sectionNo integer NOT NULL, " +
                                    "courseTitle varchar(100) NOT NULL, " +
                                    "department varchar(100) NOT NULL, " +
                                    "Primary Key(courseID, sectionNo));";

    String CreateClassesTableSTMT = "CREATE TABLE Classes " +
                                    "(studentID Integer AUTO_INCREMENT REFERENCES student(empID), " +
                                    "courseID varchar(100) NOT NULL, " +
                                    "sectionNo Integer NOT NULL, " +
                                    "year Integer NOT NULL, " +
                                    "semester varchar(100) NOT NULL, " +
                                    "grade varchar(1) NOT NULL, " +
                                    "PRIMARY KEY(studentID));";


    String CreateStudentsTableSTMT = "CREATE TABLE Students " +
                                    "(empID Integer NOT NULL AUTO_INCREMENT, " +
                                    "firstName varChar(20) NOT NULL, " +
                                    "lastName varChar(20) NOT NULL, " +
                                    "email varChar(50) NOT NULL, " +
                                    "gender varChar(1) NOT NULL, " +
                                    "PRIMARY KEY(empID));";

    String CreateAggregateGradesTableSTMT = "CREATE TABLE AggregateGrade " +
                                            "(grade varchar(1) REFERENCES classes(grade), " +
                                            "counted int NOT NULL default 0, " +
                                            "Primary Key(grade));";

    String InsertIntoTableSTMT = "INSERT INTO Schedule " +
                                   "(CourseId, SectionNo, Title, Year, " +
                                   "Semester, Instructor, Department, Program) " +
                                   "VALUES ('10000PP', 34134, " +
                                   "'Introduction to Programming & Computer Science', 2021, " +
                                   "'Spring', 'Anna Towne', 'Computer Science', 'Undergraduate'), " +
                                   "('10200CC3', 32139, " +
                                   "'Introduction to Computing', 2021, " +
                                   "'Spring', 'Jun Wu', 'Computer Science', 'Undergraduate'), " +
                                   "('22100P', 32132, " +
                                   "'Software Design Laboratory', 2021, " +
                                   "'Spring', 'Hesham Auda', 'Computer Science', 'Undergraduate');";


    //Create tables
    public static void CreateScheduleTable(Connection connection)
    {
        System.out.println("Creating Schedule table...");

        try
        {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(CreateScheduleTableSTMT);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void CreateCoursesTable(Connection connection)
    {
        System.out.println("Creating Course table...");

        try
        {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(CreateCoursesTableSTMT);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void CreateClassesTable(Connection connection)
    {
        System.out.println("Creating Class table...");

        try
        {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(CreateClassesTableSTMT);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void CreateStudentsTable(Connection connection)
    {
        System.out.println("Creating Student table...");

        try
        {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(CreateStudentsTableSTMT);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void CreateAggregateGradesTable(Connection connection)
    {
        System.out.println("Creating Aggregate Grade table...");

        try
        {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(CreateAggregateGradesTableSTMT);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Create all table
    public static void CreateAllTables(Connection connection)
    {
        CreateStudentsTable(connection);
        CreateAggregateGradesTable(connection);
        CreateCoursesTable(connection);
        CreateClassesTable(connection);
        CreateAggregateGradesTable(connection);
    }

    //Added default data rows into schedule table
    public static void InsertIntoScheduleTable(Connection connection)
    {
        System.out.println("Inserting Default data into Schedule Table...");
        try (Statement stmt = connection.createStatement(); )
        {
            stmt.executeUpdate(InsertIntoTableSTMT);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    };

    public static void InsertIntoAggregateGradeTable(Connection connection)
    {
        System.out.println("Inserting Letter Grade into AggreagateGradde Table");

        try(Statement stmt = connection.createStatement())
        {
            stmt.executeUpdate("INSERT INTO AggregateGrade (grade) " +
                                    "Values ('A'), ('B'), ('C'), ('D'), ('F'), ('W');");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Get all results from table_name
    abstract void GetAllResultsTable(String table_name);

    public static void DropAllTables(Connection connection)
    {
        String[] colName = {"Students", "Schedule", "Courses", "Classes", "AggregateGrade"};

        try(Statement stmt = connection.createStatement())
        {
            for(int i = 0; i < colName.length; i++)
            {
                String query = String.format("DROP TABLE %s", colName[i]);
                stmt.executeUpdate(query);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
