package com.example.offerdaysongs.resources;

import com.example.offerdaysongs.base.AbstractControllerTest;
import com.example.offerdaysongs.dto.requests.CreateCompanyRequest;
import com.example.offerdaysongs.dto.requests.DeleteCompanyRequest;
import com.example.offerdaysongs.model.Company;
import com.example.offerdaysongs.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class OfferDaySongsApplicationTests extends AbstractControllerTest {

    @SpyBean
    CompanyService companyService;


    @Test
    void contextLoads() {

    }


    @Test
    public void testCreateCompany() throws Exception {
        CreateCompanyRequest request = new CreateCompanyRequest();
        request.setName("ISSart");
        this.mockMvc.perform(post("/api/companies/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCompany() throws Exception {
        CreateCompanyRequest request = new CreateCompanyRequest();
        request.setName("ISSart");
        DeleteCompanyRequest deleteCompanyRequest = new DeleteCompanyRequest();

        deleteCompanyRequest.setCompany(new Company("ISSart"));
        this.mockMvc.perform(post("/api/companies/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        this.mockMvc.perform(delete("/api/companies/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(deleteCompanyRequest))
                        .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }


}
