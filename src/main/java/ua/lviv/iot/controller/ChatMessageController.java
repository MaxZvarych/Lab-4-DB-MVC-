package ua.lviv.iot.controller;

import ua.lviv.iot.businesslogic.model.ChatMessage;
import ua.lviv.iot.businesslogic.service.implementation.ChatMessageServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ChatMessageController {
    public List<ChatMessage> getChatMessages() throws SQLException {
        return new ChatMessageServiceImpl().findAll();
    }

    public ChatMessage getChatMessage(Integer id) throws SQLException {
        return new ChatMessageServiceImpl().findById(id);
    }

    public int setChatMessage(ChatMessage chatMessage) throws SQLException {
        return new ChatMessageServiceImpl().create(chatMessage);
    }

    public int putChatMessage(ChatMessage chatMessage) throws SQLException {
        return new ChatMessageServiceImpl().update(chatMessage);
    }

    public int removeChatMessage(Integer id) throws SQLException {
        return new ChatMessageServiceImpl().delete(id);
    }
}
