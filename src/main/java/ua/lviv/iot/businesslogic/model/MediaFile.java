package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.*;

import java.util.Objects;

@Table(name="media_file")
public class MediaFile {
    @PrimaryKey
    @Column(name="id",type = "int")
    private int id;

    @Column(name="file_type",length = 50)
    private String fileType;

    @Column(name="chat_id",type = "int")
    private int chatID;

    public MediaFile(){

    }

    public MediaFile(int id, String fileType, int chatID) {
        this.id = id;
        this.fileType = fileType;
        this.chatID = chatID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MediaFile)) return false;
        MediaFile mediaFile = (MediaFile) o;
        return getId() == mediaFile.getId() &&
                getChatID() == mediaFile.getChatID() &&
                getFileType().equals(mediaFile.getFileType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFileType(), getChatID());
    }

    @Override
    public String toString() {
        return "MediaFile{" +
                "id=" + id +
                ", fileType='" + fileType + '\'' +
                ", chatID=" + chatID +
                '}';
    }
}
