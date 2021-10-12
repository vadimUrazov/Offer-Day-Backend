package com.example.offerdaysongs.service;

import com.example.offerdaysongs.dto.requests.CreateCompanyRequest;
import com.example.offerdaysongs.dto.requests.DeleteCompanyRequest;
import com.example.offerdaysongs.dto.requests.UpdateCompanyRequest;
import com.example.offerdaysongs.model.Company;
import com.example.offerdaysongs.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company getById(long id) {
        return companyRepository.getById(id);
    }

    public void deleteAll() {
        companyRepository.deleteAll();
    }

    @Transactional
    public Company update(UpdateCompanyRequest request) {
        var company = companyRepository.getById(request.getCompany().getId());
        company.setName(request.getCompany().getName());
        return companyRepository.save(company);
    }

    @Transactional
    public void delete(DeleteCompanyRequest request) {
        companyRepository.delete(request.getCompany());
    }

    public Company create(CreateCompanyRequest request) {
        Company company = new Company();
        company.setName(request.getName());
        return companyRepository.save(company);
    }
}
