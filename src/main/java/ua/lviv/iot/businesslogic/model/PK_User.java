package ua.lviv.iot.businesslogic.model;

import ua.lviv.iot.businesslogic.model.annotations.Column;

import java.util.Objects;

public class PK_User {
    @Column(name = "id", type = "int")
    private int id;

    @Column(name = "nickname", length = 50)
    private String nickname;

    public PK_User() {

    }

    public PK_User(int id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PK_User pk_user = (PK_User) o;
        return getId() == pk_user.getId() &&
                getNickname().equals(pk_user.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNickname());
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nickname='" + nickname;
    }
}
