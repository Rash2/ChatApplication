import Global_Variables.HtmlStrings;
import Global_Variables.UserMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ResolveFriendList extends HttpServlet implements HtmlStrings {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        String email = req.getParameter("emailAddress");
        try {
            String firstName = UserMethods.getFirstName(email);
            String lastName = UserMethods.getLastName(email);

            out.println(FriendListPageDefaultStartTitle + firstName + FriendListPageDefaultEndTitle +
                    FriendListPageDefaultDisplayHeaderStart + firstName + FriendListPageDefaultDisplayHeaderEnd);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
