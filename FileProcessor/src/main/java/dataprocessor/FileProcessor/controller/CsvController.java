package dataprocessor.FileProcessor.controller;



import dataprocessor.FileProcessor.config.AppConfig;
import dataprocessor.FileProcessor.utils.FileUtility;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
//    @GetMapping("moveFile")
//    public String moveFile(){
////        String source = appConfig.getTestSourceFilePath();
////        String destination = appConfig.getTestDestinationFilePath();
//        FileUtility.moveFile(testSourceFilePath,testDestinationFilePath);
//        return "data";
//    }
}
