package dataprocessor.FileProcessor.mockdata;

import com.opencsv.CSVWriter;

import java.io.*;
public class MockCsvGenerator {
    public  static void csvGenerator(String fileName,String[] header ,String[] data) throws IOException {
            File file = new File(fileName);
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);
            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);
            // adding header to csv
            writer.writeNext(header);
            // add data to csv
            writer.writeNext(data);
            writer.close();
    }
}
