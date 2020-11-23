package ua.lviv.iot.businesslogic.model;
import ua.lviv.iot.businesslogic.model.annotations.*;

import java.util.Objects;

@Table(name = "chat_style")
public class ChatStyle {
    @PrimaryKey
    @Column(name = "name",length = 50)
    private String name;

    public ChatStyle(){}

    public ChatStyle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatStyle)) return false;
        ChatStyle chatStyle = (ChatStyle) o;
        return getName().equals(chatStyle.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "ChatStyle{" +
                "name='" + name + '\'' +
                '}';
    }
}
