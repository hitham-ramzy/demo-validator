package com.olx.service;

import com.olx.OlxApplication;
import com.olx.model.ProcessedFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = OlxApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class ValidationResultServiceTest {

    @Autowired
    ProcessedFileService processedFileService;

    @Test
    public void a_save() {
        ProcessedFile processedFile = processedFileService.save("FILE_NAME");
        assertNotNull(processedFile.getFileId());
    }

    @Test
    public void b_findByFileId() {
        ProcessedFile processedFile = processedFileService.findByFileId(1L);
        assertNotNull(processedFile.getFileId());
    }

    @Test
    public void c_getLatest() {
        ProcessedFile processedFile = processedFileService.getLatest();
        assertEquals(new Long(1), processedFile.getFileId());
    }

    @Test
    public void d_findByFileId_notFound() {
        ProcessedFile processedFile = processedFileService.findByFileId(100L);
        assertNull(processedFile.getFileId());
    }

}
