package com.example.offerdaysongs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RecordingDto {
    long id;
    String title;
    String version;
    ZonedDateTime releaseTime;
    SingerDto singer;
    Integer price;
    List<CopyrightDto> copyrights;

    public RecordingDto(long id, String title, String version, ZonedDateTime releaseTime, SingerDto singer, Integer price) {
        this.id = id;
        this.title = title;
        this.version = version;
        this.releaseTime = releaseTime;
        this.singer = singer;
        this.price = price;
        this.copyrights = new ArrayList<>();
    }

}
