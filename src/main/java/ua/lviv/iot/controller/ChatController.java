package ua.lviv.iot.controller;

import ua.lviv.iot.businesslogic.model.Chat;
import ua.lviv.iot.businesslogic.service.implementation.ChatServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ChatController {
    public List<Chat> getChats() throws SQLException {
        return new ChatServiceImpl().findAll();
    }

    public Chat getChat(Integer id) throws SQLException {
        return new ChatServiceImpl().findById(id);
    }

    public int setChat(Chat chat) throws SQLException {
        return new ChatServiceImpl().create(chat);
    }

    public int putChat(Chat chat) throws SQLException {
        return new ChatServiceImpl().update(chat);
    }

    public int removeChat(Integer id) throws SQLException {
        return new ChatServiceImpl().delete(id);
    }
}
