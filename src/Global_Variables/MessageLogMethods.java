package Global_Variables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageLogMethods implements SqlQueries {

    //store a message in data base
    public static void addMessageToLog(int idConversation,int messageSource, String text){

        try(Connection con= DriverManager.getConnection(ConnectionVariables.getURL(),ConnectionVariables.getUser(),
                ConnectionVariables.getPassword())){
            //create statement and set parameters
            PreparedStatement add=con.prepareStatement(addMessageToLog);
            add.setInt(1,idConversation);
            add.setInt(2,messageSource);
            add.setString(3,text);
            //execute statement
            add.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
