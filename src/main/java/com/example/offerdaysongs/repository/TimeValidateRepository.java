package com.example.offerdaysongs.repository;

import com.example.offerdaysongs.model.Company;
import com.example.offerdaysongs.model.TimeValidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TimeValidateRepository extends JpaRepository<TimeValidate, Long>, JpaSpecificationExecutor<TimeValidate> {
}
