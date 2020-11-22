package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.*;
import ua.lviv.iot.businesslogic.model.PK_Message;

import java.util.Objects;


@Table(name="message")
public class Message {
    @PrimaryKeyComposite
    private PK_Message pk;

    public Message(){
    }

    public Message(PK_Message pk) {
        this.pk = pk;
    }

    public PK_Message getPk() {
        return pk;
    }

    public void setPk(PK_Message pk) {
        this.pk = pk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getPk().equals(message.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk());
    }

    @Override
    public String toString() {
        return "Message{" +
                 pk +
                '}';
    }
}
