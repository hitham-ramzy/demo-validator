package com.olx.service;

import com.olx.OlxApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = OlxApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class ValidationResultServiceTest {

//    @Autowired
//    ValidationResultService validationResultService;

//    @Test
//    public void save() {
//        ValidationResultDTO validationResultDTO = new ValidationResultDTO(ValidationStatus.VALID);
//        validationResultDTO.setSourceId(123456L);
//        validationResultDTO.setMobileNumber("2732567432");
//        assertNotNull(validationResultService.save(validationResultDTO).getId());
//    }
//
//    @Test(expected = DataIntegrityViolationException.class)
//    public void saveWithValidationError() {
//        ValidationResultDTO validationResultDTO = new ValidationResultDTO();
//        validationResultDTO.setStatus(ValidationStatus.VALID);
//        assertNotNull(validationResultService.save(validationResultDTO).getId());
//    }
//
//    @Test
//    public void delete() {
//        ValidationResultDTO validationResultDTO = new ValidationResultDTO(ValidationStatus.VALID);
//        validationResultDTO.setSourceId(123456L);
//        validationResultDTO.setMobileNumber("2732567432");
//        ValidationResultDTO savedValidationResultDTO = validationResultService.save(validationResultDTO);
//        validationResultService.delete(savedValidationResultDTO.getId());
//    }
//
//    @Test(expected = JpaObjectRetrievalFailureException.class)
//    public void deleteNotFoundResult() {
//        validationResultService.delete(123L);
//    }
//
//    @Test
//    public void findAll() {
//        ValidationResultDTO validationResultDTO = new ValidationResultDTO(ValidationStatus.VALID);
//        validationResultDTO.setSourceId(123456L);
//        validationResultDTO.setMobileNumber("2732567432");
//        validationResultService.save(validationResultDTO);
//        assertEquals(validationResultService.findAll().size(), 1);
//    }

}
