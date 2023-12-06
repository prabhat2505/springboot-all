package dataprocessor.FileProcessor.utils;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileUtility {

    public static void moveFile(String source,String destination) throws IOException {

            File from = new File(source);
            File to = new File(destination);
            Files.move(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully.");
    }

    public static List<List<String>> readFile(String filePath) throws IOException {
        List<List<String>> records = new ArrayList<List<String>>();
        CSVReader csvReader = new CSVReader(new FileReader(filePath));
        String[] values = null;
        while ((values = csvReader.readNext()) != null) {
            records.add(Arrays.asList(values));
            break;
        }
        csvReader.close();
        return records;
    }
    public  static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }
}
