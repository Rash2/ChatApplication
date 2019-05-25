package Global_Variables;

public interface SqlQueries {
    String addNewUser="INSERT INTO users ( firstname, lastname, sex, birthdate, email, password)" +
            "VALUES (?, ? , ? , ? , ? , ? )";

    String deleteUserByEmail="DELETE FROM users WHERE email = ?";

    String findUserByEmail="SELECT * FROM users WHERE email = ?";

    String findUserByFirstName="SELECT * FROM users WHERE  firstname = ?";

    String findUserByLastName="SELECT * FROM users WHERE  lastname = ?";

    //Queries for message_log table
    public static final String addMessageToLog="INSERT INTO message_log (idconversation, msg_source, text) " +
            "VALUES (?, ?, ?)";

    public static final String findMessageInLogByConversation="SELECT * FROM message_log WHERE idconversation = ?";

    public static final String deleteMessageFromLogByConversation="DELETE FROM message_log WHERE idconversation = ?";


    //Queries for conversation table
    public static final String addConversation="INSERT INTO conversation (members, name) " +
            "VALUES ( ?, ?)";

    public static final String updateConversationMembers="UPDATE conversation SET members = ? WHERE idconversation = ?";

    public static final String updateConversationName="UPDATE conversation SET name = ? WHERE idconversation = ?";

    public static final String deleteConversationByMembers="DELETE FROM conversation WHERE members = ?";

    public static final String deleteConversationById="DELETE FROM conversation WHERE idconversation = ?";

    public static final String findConversationById="SELECT * FROM conversation WHERE idconversation = ?";

    public static final String findConversationByMembers="SELECT * FROM conversation WHERE members = ?";

    public static final String findConversationByOneMember="SELECT * FROM conversation WHERE members LIKE  '%?%' ";

    public static final String findConversationByName="SELECT * FROM conversation WHERE name = ?";


    //Queries for friendship table
    public static final String addFriendship="INSERT INTO friendship (user1, user2, date)" +
            "VALUES (?, ?, ?)";

    public static final String deleteFriendship="DELETE FROM friendship WHERE user1 = ? AND user2 = ?";

    public static final String findUserFriendships="SELECT * FROM friendship WHERE user1 = ?";


    //Queries for friendship_requests table
    public static final String addFriendshipRequest="INSERT INTO friendship_requests (user1, user2, date)" +
            "VALUES (?, ?, ?)";

    public static final String deleteFriendshipRequest="DELETE FROM friendship_requests WHERE user1 = ? AND user2 = ?";//deletes one request

    public static final String deleteUserFriendshipRequests="DELETE FROM friendship_requests WHERE user2 = ?";//deletes all the requests that an user has

    public static final String findUserFriendshipRequests="SELECT * FROM friendship_requests WHERE user2 = ?";
}
