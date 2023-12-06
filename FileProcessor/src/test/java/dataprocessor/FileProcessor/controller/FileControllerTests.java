package dataprocessor.FileProcessor.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FileController.class)
public class FileControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FileService fileService;

    @Test
    public void givenFileName_whenDownLoadFile_thenFileDownLoaded() throws Exception {
//        ResultActions response = mockMvc.perform(get("/api/files/downloadFile22/{fileCode}", "test"));
//        response.andExpect(status().isOk());
//        System.out.println(response);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/api/files/downloadFile22/{fileCode}", "test.csv")
                        .contentType(MediaType.APPLICATION_OCTET_STREAM))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertEquals("application/octet-stream", result.getResponse().getContentType());


    }
    @Test
    public void testHealthCheck(){
        try {
            ResultActions response = mockMvc.perform(get("/api/files/check"));
            response.andExpect(status().isOk());
            System.out.println(response);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
