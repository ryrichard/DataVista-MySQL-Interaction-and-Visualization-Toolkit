package com.example.colorsandshapes;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public interface StudentsDatabaseInterface<T> {

    /*
    for courseid where schedule seperates the two:

    Update Schedule
        Set courseId = (Select concat(course, id));
     */

    //Creating specific table (useless here since the known params are set)
    public static void CreateTable(Connection connection, String tableName)
    {
        System.out.println("Creating table...");

        try
        {
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE DefaultTable " +
                         "(name varchar(100), " +
                         "age Integer Not NULL);";
            stmt.executeUpdate(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void InsertIntoScheduleTable(Connection connection, int course, String id, int sectionNo, String title, int year, String semester, String instructor, String department, String program)
    {
        System.out.println("Inserting data into Schedule Table...");

        String _course = Integer.toString(course);
        id = MakeMyLifeEasier.SQLString(id);
        String _sectionNo = Integer.toString(sectionNo);
        title = MakeMyLifeEasier.SQLString(title);
        String _year = Integer.toString(year);
        semester = MakeMyLifeEasier.SQLString(semester);
        instructor = MakeMyLifeEasier.SQLString(instructor);
        department = MakeMyLifeEasier.SQLString(department);
        program = MakeMyLifeEasier.SQLString(program);

        try{
            Statement stmt = connection.createStatement();
            String InsertSTMT = String.format(
                                "INSERT INTO Schedule " +
                                "(Course, Id, SectionNo, Title, Year, Semester, " +
                                "Instructor, Department, Program) " +
                                "Values " +
                                "(%s, %s, %s, %s, %s, %s, %s, %s, %s)",
                                _course, id, _sectionNo, title, _year,
                                semester, instructor, department, program);
            stmt.executeUpdate(InsertSTMT);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void InsertIntoClassesTable(Connection connection, String courseId, int sectionNo, int year, String semester, String grade)
    {
        System.out.println("Inserting data into Classes Table...");

        courseId = MakeMyLifeEasier.SQLString(courseId);
        String _sectionNo = Integer.toString(sectionNo);
        String _year = Integer.toString(year);
        semester = MakeMyLifeEasier.SQLString(semester);
        grade = MakeMyLifeEasier.SQLString(grade);

        try{
            Statement stmt = connection.createStatement();
            String InsertSTMT = String.format(
                            "INSERT INTO Classes " +
                            "(CourseID, sectionNo, year, semester, grade) " +
                            "Values " +
                            "(%s, %s, %s, %s, %s)",
                            courseId, _sectionNo, _year, semester, grade);
            stmt.executeUpdate(InsertSTMT);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void InsertIntoStudentsTable(Connection connection, String firstName, String lastName, String email, String gender)
    {
        System.out.println("Inserting data into Students Table...");

        firstName = MakeMyLifeEasier.SQLString(firstName);
        lastName = MakeMyLifeEasier.SQLString(lastName);
        email = MakeMyLifeEasier.SQLString(email);
        gender = MakeMyLifeEasier.SQLString(gender);

        try{
            Statement stmt = connection.createStatement();
            String InsertSTMT = String.format(
                            "INSERT INTO Students " +
                            "(firstname, lastname, email, gender) " +
                            "Values " +
                            "(%s, %s, %s, %s)",
                            firstName, lastName, email, gender);
            stmt.executeUpdate(InsertSTMT);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void InsertIntoCoursesTable(Connection connection, String courseId, int sectionNo, String courseTitle, String department)
    {
        System.out.println("Inserting data into Courses Table...");

        courseId = MakeMyLifeEasier.SQLString(courseId);
        String _sectionNo = Integer.toString(sectionNo);
        courseTitle = MakeMyLifeEasier.SQLString(courseTitle);
        department = MakeMyLifeEasier.SQLString(department);

        try{
            Statement stmt = connection.createStatement();
            String InsertSTMT = String.format(
                            "INSERT INTO Courses " +
                            "(courseId, sectionNo, courseTitle, department) " +
                            "Values " +
                            "(%s, %s, %s, %s)",
                            courseId, _sectionNo, courseTitle, department);
            stmt.executeUpdate(InsertSTMT);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // useless/placeholder
    public static void InsertIntoAggregateGradesTable(Connection connection)
    {
        System.out.println("Inserting data into Aggregate Grade Table...");

        try{
            Statement stmt = connection.createStatement();
            String InsertIntoSTMT = String.format("");
            stmt.executeUpdate(InsertIntoSTMT);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Get specific data from table_name
    public static void GetResultsTable(Connection connection, String table_name, String col_name) {
        System.out.println("Getting Results for " + table_name + "." + col_name);

        try {
            Statement stmt = connection.createStatement();
            String UpdateTableSTMT = String.format(
                    "SELECT %s FROM studentdatabase.%s",
                    col_name, table_name);

            ResultSet resultSet = stmt.executeQuery(UpdateTableSTMT);
            while(resultSet.next())
                System.out.println(resultSet.getString(col_name));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Update table with Set col_name0 = data_to_update Where col_name1 = data_param
    abstract void UpdateTable(String table_name, String col_name0, T data_to_update, String col_name1, T data_param);
}
