package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.*;
import ua.lviv.iot.businesslogic.model.PK_User;

import java.util.Objects;

@Table(name ="user")
public class User {
    @PrimaryKeyComposite
    private PK_User pk;

    @Column(name="Discord_version",type = "int")
    private int discordVersion;

    public User() {
    }

    public User(PK_User pk, int discordVersion) {
        this.pk = pk;
        this.discordVersion = discordVersion;
    }

    public PK_User getPk() {
        return pk;
    }

    public void setPk(PK_User pk) {
        this.pk = pk;
    }

    public int getDiscordVersion() {
        return discordVersion;
    }

    public void setDiscordVersion(int discordVersion) {
        this.discordVersion = discordVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getDiscordVersion() == user.getDiscordVersion() &&
                getPk().equals(user.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk(), getDiscordVersion());
    }

    @Override
    public String toString() {
        return "User{" +
                 pk +
                ", discordVersion=" + discordVersion +
                '}';
    }
}
