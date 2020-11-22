package ua.lviv.iot.businesslogic.DAO.implementation;

import ua.lviv.iot.businesslogic.DAO.DiscordDAO;
import ua.lviv.iot.businesslogic.model.Discord;
import ua.lviv.iot.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscordDAOImpl implements DiscordDAO {

    @Override
    public String getFindAll() {
        return "SELECT * FROM discord";
    }

    @Override
    public String getFindOfElement() {
        return "SELECT * FROM discord WHERE discord.version = ?";
    }

    @Override
    public String getCreate() {
        return "INSERT discord(settings,update_available) VALUES (?,?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE discord SET settings=?,update_available=? WHERE version=?";
    }

    @Override
    public String getRemove() {
        return "DELETE FROM discord WHERE version=?";
    }

    @Override
    public Discord recordEntity(final ResultSet resultSet) throws SQLException {
        return (Discord) new Transformer<>(Discord.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Discord entity)
            throws SQLException {

        preparedStatement.setString(1, entity.getSettings());
        preparedStatement.setBoolean(2, entity.isUpdateAvailable());

        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Discord entity)
            throws SQLException {
        preparedStatement.setInt(3, entity.getVersion());
        return preparedStatement;
    }
}
