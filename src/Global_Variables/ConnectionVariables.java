/*
Class that constains the URL , the user and password of the connection
 */

package Global_Variables;

public class ConnectionVariables {
    private static String URL="jdbc:mysql://localhost:3306/chatapp";
    private static String user="root";
    private static String password="";

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        ConnectionVariables.URL = URL;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        ConnectionVariables.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ConnectionVariables.password = password;
    }
}
