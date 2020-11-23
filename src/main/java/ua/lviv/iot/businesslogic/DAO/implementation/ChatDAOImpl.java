package ua.lviv.iot.businesslogic.DAO.implementation;

import ua.lviv.iot.businesslogic.DAO.ChatDAO;
import ua.lviv.iot.businesslogic.model.Chat;
import ua.lviv.iot.businesslogic.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChatDAOImpl implements ChatDAO {

    @Override
    public String getFindAll() {
        return "SELECT * FROM chat";
    }

    @Override
    public String getFindOfElement() {
        return "SELECT * FROM chat WHERE chat.id = ?";
    }

    @Override
    public String getCreate() {
        return "INSERT chat(name,region,Discord_version,chat_style_name) VALUES (?,?,?,?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE chat SET name=?, region=?,Discord_version=?,chat_style_name=? WHERE id=?";
    }

    @Override
    public String getRemove() {
        return "DELETE FROM chat WHERE id=?";
    }

    @Override
    public Chat recordEntity(final ResultSet resultSet) throws SQLException {
        return (Chat) new Transformer<>(Chat.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Chat entity)
            throws SQLException {

        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getRegion());
        preparedStatement.setInt(3, entity.getDiscordVersion());
        preparedStatement.setString(4, entity.getPk().getChatStyleName());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Chat entity)
            throws SQLException {
        preparedStatement.setInt(5, entity.getPk().getId());

        return preparedStatement;
    }
}