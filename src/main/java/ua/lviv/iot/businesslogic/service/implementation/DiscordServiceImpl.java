package ua.lviv.iot.businesslogic.service.implementation;

import ua.lviv.iot.businesslogic.DAO.CommonDAO;
import ua.lviv.iot.businesslogic.DAO.implementation.DiscordDAOImpl;
import ua.lviv.iot.businesslogic.model.Discord;
import ua.lviv.iot.businesslogic.service.DiscordService;

public class DiscordServiceImpl implements DiscordService {

    private CommonDAO<Discord, Integer> entityDAO;

    @Override
    public CommonDAO<Discord, Integer> giveDAOobject() {
        if (entityDAO == null) {
            entityDAO = new DiscordDAOImpl();
        }
        return entityDAO;
    }
}
