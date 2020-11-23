package ua.lviv.iot.businesslogic.DAO.implementation;

import ua.lviv.iot.businesslogic.DAO.ChatStyleDAO;
import ua.lviv.iot.businesslogic.model.ChatStyle;
import ua.lviv.iot.businesslogic.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChatStyleDAOImpl implements ChatStyleDAO {

    @Override
    public String getFindAll() {
        return "SELECT * FROM chat_style";
    }

    @Override
    public String getFindOfElement() {
        return "SELECT * FROM chat_style WHERE chat_style.name = ?";
    }

    @Override
    public String getCreate() {
        return "INSERT chat_style(name) VALUES (?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE chat_style SET name=? WHERE name=?";
    }

    @Override
    public String getRemove() {
        return "DELETE FROM chat_style WHERE name=?";
    }

    @Override
    public ChatStyle recordEntity(final ResultSet resultSet) throws SQLException {
        return (ChatStyle) new Transformer<>(ChatStyle.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, ChatStyle entity)
            throws SQLException {

        preparedStatement.setString(1, entity.getName());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, ChatStyle entity)
            throws SQLException {
        preparedStatement.setString(2, entity.getName());
        return preparedStatement;
    }
}
