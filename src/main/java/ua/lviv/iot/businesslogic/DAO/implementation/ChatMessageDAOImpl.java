package ua.lviv.iot.businesslogic.DAO.implementation;

import ua.lviv.iot.businesslogic.DAO.ChatMessageDAO;
import ua.lviv.iot.businesslogic.model.ChatMessage;
import ua.lviv.iot.businesslogic.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChatMessageDAOImpl implements ChatMessageDAO {

    @Override
    public String getFindAll() {
        return "SELECT * FROM chat_has_message";
    }

    @Override
    public String getFindOfElement() {
        return "SELECT * FROM chat_has_message WHERE chat_has_message.message_id = ?";
    }

    @Override
    public String getCreate() {
        return "INSERT chat_has_message(chat_name,chat_style_name,message_id,chat_id) VALUES (?,?,?,?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE chat_has_message SET chat_name=?, chat_style_name=?,message_id=?,chat_id=? WHERE message_id=?";
    }

    @Override
    public String getRemove() {
        return "DELETE FROM chat_has_message WHERE message_id=?";
    }

    @Override
    public ChatMessage recordEntity(final ResultSet resultSet) throws SQLException {
        return (ChatMessage) new Transformer<>(ChatMessage.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, ChatMessage entity)
            throws SQLException {

        preparedStatement.setString(1, entity.getChatName());
        preparedStatement.setString(2, entity.getPk().getChatStyleName());
        preparedStatement.setInt(3, entity.getPk().getMessageID());
        preparedStatement.setInt(4, entity.getPk().getChatID());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, ChatMessage entity)
            throws SQLException {
        preparedStatement.setInt(5, entity.getPk().getMessageID());
        return preparedStatement;
    }
}
