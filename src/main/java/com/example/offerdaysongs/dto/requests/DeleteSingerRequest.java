package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.model.Singer;
import lombok.Data;

@Data
public class DeleteSingerRequest {
    private Singer singer;
}
