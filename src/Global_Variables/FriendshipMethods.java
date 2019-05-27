package Global_Variables;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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

    //get friends list ( emails )
    public static String[] getFriendsEmailList(int userId){
        String[] EmailList=null;

        //connect to data base
        try(Connection con= DriverManager.getConnection(ConnectionVariables.getURL(),ConnectionVariables.getUser(),
                ConnectionVariables.getPassword())){
            //create statement and set parameters
            PreparedStatement get=con.prepareStatement(findUserFriendships);
            get.setInt(1,userId);
            //execute statement
            ResultSet rs=get.executeQuery();//get the id of the users that are friends with userId

            ArrayList<Integer> arInt=new ArrayList<>();

            while(rs.next()){
                arInt.add(rs.getInt("user2"));
            }

            ArrayList<String> ar=new ArrayList<>();

            for(int i=0;i<arInt.size();i++){
                ar.add(UserMethods.getEmail(arInt.get(i)));//adds in ar list the emails that corespond to the user ids found
            }

            EmailList=new String[ar.size()];
            for(int i=0;i<ar.size();i++){
                EmailList[i]=new String(ar.get(i));
            }



        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e2){
            e2.printStackTrace();
        }
        return EmailList;
    }


    //get friends list ( ids )
    public static Integer[] getFriendsIdList(int userId){
        Integer[] IdList=null;

        //connect to data base
        try(Connection con= DriverManager.getConnection(ConnectionVariables.getURL(),ConnectionVariables.getUser(),
                ConnectionVariables.getPassword())){
            //create statement and set parameters
            PreparedStatement get=con.prepareStatement(findUserFriendships);
            get.setInt(1,userId);
            //execute statement
            ResultSet rs=get.executeQuery();//get the id of the users that are friends with userId

            ArrayList<Integer> arInt=new ArrayList<>();

            while(rs.next()){
                arInt.add(rs.getInt("user2"));
            }

            IdList=new Integer[arInt.size()];
            for(int i=0;i<arInt.size();i++){
                IdList[i]=new Integer(arInt.get(i));
            }



        }catch(SQLException e){
            e.printStackTrace();
        }
        return IdList;
    }

    //return true is the 2 users are friends, otherwise false
    public static boolean checkIfFriends(int id1, int id2) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(ConnectionVariables.getURL(), ConnectionVariables.getUser(), ConnectionVariables.getPassword());

        PreparedStatement statement = connection.prepareStatement(areFriends);

        statement.setString(1, String.valueOf(id1));
        statement.setString(2, String.valueOf(id2));

        ResultSet rs = statement.executeQuery();

        boolean bool;
        if(!rs.isBeforeFirst())
            bool = false;
        else
            bool = true;

        connection.close();
        return bool;
    }
}
