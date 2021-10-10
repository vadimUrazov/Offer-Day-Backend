package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.model.Company;
import lombok.Data;

@Data
public class DeleteCompanyRequest {
    private Company company;

    public DeleteCompanyRequest() {
    }

    public DeleteCompanyRequest(Company company) {
        this.company = company;
    }
}
