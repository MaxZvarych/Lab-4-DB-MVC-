package ua.lviv.iot.businesslogic.service.implementation;

import ua.lviv.iot.businesslogic.DAO.CommonDAO;
import ua.lviv.iot.businesslogic.DAO.implementation.AudioFileDAOImpl;
import ua.lviv.iot.businesslogic.model.AudioFile;
import ua.lviv.iot.businesslogic.service.AudioFileService;

public class AudioFileServiceImpl implements AudioFileService {

    private CommonDAO<AudioFile, Integer> entityDAO;

    @Override
    public CommonDAO<AudioFile, Integer> giveDAOobject() {
        if (entityDAO == null) {
            entityDAO = new AudioFileDAOImpl();
        }
        return entityDAO;
    }
}
