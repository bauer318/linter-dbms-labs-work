package ru.rsreu.kibamba.linter;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        try {
            Driver d = (Driver) Class.forName("com.relx.jdbc.LinterDriver").newInstance();
        } catch (Exception e) {
            //return Collections.emptyMap();
        }

        String url = "jdbc:linter:linapid:localhost:1070:DEMO;autoCommit=true"; //  'local' - для доступа к серверу по-умолчанию

        String user = "SYSTEM";
        String password = "MANAGER";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Map<String, String> properties = new LinkedHashMap<>();

            DatabaseMetaData metaData = connection.getMetaData();
            properties.put("URL", metaData.getURL());
            properties.put("Driver name", metaData.getDriverName());
            properties.put("Driver version", metaData.getDriverVersion());

            //return properties;
        } catch (Exception e) {
            //return Collections.emptyMap();
        }
    }

}
