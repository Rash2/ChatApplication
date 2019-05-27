import Global_Variables.FriendshipMethods;
import Global_Variables.HtmlStrings;
import Global_Variables.UserMethods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResolveFriendList extends HttpServlet implements HtmlStrings {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        String email = req.getParameter("emailAddress");
        UserLocalStorage.setCurrentEmail(email);
        try {
            String firstName = UserMethods.getFirstName(email);

            out.println(DefaultStartTitle + firstName + DefaultEndTitle +
                    FriendListPageDefaultDisplayHeaderStart + firstName + FriendListPageDefaultDisplayHeaderEnd);

            int id = UserMethods.getID(email);

            String friendsEmail[] = FriendshipMethods.getFriendsEmailList(id);

            String friendsFirstName[] = new String[friendsEmail.length];
            String friendsLastName[] = new String[friendsEmail.length];

            for(int i = 0; i < friendsEmail.length; i++) {
                friendsFirstName[i] = UserMethods.getFirstName(friendsEmail[i]);
                friendsLastName[i] = UserMethods.getLastName(friendsEmail[i]);
            }

            for(int i = 0; i < friendsEmail.length; i++)
                out.println(FriendListPageDefaultDisplayFriendStart + friendsFirstName[i] + " " + friendsLastName[i] + FriendListPageDefaultDisplayFriendEnd);

            out.println(FriendListPageDefaultLogout);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
