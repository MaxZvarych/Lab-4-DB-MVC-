package ua.lviv.iot.businesslogic.service.implementation;

import ua.lviv.iot.businesslogic.DAO.CommonDAO;
import ua.lviv.iot.businesslogic.DAO.implementation.MessageDAOImpl;
import ua.lviv.iot.businesslogic.model.Message;
import ua.lviv.iot.businesslogic.service.MessageService;

public class MessageServiceImpl implements MessageService {

    private CommonDAO<Message, Integer> entityDAO;

    @Override
    public CommonDAO<Message, Integer> giveDAOobject() {
        if (entityDAO == null) {
            entityDAO = new MessageDAOImpl();
        }
        return entityDAO;
    }
}
