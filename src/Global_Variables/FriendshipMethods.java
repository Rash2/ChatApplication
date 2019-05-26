package Global_Variables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FriendshipMethods implements SqlQueries {

    //add a friendship in database
    public static void addFriendship(int user1,int user2){
        //connect to database
        try(Connection con= DriverManager.getConnection(ConnectionVariables.getURL(),ConnectionVariables.getUser(),
                ConnectionVariables.getPassword())){
            //create statement and set parameters
            PreparedStatement add=con.prepareStatement(addFriendship);
            add.setInt(1,user1);
            add.setInt(2,user2);
            add.setDate(3,new java.sql.Date(new java.util.Date().getTime()));
            //execute statement
            add.executeUpdate();
            //if there is a user1-user2 friendship , there should be a user2-user1 friendship too
            //switch user parameters
            add.setInt(1,user2);
            add.setInt(2,user1);
            //execute statement
            add.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



    //delete a friendship from data base
    public static void deleteFriendship(int user1,int user2){
        //connect to data base
        try(Connection con= DriverManager.getConnection(ConnectionVariables.getURL(),ConnectionVariables.getUser(),
                ConnectionVariables.getPassword())){
            //create statement and set parameters
            PreparedStatement delete=con.prepareStatement(deleteFriendship);
            delete.setInt(1,user1);
            delete.setInt(2,user2);
            //execute statement
            delete.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
