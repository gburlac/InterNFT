package testData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSV_generator_for_import {

    public void createCSVforProxy(int rowNum, String participantCode) {
        Get_TestData_from_DB get_testData_from_db = new Get_TestData_from_DB();
        try {
            File csv_with_registration_data = new File("T_REG_REGISTRATION.csv");
            FileWriter fileWriterRegistration = new FileWriter(csv_with_registration_data);
            BufferedWriter writerRegistration = new BufferedWriter(fileWriterRegistration);
            System.out.println("Creating CSV files with test data for import ...");
        } catch (IOException e) {
            e.printStackTrace();


        }

    }
}
