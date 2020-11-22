package ua.lviv.iot.businesslogic.service.implementation;

import ua.lviv.iot.businesslogic.DAO.CommonDAO;
import ua.lviv.iot.businesslogic.DAO.implementation.MediaFileDAOImpl;
import ua.lviv.iot.businesslogic.model.MediaFile;
import ua.lviv.iot.businesslogic.service.MediaFileService;

public class MediaFileServiceImpl implements MediaFileService {

    private CommonDAO<MediaFile, Integer> entityDAO;

    @Override
    public CommonDAO<MediaFile, Integer> giveDAOobject() {
        if (entityDAO == null) {
            entityDAO = new MediaFileDAOImpl();
        }
        return entityDAO;
    }
}
