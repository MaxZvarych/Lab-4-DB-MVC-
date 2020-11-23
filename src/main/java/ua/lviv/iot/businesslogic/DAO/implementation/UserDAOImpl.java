package ua.lviv.iot.businesslogic.DAO.implementation;

import ua.lviv.iot.businesslogic.DAO.UserDAO;
import ua.lviv.iot.businesslogic.model.User;
import ua.lviv.iot.businesslogic.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO {

    @Override
    public String getFindAll() {
        return "SELECT * FROM user";
    }

    @Override
    public String getFindOfElement() {
        return "SELECT * FROM user WHERE user.id = ?";
    }

    @Override
    public String getCreate() {
        return "INSERT user(Discord_version,nickname) VALUES (?,?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE user SET Discord_version=?,nickname=? WHERE id=?";
    }

    @Override
    public String getRemove() {
        return "DELETE FROM user WHERE id=?";
    }

    @Override
    public User recordEntity(final ResultSet resultSet) throws SQLException {
        return (User) new Transformer<>(User.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, User entity)
            throws SQLException {

        preparedStatement.setInt(1, entity.getDiscordVersion());
        preparedStatement.setString(2, entity.getPk().getNickname());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, User entity)
            throws SQLException {
        preparedStatement.setInt(3, entity.getPk().getId());

        return preparedStatement;
    }
}