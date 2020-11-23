package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.Column;

import java.util.Objects;

public class PK_Message {
    @Column(name="id",type = "int")
    private int id;

    @Column(name="addressee",length = 50)
    private String addressee;

    public PK_Message(){}

    public PK_Message(int id, String addressee) {
        this.id = id;
        this.addressee = addressee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PK_Message)) return false;
        PK_Message that = (PK_Message) o;
        return getId() == that.getId() &&
                getAddressee().equals(that.getAddressee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddressee());
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", addressee='" + addressee ;
    }
}
