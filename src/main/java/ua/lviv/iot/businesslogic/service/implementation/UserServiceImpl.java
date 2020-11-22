package ua.lviv.iot.businesslogic.service.implementation;

import ua.lviv.iot.businesslogic.DAO.CommonDAO;
import ua.lviv.iot.businesslogic.DAO.implementation.UserDAOImpl;
import ua.lviv.iot.businesslogic.model.User;
import ua.lviv.iot.businesslogic.service.UserService;

public class UserServiceImpl implements UserService {

    private CommonDAO<User, Integer> entityDAO;

    @Override
    public CommonDAO<User, Integer> giveDAOobject() {
        if (entityDAO == null) {
            entityDAO = new UserDAOImpl();
        }
        return entityDAO;
    }
}
