package testData;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import conections.DB_conection;
import utils.dboPatient;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertIntoDboPatient {

    String query = "INSERT INTO GBurlacDBS.dbo.PATIENT (ID_PATIENT, FIRST_NAME, LAST_NAME, AGE, GENDER, PHONE_NUMBER" + "VALUES (?, ?, ?, ?, ?, ?)";

    DB_conection db_conection = new DB_conection();
    Connection conn = db_conection.activeConnection();

    ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();

    strat.setType(dboPatient.class);
    String[] columns = new String[]{"ID_PATIENT", "FIRST_NAME", "LAST_NAME", "AGE", "GENDER, PHONE_NUMBER"};
    strat.setColumnMapping(columns);

    CsvToBean csv = new CsvToBean();
    String csvFilename = "dboPATIENT.CSV";


        PreparedStatement statement = conn.prepareStatement(query);
        final int batchSize = 1000;
        int count = 0;


        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        List list = csv.parse(strat, csvReader);
        for (Object object : list) {
            dboPatient dboPatient = (utils.dboPatient) object;
            statement.setString(1, dboPatient.getID_PATIENT());
            statement.setString(2, dboPatient.getFIRST_NAME());
            statement.setString(3, dboPatient.getLAST_NAME());
            statement.setString(4, dboPatient.getAGE());
            statement.setString(5, dboPatient.getGENDER());
            statement.setString(6, dboPatient.getPHONE_NUMBER());
            statement.addBatch();

            if (++count % batchSize == 0) {
                statement.executeBatch();
            }
        }


        statement.executeBatch();
        System.out.println("Test data was imported to Patient ...");
        statement.close();
        conn.close();


}


