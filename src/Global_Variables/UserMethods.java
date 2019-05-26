package Global_Variables;

import java.sql.*;

public class UserMethods implements SqlQueries {

    // User methods

    public static void addUser(String firstName, String lastName, String sex, int year, int month, int day, String email, String password) throws SQLException, ClassNotFoundException {

        Date birthdate = new Date(year,month,day);
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());
        PreparedStatement statement = connection.prepareStatement(addNewUser);

        statement.setString(1,firstName);
        statement.setString(2,lastName);
        statement.setString(3,sex);
        statement.setDate(4,birthdate);
        statement.setString(5,email);
        statement.setString(6,password);

        int i = statement.executeUpdate();
        System.out.println(i + " records inserted");

        connection.close();

    }

    public static void deleteUserByEmail(String email) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(deleteUserByEmail);

        statement.setString(1, email);

        int i = statement.executeUpdate();

        System.out.println(i + " records deleted");

        connection.close();
    }

    public static void findUserByEmail(String email) throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(findUserByEmail);

        statement.setString(1, email);

        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            System.out.print(rs.getString(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.print(rs.getString(4) + " ");
            System.out.print(rs.getString(5) + " ");
            System.out.print(rs.getString(6) + " ");
            System.out.print(rs.getString(7) + " ");
            System.out.println();
        }

        connection.close();
    }

    public static void findUserByFirstName(String firstName) throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(findUserByFirstName);

        statement.setString(1,firstName);

        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            System.out.print(rs.getString(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.print(rs.getString(4) + " ");
            System.out.print(rs.getString(5) + " ");
            System.out.print(rs.getString(6) + " ");
            System.out.print(rs.getString(7) + " ");
            System.out.println();
        }

        connection.close();
    }

    public static void findUserByLastName(String lastName) throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.cj.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(findUserByLastName);

        statement.setString(1,lastName);

        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            System.out.print(rs.getString(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.print(rs.getString(4) + " ");
            System.out.print(rs.getString(5) + " ");
            System.out.print(rs.getString(6) + " ");
            System.out.print(rs.getString(7) + " ");
            System.out.println();
        }

        connection.close();
    }

    public static boolean hasEmail(String email) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(findUserByEmail);

        statement.setString(1, email);

        ResultSet rs = statement.executeQuery();

        boolean bool;
        if(!rs.isBeforeFirst())
            bool = false;
        else
            bool = true;

        connection.close();
        return bool;
    }

    public static String getPassword(String email) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(getUserPassword);

        statement.setString(1,email);

        ResultSet rs = statement.executeQuery();
        rs.next();
        String psw  = rs.getString("password");

        connection.close();

        return psw;
    }

    public static String getFirstName(String email) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(getUserFirstName);

        statement.setString(1,email);

        ResultSet rs = statement.executeQuery();
        rs.next();
        String fn  = rs.getString("firstname");

        connection.close();

        return fn;
    }

    public static String getLastName(String email) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(getUserLastName);

        statement.setString(1,email);

        ResultSet rs = statement.executeQuery();
        rs.next();
        String ln = rs.getString("lastname");

        connection.close();

        return ln;
    }

    public static String getEmail(int id) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(getUserEmail);

        statement.setInt(1,id);

        ResultSet rs = statement.executeQuery();
        rs.next();
        String ln = rs.getString("email");

        connection.close();

        return ln;
    }

    public static int getID(String email) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(getUserId);

        statement.setString(1,email);

        ResultSet rs = statement.executeQuery();
        rs.next();
        int ln = rs.getInt("id");

        connection.close();

        return ln;
    }
}
