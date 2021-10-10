package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.model.Copyright;
import lombok.Data;

@Data
public class AddCopyrightRequest {
    long id;
    Copyright copyright;
}
