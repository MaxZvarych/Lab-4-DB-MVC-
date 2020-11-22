package ua.lviv.iot.businesslogic.service;

import ua.lviv.iot.businesslogic.DAO.CommonDAO;
import java.sql.SQLException;
import java.util.List;

public interface CommonService<T, ID> {

    CommonDAO<T, ID> giveDAOobject();

    default List<T> findAll() throws SQLException {
        return giveDAOobject().findAll();
    }

    default T findById(ID id) throws SQLException {
        return giveDAOobject().findById(id);
    }

    default int create(T entity) throws SQLException {
        return giveDAOobject().create(entity);
    }

    default int update(T entity) throws SQLException {
        return giveDAOobject().update(entity);
    }

    default int delete(ID id) throws SQLException {
        return giveDAOobject().delete(id);
    }
}