package Global_Variables;

public interface HtmlStrings {
    String SignUpPageUserAlreadyExists = "<html>\n" +
            "<head>\n" +
            "    <title>Sign Up</title>\n" +
            "    <style>\n" +
            "        label,form,h1 {\n" +
            "            font-family: sans-serif;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1 style=\"top: 2%;left: 37%;position: absolute;\">Sign up to chat with others!</h1>\n" +
            "<h1 style=\"top: 7%;left: 36%;position: absolute;color:red;\">Email has already been taken</h1>" +
            "<div style=\"border-left: 3px solid black;width: 200px;height: 530px;margin: 0 auto;background-color: beige;margin-top: 8%\">\n" +
            "    <form action=\"/submit\" style=\"width: 165px;margin: 0 auto;position: absolute;top: 20%;left: 45%;\" method=\"post\">\n" +
            "        <label for=\"firstname\">First Name:</label>\n" +
            "        <br>\n" +
            "        <input type=\"text\" name=\"firstname\" id=\"firstname\">\n" +
            "        <br><br>\n" +
            "        <label for=\"lastname\">Last Name:</label>\n" +
            "        <br>\n" +
            "        <input type=\"text\" name=\"lastname\" id=\"lastname\">\n" +
            "        <br><br>\n" +
            "        <fieldset>\n" +
            "            <legend>Gender:</legend>\n" +
            "            Male\n" +
            "            <input type=\"radio\" name=\"gender\" value=\"Male\"><br>\n" +
            "            Female\n" +
            "            <input type=\"radio\" name=\"gender\" value=\"Female\">\n" +
            "        </fieldset>\n" +
            "        <br>\n" +
            "        <label for=\"birthdate\">Birthdate:</label>\n" +
            "        <br>\n" +
            "        <input type=\"date\" name=\"birthdate\" id=\"birthdate\">\n" +
            "        <br><br>\n" +
            "        <label for=\"email\">E-mail address:</label>\n" +
            "        <br>\n" +
            "        <input type=\"text\" name=\"email\" id=\"email\">\n" +
            "        <br><br>\n" +
            "        <label for=\"password\">Password:</label>\n" +
            "        <br>\n" +
            "        <input type=\"password\" name=\"password\" id=\"password\">\n" +
            "        <br><br>\n" +
            "        <label for=\"confirm_password\">Confirm password:</label>\n" +
            "        <br>\n" +
            "        <input type=\"password\" name=\"confirm_password\" id=\"confirm_password\">\n" +
            "        <br><br>\n" +
            "        <input type=\"submit\" value=\"Sign Up\">\n" +
            "    </form>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";

    String SignUpPageMismatchedPasswords = "<html>\n" +
            "<head>\n" +
            "    <title>Sign Up</title>\n" +
            "    <style>\n" +
            "        label,form,h1 {\n" +
            "            font-family: sans-serif;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1 style=\"top: 2%;left: 37%;position: absolute;\">Sign up to chat with others!</h1>\n" +
            "<h1 style=\"top: 7%;left: 36%;position: absolute;color:red;\">The passwords do not match</h1>" +
            "<div style=\"border-left: 3px solid black;width: 200px;height: 530px;margin: 0 auto;background-color: beige;margin-top: 8%\">\n" +
            "    <form action=\"/submit\" style=\"width: 165px;margin: 0 auto;position: absolute;top: 20%;left: 45%;\" method=\"post\">\n" +
            "        <label for=\"firstname\">First Name:</label>\n" +
            "        <br>\n" +
            "        <input type=\"text\" name=\"firstname\" id=\"firstname\">\n" +
            "        <br><br>\n" +
            "        <label for=\"lastname\">Last Name:</label>\n" +
            "        <br>\n" +
            "        <input type=\"text\" name=\"lastname\" id=\"lastname\">\n" +
            "        <br><br>\n" +
            "        <fieldset>\n" +
            "            <legend>Gender:</legend>\n" +
            "            Male\n" +
            "            <input type=\"radio\" name=\"gender\" value=\"Male\"><br>\n" +
            "            Female\n" +
            "            <input type=\"radio\" name=\"gender\" value=\"Female\">\n" +
            "        </fieldset>\n" +
            "        <br>\n" +
            "        <label for=\"birthdate\">Birthdate:</label>\n" +
            "        <br>\n" +
            "        <input type=\"date\" name=\"birthdate\" id=\"birthdate\">\n" +
            "        <br><br>\n" +
            "        <label for=\"email\">E-mail address:</label>\n" +
            "        <br>\n" +
            "        <input type=\"text\" name=\"email\" id=\"email\">\n" +
            "        <br><br>\n" +
            "        <label for=\"password\">Password:</label>\n" +
            "        <br>\n" +
            "        <input type=\"password\" name=\"password\" id=\"password\">\n" +
            "        <br><br>\n" +
            "        <label for=\"confirm_password\">Confirm password:</label>\n" +
            "        <br>\n" +
            "        <input type=\"password\" name=\"confirm_password\" id=\"confirm_password\">\n" +
            "        <br><br>\n" +
            "        <input type=\"submit\" value=\"Sign Up\">\n" +
            "    </form>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";

    String SignUpPageEmptyFields = "<html>\n" +
            "<head>\n" +
            "    <title>Sign Up</title>\n" +
            "    <style>\n" +
            "        label,form,h1 {\n" +
            "            font-family: sans-serif;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1 style=\"top: 2%;left: 37%;position: absolute;\">Sign up to chat with others!</h1>\n" +
            "<h1 style=\"top: 7%;left: 38%;position: absolute;color:red;\">Please fill out all the fields</h1>" +
            "<div style=\"border-left: 3px solid black;width: 200px;height: 530px;margin: 0 auto;background-color: beige;margin-top: 8%\">\n" +
            "    <form action=\"/submit\" style=\"width: 165px;margin: 0 auto;position: absolute;top: 20%;left: 45%;\" method=\"post\">\n" +
            "        <label for=\"firstname\">First Name:</label>\n" +
            "        <br>\n" +
            "        <input type=\"text\" name=\"firstname\" id=\"firstname\">\n" +
            "        <br><br>\n" +
            "        <label for=\"lastname\">Last Name:</label>\n" +
            "        <br>\n" +
            "        <input type=\"text\" name=\"lastname\" id=\"lastname\">\n" +
            "        <br><br>\n" +
            "        <fieldset>\n" +
            "            <legend>Gender:</legend>\n" +
            "            Male\n" +
            "            <input type=\"radio\" name=\"gender\" value=\"Male\"><br>\n" +
            "            Female\n" +
            "            <input type=\"radio\" name=\"gender\" value=\"Female\">\n" +
            "        </fieldset>\n" +
            "        <br>\n" +
            "        <label for=\"birthdate\">Birthdate:</label>\n" +
            "        <br>\n" +
            "        <input type=\"date\" name=\"birthdate\" id=\"birthdate\">\n" +
            "        <br><br>\n" +
            "        <label for=\"email\">E-mail address:</label>\n" +
            "        <br>\n" +
            "        <input type=\"text\" name=\"email\" id=\"email\">\n" +
            "        <br><br>\n" +
            "        <label for=\"password\">Password:</label>\n" +
            "        <br>\n" +
            "        <input type=\"password\" name=\"password\" id=\"password\">\n" +
            "        <br><br>\n" +
            "        <label for=\"confirm_password\">Confirm password:</label>\n" +
            "        <br>\n" +
            "        <input type=\"password\" name=\"confirm_password\" id=\"confirm_password\">\n" +
            "        <br><br>\n" +
            "        <input type=\"submit\" value=\"Sign Up\">\n" +
            "    </form>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";

    String LoginPageDefault = "<html>\n" +
            "<head>\n" +
            "  <title>Login</title>\n" +
            "  <style>\n" +
            "    label,a,h1 {\n" +
            "      font-family: sans-serif;\n" +
            "    }\n" +
            "  </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1 style=\"position: absolute;top: 5%;left: 45%\">Welcome!</h1>\n" +
            "<div style=\"border-left: 3px solid black;width: 200px;height: 250px;margin: 0 auto;margin-top: 10%;background-color: beige\">\n" +
            "  <form action=\"/login\" method=\"post\" style=\"width: 165px;margin: 0 auto;position: absolute;top: 25%;left: 45%;\">\n" +
            "    <label for=\"emailAddress\">Email:</label>\n" +
            "    <br>\n" +
            "    <input type=\"text\" name=\"emailAddress\" id=\"emailAddress\">\n" +
            "    <br><br>\n" +
            "    <label for=\"password\">Password:</label>\n" +
            "    <br>\n" +
            "    <input type=\"password\" name=\"password\" id=\"password\">\n" +
            "    <br>\n" +
            "    <input type=\"submit\" value=\"Login\">\n" +
            "  </form>\n" +
            "  <a href=\"SignUpPage.jsp\" style=\"margin: 0 auto;position: absolute;top: 43%;left: 45%;\">No account? Click here</a>\n" +
            "  <a href=\" \" style=\"margin: 0 auto;position: absolute;top: 48%;left: 45%;\">Forgot password?</a>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";
}
