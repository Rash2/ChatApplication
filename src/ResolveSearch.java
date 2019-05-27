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
import java.util.ArrayList;

public class ResolveSearch extends HttpServlet implements HtmlStrings {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        String searchValue = req.getParameter("searchValue");

        String currentEmail = UserLocalStorage.getCurrentEmail();

        if(searchValue.contains("@")) {
            try {
                if(UserMethods.hasEmail(searchValue)) {
                    String foundFirstName = UserMethods.getFirstName(searchValue);
                    String foundLastName = UserMethods.getLastName(searchValue);
                    String foundEmail = searchValue;

                    if(!FriendshipMethods.checkIfFriends(UserMethods.getID(currentEmail),UserMethods.getID(foundEmail)))
                        out.println(DefaultStartTitle + UserMethods.getFirstName(currentEmail) + DefaultEndTitle + SearchPageDisplayTitle +
                            SearchPageDisplayResultStart + foundFirstName + " " +
                            foundLastName + " - " + foundEmail + SearchPageDisplayResultEnd + SearchPageAddFriendStart + foundEmail +
                                SearchPageAddFriendEnd + "</body></html>");
                    else
                        out.println(DefaultStartTitle + UserMethods.getFirstName(currentEmail) + DefaultEndTitle + SearchPageDisplayTitle +
                                SearchPageDisplayResultStart + foundFirstName + " " +
                                foundLastName + " - " + foundEmail + SearchPageDisplayResultEndAlreadyFriends + "</body></html>");
                } else {
                    try {
                        out.println(DefaultStartTitle + UserMethods.getFirstName(currentEmail) + DefaultEndTitle + SearchPageDisplayTitle + SearchPageDisplayNoResults + "</body></html>");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                if(UserMethods.hasName(searchValue)) {
                    ArrayList<String> emails = UserMethods.getEmailsbyName(searchValue);
                    out.println(DefaultStartTitle + UserMethods.getFirstName(currentEmail) + DefaultEndTitle + SearchPageDisplayTitle);

                    for(String result:emails) {
                        if(!result.equals(currentEmail))
                            if(!FriendshipMethods.checkIfFriends(UserMethods.getID(currentEmail),UserMethods.getID(result)))
                                out.println(SearchPageDisplayResultStart + UserMethods.getFirstName(result) + " " +
                                        UserMethods.getLastName(result) + " - " + result + SearchPageDisplayResultEnd
                                        + SearchPageAddFriendStart + result + SearchPageAddFriendEnd+ "</body></html>");
                            else
                                out.println(SearchPageDisplayResultStart + UserMethods.getFirstName(result) + " " +
                                        UserMethods.getLastName(result) + " - " + result + SearchPageDisplayResultEndAlreadyFriends + "</body></html>");

                    }
                } else {
                    try {
                        out.println(DefaultStartTitle + UserMethods.getFirstName(currentEmail) + DefaultEndTitle + SearchPageDisplayTitle + SearchPageDisplayNoResults + "</body></html>");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
