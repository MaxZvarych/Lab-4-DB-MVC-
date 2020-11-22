package ua.lviv.iot.businesslogic.service.implementation;

import ua.lviv.iot.businesslogic.DAO.CommonDAO;
import ua.lviv.iot.businesslogic.DAO.implementation.UserChatDAOImpl;
import ua.lviv.iot.businesslogic.model.UserChat;
import ua.lviv.iot.businesslogic.service.UserChatService;

public class UserChatServiceImpl implements UserChatService {

    private CommonDAO<UserChat, Integer> entityDAO;

    @Override
    public CommonDAO<UserChat, Integer> giveDAOobject() {
        if (entityDAO == null) {
            entityDAO = new UserChatDAOImpl();
        }
        return entityDAO;
    }
}
