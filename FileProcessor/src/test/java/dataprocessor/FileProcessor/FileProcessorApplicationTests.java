package dataprocessor.FileProcessor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FileProcessorApplicationTests {
	@Value("${server.port}")
	private String port;
	@Value("${app.name}")
	private String appName;

	@Test
	void contextLoads() {
		System.out.println("jjjjjjjjjjjjjjjjj"+port);
	}

}
