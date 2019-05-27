import Global_Variables.ConversationMethods;
import Global_Variables.HtmlStrings;
import Global_Variables.MessageLog;
import Global_Variables.UserMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResolveMessage extends HttpServlet implements HtmlStrings {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        String emailToMessage = req.getParameter("emailToMessage");

        try {
            out.println(DefaultStartTitle + UserMethods.getFirstName(UserLocalStorage.getCurrentEmail()) + DefaultEndTitle);

            StringBuffer conversationMembers = new StringBuffer();
            conversationMembers.append(UserLocalStorage.getCurrentEmail());
            conversationMembers.append(";");
            conversationMembers.append(emailToMessage);

            StringBuffer conversationName = new StringBuffer();
            conversationName.append(UserMethods.getFirstName(UserLocalStorage.getCurrentEmail()));
            conversationName.append(" - ");
            conversationName.append(UserMethods.getFirstName(emailToMessage));

            String cnvMembers = new String(conversationMembers);
            String cnvName = new String(conversationName);

            if(!(ConversationMethods.conversationExists(UserLocalStorage.getCurrentEmail(),emailToMessage) ||
                    ConversationMethods.conversationExists(emailToMessage,UserLocalStorage.getCurrentEmail()))) {
                ConversationMethods.addConversation(cnvMembers, cnvName);
            }

            out.println(MessagesConversationNameStart + conversationName + MessagesConversationNameEnd + MessagesChangeNameStart + emailToMessage
                    + MessagesChangeNameEnd + SendMessageStart + emailToMessage + SendMessageEnd);

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
