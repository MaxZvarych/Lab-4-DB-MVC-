package ua.lviv.iot.businesslogic.service.implementation;

import ua.lviv.iot.businesslogic.DAO.CommonDAO;
import ua.lviv.iot.businesslogic.DAO.implementation.ChatStyleDAOImpl;
import ua.lviv.iot.businesslogic.model.ChatStyle;
import ua.lviv.iot.businesslogic.service.ChatStyleService;

public class ChatStyleServiceImpl implements ChatStyleService {

    private CommonDAO<ChatStyle, String> entityDAO;

    @Override
    public CommonDAO<ChatStyle, String> giveDAOobject() {
        if (entityDAO == null) {
            entityDAO = new ChatStyleDAOImpl();
        }
        return entityDAO;
    }
}
