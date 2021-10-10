package com.example.offerdaysongs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CopyrightDto {
    long id;

    TimeValidateDto timeValidate;

    CompanyDto company;

    Integer pay;

}
