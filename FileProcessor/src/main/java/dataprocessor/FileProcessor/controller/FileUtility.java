package dataprocessor.FileProcessor.controller;

import lombok.Getter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtility {
    private Path foundFile;
    @Getter
    String contentType = "application/octet-stream";
    public Resource getFileAsResource(String fileCode) throws IOException {

        Path dirPath = Paths.get("files");


        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
            }
        });
        if(!foundFile.toFile().exists()){
            throw new FileNotFoundException("File Not found");
        }
        return new UrlResource(foundFile.toUri());
    }

    public String getHeaderValue(String filename) {
        return  "attachment; filename=\"" + filename + "\"";
    }
}
