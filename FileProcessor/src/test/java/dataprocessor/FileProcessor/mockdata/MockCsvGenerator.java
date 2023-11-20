package dataprocessor.FileProcessor.mockdata;

import com.opencsv.CSVWriter;

import java.io.*;
public class MockCsvGenerator {
    public static final String FILE_NAME = "src/test/resources/sourceFiles/test.csv";
    public  static void csvGenerator(String fileName,String[] header ,String[] data) throws IOException {
            File file = new File(fileName);
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);
            // adding header to csv
            String[] headerData = header;
            writer.writeNext(headerData);
            // add data to csv
            String[] data1 = data;
            writer.writeNext(data1);
            writer.close();
    }
}
