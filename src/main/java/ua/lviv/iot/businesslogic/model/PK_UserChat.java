package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.Column;

import java.util.Objects;

public class PK_UserChat {
    @Column(name = "chat_id",type = "int")
    private int chatID;

    @Column(name = "chat_style_name",length = 50)
    private String chatStyleName;

    @Column(name="user_id",type = "int")
    private int userID;

    @Column(name = "user_nickname",length = 50)
    private String userNickName;

    public PK_UserChat(){}

    public PK_UserChat(int chatID, String chatStyleName, int userID, String userNickName) {
        this.chatID = chatID;
        this.chatStyleName = chatStyleName;
        this.userID = userID;
        this.userNickName = userNickName;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public String getChatStyleName() {
        return chatStyleName;
    }

    public void setChatStyleName(String chatStyleName) {
        this.chatStyleName = chatStyleName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PK_UserChat)) return false;
        PK_UserChat that = (PK_UserChat) o;
        return getChatID() == that.getChatID() &&
                getUserID() == that.getUserID() &&
                getChatStyleName().equals(that.getChatStyleName()) &&
                getUserNickName().equals(that.getUserNickName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatID(), getChatStyleName(), getUserID(), getUserNickName());
    }

    @Override
    public String toString() {
        return
                "chatID=" + chatID +
                ", chatStyleName='" + chatStyleName + '\'' +
                ", userID=" + userID +
                ", userNickName='" + userNickName ;
    }
}
