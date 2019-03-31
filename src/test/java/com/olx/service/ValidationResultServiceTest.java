package com.olx.service;

import com.olx.OlxApplication;
import com.olx.model.ProcessedFile;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ValidationResultServiceTest {

    @Autowired
    ProcessedFileService processedFileService;

    private static Long fileId;

    @Test
    public void test1_save() {
        ProcessedFile processedFile = processedFileService.save("FILE_NAME");
        fileId = processedFile.getFileId();
        assertNotNull(processedFile.getFileId());
    }

    @Test
    public void test2_findByFileId() {
        ProcessedFile processedFile = processedFileService.findByFileId(fileId);
        assertNotNull(processedFile.getFileId());
    }

    @Test
    public void test3_getLatest() {
        ProcessedFile processedFile = processedFileService.getLatest();
        assertEquals(new Long(fileId), processedFile.getFileId());
    }

    @Test
    public void test4_findByFileId_notFound() {
        ProcessedFile processedFile = processedFileService.findByFileId(100L);
        assertNull(processedFile);
    }

}
