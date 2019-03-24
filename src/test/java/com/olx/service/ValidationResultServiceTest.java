package com.olx.service;

import com.olx.OlxApplication;
import com.olx.model.ValidationResult;
import com.olx.model.ValidationStatus;
import com.olx.services.ValidationResultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = OlxApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class ValidationResultServiceTest {

    @Autowired
    ValidationResultService validationResultService;

    @Test
    public void save() {
        ValidationResult validationResult = new ValidationResult(ValidationStatus.VALID);
        validationResult.setSourceId(123456L);
        validationResult.setMobileNumber("2732567432");
        assertNotNull(validationResultService.save(validationResult).getId());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void saveWithValidationError() {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setStatus(ValidationStatus.VALID);
        assertNotNull(validationResultService.save(validationResult).getId());
    }

    @Test
    public void delete() {
        ValidationResult validationResult = new ValidationResult(ValidationStatus.VALID);
        validationResult.setSourceId(123456L);
        validationResult.setMobileNumber("2732567432");
        ValidationResult savedValidationResult = validationResultService.save(validationResult);
        validationResultService.delete(savedValidationResult.getId());
    }

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public void deleteNotFoundResult() {
        validationResultService.delete(123L);
    }

    @Test
    public void findAll() {
        ValidationResult validationResult = new ValidationResult(ValidationStatus.VALID);
        validationResult.setSourceId(123456L);
        validationResult.setMobileNumber("2732567432");
        validationResultService.save(validationResult);
        assertEquals(validationResultService.findAll().size(), 1);
    }

}
