package ua.lviv.iot.businesslogic.DAO.implementation;

import ua.lviv.iot.businesslogic.DAO.MediaFileDAO;
import ua.lviv.iot.businesslogic.model.MediaFile;
import ua.lviv.iot.businesslogic.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MediaFileDAOImpl implements MediaFileDAO {

    @Override
    public String getFindAll() {
        return "SELECT * FROM media_file";
    }

    @Override
    public String getFindOfElement() {
        return "SELECT * FROM media_file WHERE media_file.id = ?";
    }

    @Override
    public String getCreate() {
        return "INSERT media_file(file_type,chat_id) VALUES (?,?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE media_file SET file_type=?, chat_id=? WHERE id=?";
    }

    @Override
    public String getRemove() {
        return "DELETE FROM media_file WHERE id=?";
    }

    @Override
    public MediaFile recordEntity(final ResultSet resultSet) throws SQLException {
        return (MediaFile) new Transformer<>(MediaFile.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, MediaFile entity)
            throws SQLException {

        preparedStatement.setString(1, entity.getFileType());
        preparedStatement.setInt(2, entity.getChatID());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, MediaFile entity)
            throws SQLException {
        preparedStatement.setInt(3, entity.getId());
        return preparedStatement;
    }
}
