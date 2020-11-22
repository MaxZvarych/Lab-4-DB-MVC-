package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.Column;

import java.util.Objects;

public class PK_ChatMessage {
    @Column(name = "chat_id",type = "int")
    private int chatID;

    @Column(name="message_id",type = "int")
    private int messageID;

    @Column(name = "chat_style_name",length = 50)
    private String chatStyleName;

    public PK_ChatMessage(){}

    public PK_ChatMessage(int chatID, int messageID, String chatStyleName) {
        this.chatID = chatID;
        this.messageID = messageID;
        this.chatStyleName = chatStyleName;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getChatStyleName() {
        return chatStyleName;
    }

    public void setChatStyleName(String chatStyleName) {
        this.chatStyleName = chatStyleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PK_ChatMessage)) return false;
        PK_ChatMessage that = (PK_ChatMessage) o;
        return getChatID() == that.getChatID() &&
                getMessageID() == that.getMessageID() &&
                getChatStyleName().equals(that.getChatStyleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatID(), getMessageID(), getChatStyleName());
    }

    @Override
    public String toString() {
        return
                "chatID=" + chatID +
                ", messageID=" + messageID +
                ", chatStyleName='" + chatStyleName;
    }
}
