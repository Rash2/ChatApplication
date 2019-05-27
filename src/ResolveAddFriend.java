import Global_Variables.FriendshipMethods;
import Global_Variables.HtmlStrings;
import Global_Variables.UserMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static Global_Variables.HtmlStrings.FriendListPageDefaultLogout;

public class ResolveAddFriend extends HttpServlet implements HtmlStrings {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        String emailToAdd = req.getParameter("emailToAdd");

        try {
            if(!FriendshipMethods.checkIfFriends(UserMethods.getID(UserLocalStorage.getCurrentEmail()),UserMethods.getID(emailToAdd))) {
                FriendshipMethods.addFriendship(UserMethods.getID(UserLocalStorage.getCurrentEmail()),UserMethods.getID(emailToAdd));

                String firstName = UserMethods.getFirstName(UserLocalStorage.getCurrentEmail());

                out.println(DefaultStartTitle + firstName + DefaultEndTitle +
                        FriendListPageDefaultDisplayHeaderStart + firstName + FriendListPageDefaultDisplayHeaderEnd);

                int id = UserMethods.getID(UserLocalStorage.getCurrentEmail());

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
