package Global_Variables;


import java.util.ArrayList;
import java.sql.*;

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

    // method that verifies if a conversation between two users exists
    public static boolean conversationExists(String email1,String email2) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(findConversationByMembers);

        StringBuffer aux=new StringBuffer("");
        aux.append(email1);
        aux.append(";");
        aux.append(email2);

        statement.setString(1, aux.toString());

        ResultSet rs = statement.executeQuery();

        boolean bool;
        if (!rs.isBeforeFirst())
            bool = false;
        else
            bool = true;

        connection.close();
        return bool;
    }

    // method that returns the id of the conversation based on the members, -1 if the conversation doesn't exist
    public static int getConversationId(String email1,String email2) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(findConversationByMembers);

        StringBuffer aux=new StringBuffer();
        aux.append(email1);
        aux.append(";");
        aux.append(email2);

        String auxString=new String(aux);

        statement.setString(1, auxString);

        ResultSet rs = statement.executeQuery();

        int rt = -1;

        if(rs.next())
            rt = rs.getInt("idconversation");

        if(rt != -1) {
            connection.close();
            return rt;
        }

        //switch the email's positions
        StringBuffer aux2=new StringBuffer();
        aux.append(email2);
        aux.append(";");
        aux.append(email1);

        String aux2String=new String(aux2);

        statement.setString(1, aux2String);

        rs=statement.executeQuery();

        if(rs.next()){
            rt=rs.getInt("idconversation");
        }else{
            rt=-1;
        }

        connection.close();

        return rt;
    }
}
