package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.model.Recording;
import lombok.Data;

@Data
public class DeleteRecordingRequest {
    private Recording recording;
}
