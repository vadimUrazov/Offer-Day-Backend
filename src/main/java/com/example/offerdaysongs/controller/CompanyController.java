package com.example.offerdaysongs.controller;

import com.example.offerdaysongs.dto.CompanyDto;
import com.example.offerdaysongs.dto.requests.CreateCompanyRequest;
import com.example.offerdaysongs.dto.requests.DeleteCompanyRequest;
import com.example.offerdaysongs.dto.requests.UpdateCompanyRequest;
import com.example.offerdaysongs.model.Company;
import com.example.offerdaysongs.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private static final String ID = "id";
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public List<CompanyDto> getAll() {
        return companyService.getAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id:[\\d]+}")
    public CompanyDto get(@PathVariable(ID) long id) {
        var company = companyService.getById(id);
        return convertToDto(company);
    }

    @PostMapping("/create")
    public CompanyDto create(@RequestBody CreateCompanyRequest request) {
        return convertToDto(companyService.create(request));
    }

    @PostMapping("/update")
    public CompanyDto update(@RequestBody UpdateCompanyRequest request) {
        return convertToDto(companyService.update(request));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteCompanyRequest request) {
        companyService.delete(request);
    }


    private CompanyDto convertToDto(Company company) {
        return new CompanyDto(company.getId(), company.getName());
    }

}
