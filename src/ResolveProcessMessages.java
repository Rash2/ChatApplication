import Global_Variables.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResolveProcessMessages extends HttpServlet implements HtmlStrings {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        String message = req.getParameter("messageSent");
        String emailToMessage = req.getParameter("emailToSend");

        StringBuffer conversationName = new StringBuffer();
        try {
            conversationName.append(UserMethods.getFirstName(UserLocalStorage.getCurrentEmail()));
            conversationName.append(" - ");
            conversationName.append(UserMethods.getFirstName(emailToMessage));

            out.println(DefaultStartTitle + UserMethods.getFirstName(UserLocalStorage.getCurrentEmail()) + DefaultEndTitle + MessagesConversationNameStart +
                    conversationName + MessagesConversationNameEnd + MessagesChangeNameStart + emailToMessage + MessagesChangeNameEnd +
                    SendMessageStart + emailToMessage + SendMessageEnd);

            MessageLogMethods.addMessageToLog(ConversationMethods.getConversationId(UserLocalStorage.getCurrentEmail(),emailToMessage),UserMethods.getID(UserLocalStorage.getCurrentEmail()),message);
            ArrayList<MessageLog> messages = ConversationMethods.getConversationMessages(ConversationMethods.getConversationId(UserLocalStorage.getCurrentEmail(),emailToMessage));

            for(MessageLog msg:messages) {
                out.println(BeforeName + UserMethods.getFirstName(UserMethods.getEmail(msg.getMessageSource())) + AfterName + msg.getText() + AfterMessage);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
