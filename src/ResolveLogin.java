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

public class ResolveLogin extends HttpServlet implements HtmlStrings {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String emailAddress = req.getParameter("emailAddress");
        String password = req.getParameter("password");

        resp.setContentType("text/html");

        try {//check if a field is missing
            if (!emailAddress.isEmpty() && !password.isEmpty()) {
                // Check if the email exists
                if (UserMethods.hasEmail(emailAddress)) {
                    //Check if the email matches the password
                    if (password.equals(UserMethods.getPassword(emailAddress))) {
                        //Go to the user page
                        RequestDispatcher rd = req.getRequestDispatcher("friendList");
                        rd.forward(req,resp);
                    } else {
                        out.println(LoginPageInvalidPassword);
                    }
                } else {
                    out.println(LoginPageInexistentEmail);
                }
            }
            else {
                out.println(LoginPageEmptyFields);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
