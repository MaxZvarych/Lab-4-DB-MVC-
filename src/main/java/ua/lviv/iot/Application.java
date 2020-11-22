package ua.lviv.iot;

import ua.lviv.iot.view.View;

import java.io.IOException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws IOException, SQLException {
        new View().show();
    }
}
