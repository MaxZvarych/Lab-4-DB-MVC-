package ua.lviv.iot.controller;

import ua.lviv.iot.businesslogic.model.AudioFile;
import ua.lviv.iot.businesslogic.service.implementation.AudioFileServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class AudioFileController {
    public List<AudioFile> getAudioFiles() throws SQLException {
        return new AudioFileServiceImpl().findAll();
    }

    public AudioFile getAudioFile(Integer id) throws SQLException {
        return new AudioFileServiceImpl().findById(id);
    }

    public int setAudioFile(AudioFile audioFile) throws SQLException {
        return new AudioFileServiceImpl().create(audioFile);
    }

    public int putAudioFile(AudioFile audioFile) throws SQLException {
        return new AudioFileServiceImpl().update(audioFile);
    }

    public int removeAudioFile(Integer id) throws SQLException {
        return new AudioFileServiceImpl().delete(id);
    }
}
