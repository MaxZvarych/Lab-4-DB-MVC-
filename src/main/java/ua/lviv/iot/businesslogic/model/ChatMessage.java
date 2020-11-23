package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.*;

import java.util.Objects;

@Table(name="chat_has_message")
public class ChatMessage {
    @PrimaryKeyComposite
    private PK_ChatMessage pk;

    @Column(name = "chat_name",length = 50)
    private String chatName;

    public ChatMessage(){
    }

    public ChatMessage(PK_ChatMessage pk, String chatName) {
        this.pk = pk;
        this.chatName = chatName;
    }

    public PK_ChatMessage getPk() {
        return pk;
    }

    public void setPk(PK_ChatMessage pk) {
        this.pk = pk;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatMessage)) return false;
        ChatMessage that = (ChatMessage) o;
        return getPk().equals(that.getPk()) &&
                getChatName().equals(that.getChatName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk(), getChatName());
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                 pk +
                ", chatName='" + chatName + '\'' +
                '}';
    }
}
