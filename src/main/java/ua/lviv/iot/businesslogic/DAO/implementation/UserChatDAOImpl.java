package ua.lviv.iot.businesslogic.DAO.implementation;

import ua.lviv.iot.businesslogic.DAO.UserChatDAO;
import ua.lviv.iot.businesslogic.model.UserChat;
import ua.lviv.iot.businesslogic.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserChatDAOImpl implements UserChatDAO {

    @Override
    public String getFindAll() {
        return "SELECT * FROM user_has_chat";
    }

    @Override
    public String getFindOfElement() {
        return "SELECT * FROM user_has_chat WHERE user_has_chat.user_id = ?";
    }

    @Override
    public String getCreate() {
        return "INSERT user_has_chat(chat_id,chat_style_name,user_nickname,user_id,chat_name) VALUES (?,?,?,?,?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE user_has_chat SET  chat_id=?,chat_style_name=?,user_nickname=?,user_id=?,chat_name=? WHERE user_id=?";
    }

    @Override
    public String getRemove() {
        return "DELETE FROM user_has_chat WHERE user_id=?";
    }

    @Override
    public UserChat recordEntity(final ResultSet resultSet) throws SQLException {
        return (UserChat) new Transformer<>(UserChat.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, UserChat entity)
            throws SQLException {

        preparedStatement.setInt(1, entity.getPk().getChatID());
        preparedStatement.setString(2, entity.getPk().getChatStyleName());
        preparedStatement.setString(3, entity.getPk().getUserNickName());
        preparedStatement.setInt(4, entity.getPk().getUserID());
        preparedStatement.setString(5, entity.getChatName());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, UserChat entity)
            throws SQLException {
        preparedStatement.setInt(6, entity.getPk().getUserID());
        return preparedStatement;
    }
}
