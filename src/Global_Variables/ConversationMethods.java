package Global_Variables;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class ConversationMethods implements SqlQueries {

    //add conversation in database
    public static void addConversation(String members,String name){
        //connect to data basea
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

    //get all the messages from a conversation
    public static ArrayList<MessageLog> getConversationMessages(int idConversation) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(findMessagesInLogByConversation);

        statement.setInt(1, idConversation);

        ResultSet rs = statement.executeQuery();
        ArrayList<MessageLog> ar=new ArrayList<>();

        while(rs.next()){
            ar.add(new MessageLog(rs.getInt("idconversation"),rs.getInt("msg_source"),rs.getString("text")));
        }



        connection.close();

        return ar;
    }




}
