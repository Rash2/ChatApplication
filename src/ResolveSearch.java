import Global_Variables.HtmlStrings;
import Global_Variables.UserMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

                    out.println(DefaultStartTitle + UserMethods.getFirstName(currentEmail) + DefaultEndTitle + SearchPageDisplayTitle +
                            SearchPageDisplayResultStart + foundFirstName + " " +
                            foundLastName + " - " + foundEmail + SearchPageDisplayResultEnd + "</body></html?");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
