package com.olx.controller;

import com.olx.OlxApplication;
import com.olx.util.TestUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = OlxApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class ValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static MockMultipartFile multipartFile = null;

    @BeforeClass
    public static void beforeClass() throws IOException {
        multipartFile = TestUtils.loadCSVFile();
    }

    @Test
    public void validateFile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/validate/file")
                .file("file", multipartFile.getBytes())
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk());
    }

    @Test
    public void validateNumber() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/validate/number")
                .param("number", "27717278645"))
                .andExpect(status().isOk());
    }
}
