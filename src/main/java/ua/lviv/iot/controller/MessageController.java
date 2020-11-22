package ua.lviv.iot.controller;

import ua.lviv.iot.businesslogic.model.Message;
import ua.lviv.iot.businesslogic.service.implementation.MessageServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class MessageController {
    public List<Message> getMessages() throws SQLException {
        return new MessageServiceImpl().findAll();
    }

    public Message getMessage(Integer id) throws SQLException {
        return new MessageServiceImpl().findById(id);
    }

    public int setMessage(Message message) throws SQLException {
        return new MessageServiceImpl().create(message);
    }

    public int putMessage(Message message) throws SQLException {
        return new MessageServiceImpl().update(message);
    }

    public int removeMessage(Integer id) throws SQLException {
        return new MessageServiceImpl().delete(id);
    }
}
