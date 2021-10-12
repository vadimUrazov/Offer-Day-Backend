package com.example.offerdaysongs.integrate;

import com.example.offerdaysongs.OfferDaySongsApplication;
import com.example.offerdaysongs.base.RestTemplateResponseErrorHandler;
import com.example.offerdaysongs.dto.requests.CreateCompanyRequest;
import com.example.offerdaysongs.dto.requests.DeleteCompanyRequest;
import com.example.offerdaysongs.model.Company;
import com.example.offerdaysongs.service.CompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {OfferDaySongsApplication.class})
public class IntegrateTestApplication {

    private MockMvc mockMvc;

    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @SpyBean
    CompanyService companyService;


    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesEmployeeController() {

        ServletContext servletContext = webApplicationContext.getServletContext();

        assertNotNull(servletContext);
        assertNotNull(webApplicationContext.getBean("companyController"));
    }

    @BeforeEach
    public void beforeTest() {
        restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
    }

    @Test
    public void testCreateCompany() throws Exception {
        String resourceUrl = "http://localhost:8080/api/companies/create";
        CreateCompanyRequest request = new CreateCompanyRequest();
        request.setName("Lux");

        this.mockMvc.perform(post(resourceUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    public void testDeleteCompany() throws Exception {
        String resourceUrlCreate = "http://localhost:8080/api/companies/create";
        String resourceUrlDelete = "http://localhost:8080/api/companies/delete";
        CreateCompanyRequest request = new CreateCompanyRequest();
        request.setName("Lux");
        DeleteCompanyRequest deleteCompanyRequest = new DeleteCompanyRequest();

        deleteCompanyRequest.setCompany(new Company("Lux"));

        this.mockMvc.perform(post(resourceUrlCreate)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON)).andExpect(status().isOk());


        this.mockMvc.perform(delete(resourceUrlDelete)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(deleteCompanyRequest))
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
}
