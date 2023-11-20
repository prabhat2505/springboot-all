package dataprocessor.FileProcessor.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AppConfig {
    @Value("${test-source-file-path}")
    private String testSourceFilePath;

    @Value("${test-destination-file-path}")
    private String testDestinationFilePath;
}
