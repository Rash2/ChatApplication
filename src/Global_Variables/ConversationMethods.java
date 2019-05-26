package Global_Variables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConversationMethods implements SqlQueries {

    //add conversation in database
    public static void addConversation(String members,String name){
        //connect to data base
        try(Connection con= DriverManager.getConnection(ConnectionVariables.getURL(),ConnectionVariables.getUser(),
                ConnectionVariables.getPassword())){
            //create statement and set parameters
            PreparedStatement add=con.prepareStatement(SqlQueries.addConversation);
            add.setString(1,members);
            add.setString(2,name);
            //execute statement
            add.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    //delete conversation from data base by name
    public static void deleteConversationById(int idconversation){
        //connect to database
        try(Connection con=DriverManager.getConnection(ConnectionVariables.getURL(),ConnectionVariables.getUser(),
                ConnectionVariables.getPassword())){
            //create statement and set parameters
            PreparedStatement delete=con.prepareStatement(SqlQueries.deleteConversationById);
            delete.setInt(1,idconversation);
            //execute statement
            delete.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //update conversation's members
    public static void updateConversationMembersById(String newListOfMembers, int idconversation){
        //connect to database
        try(Connection con=DriverManager.getConnection(ConnectionVariables.getURL(),ConnectionVariables.getUser(),
                ConnectionVariables.getPassword())){
            //create statement and set parameters
            PreparedStatement update=con.prepareStatement(updateConversationMembers);
            update.setString(1,newListOfMembers);
            update.setInt(2,idconversation);
            //execute statement
            update.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //update conversation's name
    public static void updateConversationNameById(String newName, int idconversation){
        //connect to database
        try(Connection con=DriverManager.getConnection(ConnectionVariables.getURL(),ConnectionVariables.getUser(),
                ConnectionVariables.getPassword())){
            //create statement and set parameters
            PreparedStatement update=con.prepareStatement(updateConversationName);
            update.setString(1,newName);
            update.setInt(2,idconversation);
            //execute statement
            update.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }




}
