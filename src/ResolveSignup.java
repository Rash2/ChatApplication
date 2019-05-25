import Global_Variables.HtmlStrings;
import Global_Variables.UserMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

public class ResolveSignup extends HttpServlet implements HtmlStrings {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String userEmail = req.getParameter("email");

        resp.setContentType("text/html");
        try {
            if(UserMethods.hasEmail(userEmail))
                out.println(HtmlStrings.SignUpPageUserAlreadyExists);
            else {
                String firstName = req.getParameter("firstname");
                String lastName = req.getParameter("lastname");
                String gender = req.getParameter("gender");
                Date birthdate;
                birthdate = Date.valueOf(req.getParameter("birthdate"));
                String password = req.getParameter("password");
                String confirm_password = req.getParameter("confirm_password");

                if(password.equals(confirm_password)) {
                    if(!firstName.isEmpty() && !lastName.isEmpty() && !gender.isEmpty()
                            && !birthdate.toString().isEmpty() && !password.isEmpty() && !confirm_password.isEmpty()) {
                        UserMethods.addUser(firstName, lastName, gender, birthdate.getYear(), birthdate.getMonth(), birthdate.getDay(), userEmail, password);
                        out.println(HtmlStrings.LoginPageDefault);
                    } else {
                        out.println(HtmlStrings.SignUpPageEmptyFields);
                    }
                } else {
                    out.println(HtmlStrings.SignUpPageMismatchedPasswords);
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
