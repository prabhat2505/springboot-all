package dataprocessor.FileProcessor.controller;

import dataprocessor.FileProcessor.exception.FileNotFoundException;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    private Path foundFile;
    public FileService() {
    }
    public Resource getFileAsResource(String fileCode) throws IOException {
        Path dirPath = Paths.get("files");

        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
    public Resource loadFileAsResource(String fileName) {
        Path fileStorageLocation =  Paths.get("src/test/resources/sourceFiles")
                .toAbsolutePath().normalize();
        System.out.println("File Not found");
        try {
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName);
        }
    }
}
