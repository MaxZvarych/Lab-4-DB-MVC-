package ua.lviv.iot.businesslogic.DAO.implementation;

import ua.lviv.iot.businesslogic.DAO.AudioFileDAO;
import ua.lviv.iot.businesslogic.model.AudioFile;
import ua.lviv.iot.businesslogic.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AudioFileDAOImpl implements AudioFileDAO {

    @Override
    public String getFindAll() {
        return "SELECT * FROM audio_file";
    }

    @Override
    public String getFindOfElement() {
        return "SELECT * FROM audio_file WHERE audio_file.id = ?";
    }

    @Override
    public String getCreate() {
        return "INSERT audio_file(is_voice_message,chat_id) VALUES (?,?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE audio_file SET is_voice_message=?, chat_id=? WHERE id=?";
    }

    @Override
    public String getRemove() {
        return "DELETE FROM audio_file WHERE id=?";
    }

    @Override
    public AudioFile recordEntity(final ResultSet resultSet) throws SQLException {
        return (AudioFile) new Transformer<>(AudioFile.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, AudioFile entity)
            throws SQLException {

        preparedStatement.setByte(1, (byte) (entity.isVoiceMessage()?1:0));
        preparedStatement.setInt(2, entity.getChatID());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, AudioFile entity)
            throws SQLException {
        preparedStatement.setInt(3, entity.getId());
        return preparedStatement;
    }
}
