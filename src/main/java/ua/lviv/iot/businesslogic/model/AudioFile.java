package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.*;

import java.util.Objects;

@Table(name="audio_file")
public class AudioFile {
    @PrimaryKey
    @Column(name = "id",type = "int")
    private int id;

    @Column(name="is_voice_message",type = "boolean")
    private boolean isVoiceMessage;

    @Column(name="chat_id",type = "int")
    private int chatID;

    public AudioFile(){

    }

    public AudioFile(int id, boolean isVoiceMessage, int chatID) {
        this.id = id;
        this.isVoiceMessage = isVoiceMessage;
        this.chatID = chatID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVoiceMessage() {
        return isVoiceMessage;
    }

    public void setVoiceMessage(boolean voiceMessage) {
        isVoiceMessage = voiceMessage;
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
        if (!(o instanceof AudioFile)) return false;
        AudioFile audioFile = (AudioFile) o;
        return getId() == audioFile.getId() &&
                isVoiceMessage() == audioFile.isVoiceMessage() &&
                getChatID() == audioFile.getChatID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isVoiceMessage(), getChatID());
    }

    @Override
    public String toString() {
        return "AudioFile{" +
                "id=" + id +
                ", isVoiceMessage=" + isVoiceMessage +
                ", chatID=" + chatID +
                '}';
    }
}
