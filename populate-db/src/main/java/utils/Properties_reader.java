package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Properties_reader {
    private String dbUserName;
    private String dbPassword;
    private String dbURL;
    private String dbName;
    private String host;
    private String sshUsername;
    private String sshPassword;
    private String privateKey;
    private String sshPort;
    private String jumpHost;
    private String jumpHostPort;

    private static Properties_reader propertiesReader;

    private Properties_reader() {

    }

    private void iniDataBasePropValues() {
        InputStream inputStream = null;
        Properties prop = new Properties();
        System.out.println("Working Directory = "+
                System.getProperty("user.dir"));

        String propFileName = "src/main/resources/nft_sql_db.properies";
        try{
            inputStream = new FileInputStream(propFileName);

        dbUserName=prop.getProperty("DB_USERNAME");
        dbPassword=prop.getProperty("DB_PASSWORD");
        dbURL=prop.getProperty("DB_URL");
        dbName=prop.getProperty("DB_NAME");
        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }finally {
            try{
                inputStream.close();
            } catch (IOException e) {
                System.out.println("Exeption: " +e);
                e.printStackTrace();
            }
        }
    }

    private  void initSshPropValues(){
        InputStream inputStream = null;

        Properties prop = new Properties();
        String propFileName ="";

        try {
            inputStream = new FileInputStream(propFileName);
            prop.load(inputStream);

            host = prop.getProperty("HOST");
            sshUsername = prop.getProperty("SSH_USER_NAME");
            sshPassword = prop.getProperty("SSH_PASSWORD");
            privateKey = prop.getProperty("PRIVATE_KEY");
            sshPort = prop.getProperty("SSH_PORT");
            jumpHost = prop.getProperty("JUMP_HOST");
            jumpHostPort = prop.getProperty("JUMP_HOST_PORT");

        } catch (FileNotFoundException e) {
            System.out.println("property file '" + propFileName + "' not found in the classpath. See details in log file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }

    }
    private InputStream readPropertyFile(String filePath) throws IOException {
        return new FileInputStream(filePath);
    }

    public static Properties_reader getInstance() {
        if (propertiesReader == null) {
            propertiesReader = new Properties_reader();
        }
        return propertiesReader;
    }

    public String getHost() {
        return host;
    }

    public String getSshUsername() {
        return sshUsername;
    }

    public String getSshPassword() {
        return sshPassword;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public int getSshPort() {
        return Integer.parseInt(sshPort);
    }

    public String getJumpHost() {
        return jumpHost;
    }

    public int getJumpHostPort(){
        return Integer.parseInt(jumpHostPort);
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbUrl() {
        return dbURL;
    }

    public String getDbName() {
        return dbName;
    }
}
