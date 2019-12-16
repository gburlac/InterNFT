package conections;

import utils.Properties_reader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_conection {
    private Connection conn;
    private Properties_reader properties_reader = Properties_reader.getInstance();
    private static final org.apache.log4j.Logger Logger = org.apache.log4j.Logger.getLogger(DB_conection.class);

    public DB_conection() {
        driverInitializing();
    }

    private void driverInitializing() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println("SQLServerDriver not init");
            Logger.error("Exeption on SQLServerDriver initialization.", e);
        }
    }

    public Connection activeConnection() {
        try {
            conn = DriverManager.getConnection(properties_reader.getDbUrl(), properties_reader.getDbUserName(), properties_reader.getDbPassword());
            System.out.println("DB is connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void dbClose() {
        try {
            conn.close();
            System.out.println("DB connection closed... \n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
