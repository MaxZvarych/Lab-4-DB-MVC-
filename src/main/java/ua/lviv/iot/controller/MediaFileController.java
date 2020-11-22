package ua.lviv.iot.controller;

import ua.lviv.iot.businesslogic.model.MediaFile;
import ua.lviv.iot.businesslogic.service.implementation.MediaFileServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class MediaFileController {
    public List<MediaFile> getMediaFiles() throws SQLException {
        return new MediaFileServiceImpl().findAll();
    }

    public MediaFile getMediaFile(Integer id) throws SQLException {
        return new MediaFileServiceImpl().findById(id);
    }

    public int setMediaFile(MediaFile mediaFile) throws SQLException {
        return new MediaFileServiceImpl().create(mediaFile);
    }

    public int putMediaFile(MediaFile mediaFile) throws SQLException {
        return new MediaFileServiceImpl().update(mediaFile);
    }

    public int removeMediaFile(Integer id) throws SQLException {
        return new MediaFileServiceImpl().delete(id);
    }
}
