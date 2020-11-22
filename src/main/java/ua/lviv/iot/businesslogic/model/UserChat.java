package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.*;

import java.util.Objects;

@Table(name = "user_has_chat")
public class UserChat {
    @PrimaryKeyComposite
    private PK_UserChat pk;

    @Column(name = "chat_name",length = 50)
    private String chatName;

    public  UserChat(){}

    public UserChat(PK_UserChat pk, String chatName) {
        this.pk = pk;
        this.chatName = chatName;
    }

    public PK_UserChat getPk() {
        return pk;
    }

    public void setPk(PK_UserChat pk) {
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
        if (!(o instanceof UserChat)) return false;
        UserChat userChat = (UserChat) o;
        return getPk().equals(userChat.getPk()) &&
                getChatName().equals(userChat.getChatName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk(), getChatName());
    }

    @Override
    public String toString() {
        return "UserChat{" +
                "pk=" + pk +
                ", chatName='" + chatName + '\'' +
                '}';
    }
}
