package com.example.offerdaysongs.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TimeValidateDto {
    long id;
    ZonedDateTime startTime;
    ZonedDateTime endTime;

}
