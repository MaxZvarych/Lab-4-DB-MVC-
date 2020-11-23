package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.*;
import ua.lviv.iot.businesslogic.model.PK_Chat;
import java.util.Objects;

@Table(name = "chat")
public class Chat {
    @PrimaryKeyComposite
    private PK_Chat pk;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "region",length = 50)
    private String region;

    @Column(name="Discord_version",type = "int")
    private int discordVersion;

public Chat(){

}

    public Chat(PK_Chat pk, String name, String region, int discordVersion) {
        this.pk = pk;
        this.name = name;
        this.region = region;
        this.discordVersion = discordVersion;
    }

    public PK_Chat getPk() {
        return pk;
    }

    public void setPk(PK_Chat pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
        if (!(o instanceof Chat)) return false;
        Chat chat = (Chat) o;
        return getDiscordVersion() == chat.getDiscordVersion() &&
                getPk().equals(chat.getPk()) &&
                getName().equals(chat.getName()) &&
                getRegion().equals(chat.getRegion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk(), getName(), getRegion(), getDiscordVersion());
    }

    @Override
    public String toString() {
        return "Chat{" +
                 pk +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", discordVersion=" + discordVersion +
                '}';
    }
}
