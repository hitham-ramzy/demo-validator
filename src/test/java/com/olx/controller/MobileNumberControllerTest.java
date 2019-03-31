package com.olx.controller;

import com.olx.OlxApplication;
import com.olx.model.MobileNumber;
import com.olx.util.TestUtils;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = OlxApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MobileNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    private RestTemplate restTemplate = new RestTemplate();

    private static MockMultipartFile multipartFile = null;

    @BeforeClass
    public static void beforeClass() throws IOException {
        multipartFile = TestUtils.loadCSVFile();
    }

    @Test
    public void test1_uploadCSV() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/validate/file")
                .file("file", multipartFile.getBytes())
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk());
    }

    @Test
    public void test2_getAllNumbers() {
        ResponseEntity<List<MobileNumber>> response = restTemplate.exchange(
                createURLWithPort("/api/mobile-number/all"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MobileNumber>>() {
                });
        List<MobileNumber> mobileNumbers = response.getBody();
        assertNotNull(mobileNumbers);
        assertEquals(19, mobileNumbers.size());
    }

    @Test
    public void test3_getValidNumbers() {
        ResponseEntity<List<MobileNumber>> response = restTemplate.exchange(
                createURLWithPort("/api/mobile-number/valid"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MobileNumber>>() {
                });
        List<MobileNumber> mobileNumbers = response.getBody();
        assertNotNull(mobileNumbers);
        assertEquals(4, mobileNumbers.size());
    }

    @Test
    public void test4_getFixedNumbers() {
        ResponseEntity<List<MobileNumber>> response = restTemplate.exchange(
                createURLWithPort("/api/mobile-number/fixed"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MobileNumber>>() {
                });
        List<MobileNumber> mobileNumbers = response.getBody();
        assertNotNull(mobileNumbers);
        assertEquals(9, mobileNumbers.size());
    }

    @Test
    public void test5_getInvalidNumbers() {
        ResponseEntity<List<MobileNumber>> response = restTemplate.exchange(
                createURLWithPort("/api/mobile-number/invalid"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MobileNumber>>() {
                });
        List<MobileNumber> mobileNumbers = response.getBody();
        assertNotNull(mobileNumbers);
        assertEquals(6, mobileNumbers.size());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
