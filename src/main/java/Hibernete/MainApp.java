package Hibernete;

import java.sql.*;

public class MainApp {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER ="root";
    private static final String PASS = "Crfkf1984!";
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, avg(month(subscription_date)) as numb_month FROM purchaselist\n" +
                    "group by course_name;");

            while (resultSet.next()) {
                String courseNme = resultSet.getString("course_name");
                double countPayCourse = resultSet.getDouble("numb_month");
                System.out.println(courseNme + '\t' + countPayCourse);
            }

            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
