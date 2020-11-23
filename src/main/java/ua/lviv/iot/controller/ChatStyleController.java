package ua.lviv.iot.controller;

import ua.lviv.iot.businesslogic.model.ChatStyle;
import ua.lviv.iot.businesslogic.service.implementation.ChatStyleServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ChatStyleController {
    public List<ChatStyle> getChatStyles() throws SQLException {
        return new ChatStyleServiceImpl().findAll();
    }

    public ChatStyle getChatStyle(String name) throws SQLException {
        return new ChatStyleServiceImpl().findById(name);
    }

    public int setChatStyle(ChatStyle chatStyle) throws SQLException {
        return new ChatStyleServiceImpl().create(chatStyle);
    }

    public int putChatStyle(ChatStyle chatStyle) throws SQLException {
        return new ChatStyleServiceImpl().update(chatStyle);
    }

    public int removeChatStyle(String name) throws SQLException {
        return new ChatStyleServiceImpl().delete(name);
    }
}
