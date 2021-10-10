package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.model.Company;
import lombok.Data;

@Data
public class UpdateCompanyRequest {
    private Company company;
}
