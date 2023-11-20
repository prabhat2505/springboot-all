package dataprocessor.FileProcessor.utils;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import dataprocessor.FileProcessor.mockdata.MockCsvGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;


@SpringBootTest
public class FileUtilityTests {
    private final String FILE_NAME = "src/test/resources/sourceFiles/test.csv";
    private final String SHARED_STORAGE = "src/test/resources/sharedStorage/test.csv";
    @BeforeEach
    @AfterEach
    public void cleanUpFile() {
        File sourceFile = new File(FILE_NAME);
        sourceFile.delete();
        File sharedStoareg = new File(SHARED_STORAGE);
        sharedStoareg.delete();
    }

    @Test
    public void givenNoSourceFile_whenMoving_thenThrowFileNotFoundException()  {
        //Given No source file
        File sourceFile = new File(FILE_NAME);
        given(sourceFile.exists()).isFalse();

        //When moving throw exception
        assertThrows(FileNotFoundException.class,
                () -> FileUtility.moveFile(FILE_NAME,SHARED_STORAGE));
        File file = new File(SHARED_STORAGE);
        //Assert shared storage contain file
        assertFalse(file.exists());
    }
//
    @Test
    public void givenSourceFile_whenMoved_thenMovedToPath() throws IOException {
        //Creating file created and empty destination
        File sourceFile = new File(FILE_NAME);
        File destinationFile = new File(SHARED_STORAGE);
        boolean isFileExist = sourceFile.createNewFile();

        //Given file
        given(isFileExist).isTrue();

        //When file move called
        FileUtility.moveFile(FILE_NAME,SHARED_STORAGE);

        //Assert destination contain file
        assertTrue(destinationFile.exists());
        destinationFile.delete();
    }
    @Test
    public void givenCsvFile_whenReadingFile_thenContentIsReturned() throws IOException {
        //Mocking csv content
        String[] header = { "Name", "Class", "Marks" };
        String[] data = { "Aman", "10", "620" };
        MockCsvGenerator.csvGenerator(FILE_NAME,header,data);
        //MockCsvGenerator.createCsv(FILE_NAME);
        File csvOutputFile = new File(FILE_NAME);

        //Given csv file with some coulmn and data
        given(csvOutputFile.exists()).isTrue();

        //When Reading csv file
        List<List<String>> record = FileUtility.readFile(FILE_NAME);

        //Asserting content
        List<String> result = record.get(0);
        List<String> expectedResult = List.of("Name", "Class", "Marks");
        assertThat(result).hasSameElementsAs(expectedResult);
        File file = new File(FILE_NAME);
        file.delete();
    }

    @Test
    public void givenFile_whenDeleting_thenFileShouldNotExistInPath() throws IOException {
        //Creating csv content
        File sourceFile = new File(FILE_NAME);
        boolean isFileExist = sourceFile.createNewFile();
        //Given source file
        given(isFileExist).isTrue();
        //When deleting file
        FileUtility.deleteFile(FILE_NAME);
        //Assert file should not exist
        assertFalse(sourceFile.exists());
    }
}
