import Global_Variables.ConversationMethods;
import Global_Variables.HtmlStrings;
import Global_Variables.UserMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ResolveChangeName extends HttpServlet implements HtmlStrings {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        String newConversationName = req.getParameter("conversationName");
        String emailToMessage = req.getParameter("emailToSend");

        try {
            ConversationMethods.updateConversationNameById(newConversationName, ConversationMethods.getConversationId(UserLocalStorage.getCurrentEmail(),emailToMessage));

            out.println(DefaultStartTitle + UserMethods.getFirstName(UserLocalStorage.getCurrentEmail()) + DefaultEndTitle + MessagesConversationNameStart +
                    newConversationName + MessagesConversationNameEnd + MessagesChangeNameStart + emailToMessage + MessagesChangeNameEnd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
