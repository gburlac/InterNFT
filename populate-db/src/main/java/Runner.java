import testData.CSV_generator_for_import;
import testData.InsertIntoDboPatient;

public class Runner {

    public static void main(String[] args) {

        int rowNum = 10;


        CSV_generator_for_import csv_generator_for_proxy = new CSV_generator_for_import();
        csv_generator_for_proxy.createCSVforProxy(rowNum);

        InsertIntoDboPatient test_import = new InsertIntoDboPatient();
//        test_import.importCSV();



    }
}
