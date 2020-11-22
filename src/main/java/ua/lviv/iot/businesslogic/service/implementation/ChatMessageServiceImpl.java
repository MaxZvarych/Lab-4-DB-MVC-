package ua.lviv.iot.businesslogic.service.implementation;

import ua.lviv.iot.businesslogic.DAO.CommonDAO;
import ua.lviv.iot.businesslogic.DAO.implementation.ChatMessageDAOImpl;
import ua.lviv.iot.businesslogic.model.ChatMessage;
import ua.lviv.iot.businesslogic.service.ChatMessageService;

public class ChatMessageServiceImpl implements ChatMessageService {

    private CommonDAO<ChatMessage, Integer> entityDAO;

    @Override
    public CommonDAO<ChatMessage, Integer> giveDAOobject() {
        if (entityDAO == null) {
            entityDAO = new ChatMessageDAOImpl();
        }
        return entityDAO;
    }
}
