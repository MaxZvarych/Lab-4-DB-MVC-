package ua.lviv.iot.businesslogic.service.implementation;

import ua.lviv.iot.businesslogic.DAO.CommonDAO;
import ua.lviv.iot.businesslogic.DAO.implementation.ChatDAOImpl;
import ua.lviv.iot.businesslogic.model.Chat;
import ua.lviv.iot.businesslogic.service.ChatService;

public class ChatServiceImpl implements ChatService {

    private CommonDAO<Chat, Integer> entityDAO;

    @Override
    public CommonDAO<Chat, Integer> giveDAOobject() {
        if (entityDAO == null) {
            entityDAO = new ChatDAOImpl();
        }
        return entityDAO;
    }
}
