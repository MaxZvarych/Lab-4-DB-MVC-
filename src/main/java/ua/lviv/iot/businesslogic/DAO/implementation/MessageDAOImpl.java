package ua.lviv.iot.businesslogic.DAO.implementation;

import ua.lviv.iot.businesslogic.DAO.MessageDAO;
import ua.lviv.iot.businesslogic.model.Message;
import ua.lviv.iot.businesslogic.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MessageDAOImpl implements MessageDAO {

    @Override
    public String getFindAll() {
        return "SELECT * FROM message";
    }

    @Override
    public String getFindOfElement() {
        return "SELECT * FROM message WHERE message.id = ?";
    }

    @Override
    public String getCreate() {
        return "INSERT message(addressee) VALUES (?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE message SET addressee=? WHERE id=?";
    }

    @Override
    public String getRemove() {
        return "DELETE FROM message WHERE id=?";
    }

    @Override
    public Message recordEntity(final ResultSet resultSet) throws SQLException {
        return (Message) new Transformer<>(Message.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Message entity)
            throws SQLException {

        preparedStatement.setString(1, entity.getPk().getAddressee());
        return preparedStatement;
    }
    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Message entity)
            throws SQLException {
        preparedStatement.setInt(3, entity.getPk().getId());

        return preparedStatement;
    }
}