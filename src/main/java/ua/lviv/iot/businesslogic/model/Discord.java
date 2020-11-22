package ua.lviv.iot.businesslogic.model;

import ua.lviv.iot.businesslogic.model.annotations.*;

import java.util.Objects;

@Table(name = "discord")
public class Discord {
    @PrimaryKey
    @Column(name = "version", type = "int")
    private int version;

    @Column(name = "update_available", type = "boolean")
    private boolean updateAvailable;

    @Column(name = "settings", length = 50)
    private String settings;

    public Discord() {

    }

    public Discord(int version, boolean updateAvailable, String settings) {
        this.version = version;
        this.updateAvailable = updateAvailable;
        this.settings = settings;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isUpdateAvailable() {
        return updateAvailable;
    }

    public void setUpdateAvailable(boolean updateAvailable) {
        this.updateAvailable = updateAvailable;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discord discord = (Discord) o;
        return getVersion() == discord.getVersion() &&
                isUpdateAvailable() == discord.isUpdateAvailable() &&
                getSettings().equals(discord.getSettings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVersion(), isUpdateAvailable(), getSettings());
    }

    @Override
    public String toString() {
        return "Discord{" +
                "version=" + version +
                ", updateAvailable=" + updateAvailable +
                ", settings='" + settings + '\'' +
                '}';
    }
}
