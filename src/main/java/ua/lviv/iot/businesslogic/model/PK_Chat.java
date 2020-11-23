package ua.lviv.iot.businesslogic.model;

import ua.lviv.iot.businesslogic.model.annotations.Column;

import java.util.Objects;

public class PK_Chat {
    @Column(name = "id",type = "int")
    private int id;

    @Column(name="chat_style_name",length = 50)
    private String chatStyleName;

    public PK_Chat(){

    }

    public PK_Chat(int id, String chatStyleName) {
        this.id = id;
        this.chatStyleName = chatStyleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (!(o instanceof PK_Chat)) return false;
        PK_Chat pk_chat = (PK_Chat) o;
        return getId() == pk_chat.getId() &&
                getChatStyleName().equals(pk_chat.getChatStyleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getChatStyleName());
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", chatStyleName='" + chatStyleName;
    }
}
