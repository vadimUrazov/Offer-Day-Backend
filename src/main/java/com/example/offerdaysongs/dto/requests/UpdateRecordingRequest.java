package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.model.Recording;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UpdateRecordingRequest {
private Recording record;
}
