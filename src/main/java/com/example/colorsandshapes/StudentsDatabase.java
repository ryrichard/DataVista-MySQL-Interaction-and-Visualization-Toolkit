package com.example.colorsandshapes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Map;
import java.util.HashMap;

public class StudentsDatabase<T> implements StudentsDatabaseInterface<T>, TableInterface {

    static Connection connection;
    static String url;
    static String user;
    static String password;

    //Establish connection with MySQL
    public StudentsDatabase(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println(url + "\t" + user + "\t" + password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    //Can be used to update instructors
    public void UpdateTable(String table_name, String col_name0, T data_to_update, String col_name1, T data_param) {
        String param;
        String update;

        if ((data_param).getClass().getSimpleName().equals("String"))
            param = "'" + data_param + "'";
        else
            param = data_param.toString();

        if ((data_to_update).getClass().getSimpleName().equals("String"))
            update = "'" + data_to_update + "'";
        else
            update = data_to_update.toString();

        try {
            Statement stmt = connection.createStatement();
            String UpdateTableSTMT = String.format(
                            "UPDATE %s " +
                            "SET %s = %s " +
                            "WHERE %s = %s",
                            table_name, col_name0, update,
                            col_name1, param);
            stmt.executeUpdate(UpdateTableSTMT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void GetAllResultsTable(String table_name)
    {
        if(table_name.equals("Schedule")) System.out.println("Schedule Table\n" + ScheduleCol);
        else if(table_name.equals("Classes")) System.out.println("Classes Table\n" + ClassCol);
        else if(table_name.equals("Students")) System.out.println("Students Table\n" +StudentCol);
        else if(table_name.equals("Courses")) System.out.println("Courses Table\n" + CourseCol);
        else if(table_name.equals("AggregateGrade")) System.out.println("AggregateGrade Table\n" + AggGradeCol);

        try (Statement stmt = connection.createStatement() )
        {
            String SelectAllTableSTMT = String.format("SELECT * FROM %s", table_name);

            ResultSet resultSet = stmt.executeQuery(SelectAllTableSTMT);

            //Get column numbers to iterate through data
            ResultSetMetaData md = resultSet.getMetaData();
            int cols = md.getColumnCount();

            while(resultSet.next())
            {
                for(int i = 1; i <= cols; i++) //must start at 1 for resultsSet
                    System.out.print(resultSet.getString(i) + "\t");
                System.out.print("\n");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    class Schedule {

        //Constructor that creates table
        public Schedule()
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
//                System.out.println(e); java.sql.SQLSyntaxErrorException: Table 'schedule' already exists
            }
        }

        public void UpdateInstructor(String col_name0, T data_param, String col_name1, T data_to_update)
        {
        String param;
        String update;

            if ((data_param).getClass().getSimpleName().equals("String"))
        param = "'" + data_param + "'";
            else
        param = data_param.toString();

            if ((data_to_update).getClass().getSimpleName().equals("String"))
        update = "'" + data_to_update + "'";
            else
        update = data_to_update.toString();


            try {
            Statement stmt = connection.createStatement();
            String UpdateTableSTMT = String.format(
                    "UPDATE Schedule " +
                            "SET %s = %s " +
                            "WHERE %s = %s",
                    col_name0, param,
                    col_name1, update);
            stmt.executeUpdate(UpdateTableSTMT);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public void DropTable() {
            System.out.println("Dropping Schedule Table...");

            try (Statement stmt = connection.createStatement();) {
                stmt.executeUpdate("DROP TABLE Schedule");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class Students {

        //Constructor that creates table
        public Students()
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

        public void DropTable()
        {
            System.out.println("Dropping Students Table...");

            try (Statement stmt = connection.createStatement();) {
                stmt.executeUpdate("DROP TABLE Students");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class Courses {

        //Constructor that creates table
        public Courses()
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

        public void DropTable() {
            System.out.println("Dropping Courses Table...");

            try (Statement stmt = connection.createStatement();) {
                stmt.executeUpdate("DROP TABLE Courses");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class Classes {

        //Constructor that creates classes
        public Classes()
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

        //Update grades of students
        public void UpdateGrades(String col_name0, T data_param, String col_name1, T data_to_update) {
            String param;
            String update;

            if ((data_param).getClass().getSimpleName().equals("String"))
                param = "'" + data_param + "'";
            else
                param = data_param.toString();

            if ((data_to_update).getClass().getSimpleName().equals("String"))
                update = "'" + data_to_update + "'";
            else
                update = data_to_update.toString();


            try {
                Statement stmt = connection.createStatement();
                String UpdateTableSTMT = String.format(
                            "UPDATE Classes " +
                            "SET %s = %s " +
                            "WHERE %s = %s",
                            col_name0, param,
                            col_name1, update);
                stmt.executeUpdate(UpdateTableSTMT);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        public void DropTable() {
            System.out.println("Dropping Classes Table...");

            try (Statement stmt = connection.createStatement();) {
                stmt.executeUpdate("DROP TABLE Classes");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class AggregateGrade {

        private ResultSet resultSet;

        public AggregateGrade()
        {
            System.out.println("Creating AggregateGrade table...");
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

        public void UpdateTable()
        {
            System.out.println("Updating AggregateGrade");
            String query;
            String letter;
            try(Statement stmt = connection.createStatement())
            {
                for(int i = 0; i < letterGrade.length; i++)
                {
                    letter = MakeMyLifeEasier.SQLString(letterGrade[i]);
                    query = String.format(
                            "UPDATE AggregateGrade " +
                            "SET counted = (SELECT Count(Classes.grade) FROM Classes WHERE Classes.grade = %s) " +
                            "WHERE grade = %s",
                            letter, letter);
                    stmt.executeUpdate(query);
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        public Map<Character, Integer> getResultSetAsMap()
        {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            String letter;
            String query;

            System.out.println("Creating Dictionary...");
            for(int i = 0; i < letterGrade.length; i++)
            {
                letter = MakeMyLifeEasier.SQLString(letterGrade[i]);

                try(Statement stmt = connection.createStatement())
                {
                    query = String.format("SELECT counted FROM AggregateGrade " +
                                        "WHERE grade = %s", letter);
                    resultSet = stmt.executeQuery(query);

                    while(resultSet.next())
                        map.put(letter.charAt(1), resultSet.getInt(1));
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

            return map;
        }

        public void DropTable()
        {
            System.out.println("Dropping Aggregate Grade Table...");

            try (Statement stmt = connection.createStatement();) {
                stmt.executeUpdate("DROP TABLE AggregateGrade");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
