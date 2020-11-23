package ua.lviv.iot.controller;

import ua.lviv.iot.businesslogic.model.Discord;
import ua.lviv.iot.businesslogic.service.implementation.DiscordServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class DiscordController {
    public List<Discord> getDiscords() throws SQLException {
        return new DiscordServiceImpl().findAll();
    }

    public Discord getDiscord(Integer id) throws SQLException {
        return new DiscordServiceImpl().findById(id);
    }

    public int setDiscord(Discord discord) throws SQLException {
        return new DiscordServiceImpl().create(discord);
    }

    public int putDiscord(Discord discord) throws SQLException {
        return new DiscordServiceImpl().update(discord);
    }

    public int removeDiscord(Integer id) throws SQLException {
        return new DiscordServiceImpl().delete(id);
    }
}
