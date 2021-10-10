package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.model.Copyright;
import com.example.offerdaysongs.model.Singer;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CreateRecordingRequest {
    String title;
    String version;
    ZonedDateTime releaseTime;
    Singer singer;
    Integer price;
    List<Copyright> copyrights = new ArrayList<>();
}
