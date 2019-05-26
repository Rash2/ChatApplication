public class MessageLog {

    private int idMessage;
    private int idConversation;//id of the conversation thtat contains this message
    private int messageSource;//id of the user that sent the message
    private String text;//content of the message

    public MessageLog(int idConversation, int messageSource, String text) {
        this.idConversation = idConversation;
        this.messageSource = messageSource;
        this.text = text;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdConversation() {
        return idConversation;
    }

    public void setIdConversation(int idConversation) {
        this.idConversation = idConversation;
    }

    public int getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(int messageSource) {
        this.messageSource = messageSource;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
