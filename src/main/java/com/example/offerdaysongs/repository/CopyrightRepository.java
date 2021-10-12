package com.example.offerdaysongs.repository;

import com.example.offerdaysongs.model.Copyright;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CopyrightRepository extends JpaRepository<Copyright, Long>, JpaSpecificationExecutor<Copyright> {
}
