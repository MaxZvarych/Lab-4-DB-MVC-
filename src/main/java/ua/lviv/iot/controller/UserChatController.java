package ua.lviv.iot.controller;

import ua.lviv.iot.businesslogic.model.UserChat;
import ua.lviv.iot.businesslogic.service.implementation.UserChatServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class UserChatController {
    public List<UserChat> getUserChats() throws SQLException {
        return new UserChatServiceImpl().findAll();
    }

    public UserChat getUserChat(Integer id) throws SQLException {
        return new UserChatServiceImpl().findById(id);
    }

    public int setUserChat(UserChat userChat) throws SQLException {
        return new UserChatServiceImpl().create(userChat);
    }

    public int putUserChat(UserChat userChat) throws SQLException {
        return new UserChatServiceImpl().update(userChat);
    }

    public int removeUserChat(Integer id) throws SQLException {
        return new UserChatServiceImpl().delete(id);
    }
}