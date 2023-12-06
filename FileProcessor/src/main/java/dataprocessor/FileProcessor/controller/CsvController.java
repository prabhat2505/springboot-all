package dataprocessor.FileProcessor.controller;



import dataprocessor.FileProcessor.config.AppConfig;
import dataprocessor.FileProcessor.utils.FileUtility;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("api/csv")

public class CsvController {
    @Value("${server.port}")
    private String port;
    @Value("${app.name}")
    private String appName;

    @Value("${test-source-file-path}")
    private String testSourceFilePath;

    @Value("${test-destination-file-path}")
    private String testDestinationFilePath;

    private AppConfig appConfig;
    @GetMapping("test")
    public String status() {
        return "Success";

    }
    // Reading application.yaml files
    @GetMapping("getConfig")
    public String testApplicationYml(){

         return "port"+testSourceFilePath;

    }
    @GetMapping("moveFile")
    public String moveFile() throws IOException {
//        String source = appConfig.getTestSourceFilePath();
//        String destination = appConfig.getTestDestinationFilePath();
        FileUtility.moveFile(testSourceFilePath,testDestinationFilePath);
        return "data";
    }
    @GetMapping("createDirectory")
    public void createDirectory() throws IOException {
//        private final String FILE_NAME = "src/test/resources/sourceFiles/test.csv";
//        private final String SHARED_STORAGE = "src/test/resources/sharedStorage/test.csv";
        String sourceDirectoryName = "src/sourceFiles";
        Path dirPath = Paths.get(sourceDirectoryName);
        if (!Files.exists(dirPath)) {
            Files.createDirectory(dirPath);
        }
        String destinationDirectoryName = "src/sharedStorage";
        Path destinationDirectoryPath = Paths.get(destinationDirectoryName);
        if (!Files.exists(destinationDirectoryPath)) {
            Files.createDirectory(destinationDirectoryPath);
        }
    }
}
