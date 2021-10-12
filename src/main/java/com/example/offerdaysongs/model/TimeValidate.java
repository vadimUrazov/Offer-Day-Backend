package com.example.offerdaysongs.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Data
@Entity
public class TimeValidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    ZonedDateTime startTime;
    ZonedDateTime endTime;

}
