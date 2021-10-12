package com.example.offerdaysongs.controller;

import com.example.offerdaysongs.dto.RecordingDto;
import com.example.offerdaysongs.dto.SingerDto;
import com.example.offerdaysongs.dto.requests.*;
import com.example.offerdaysongs.model.Recording;
import com.example.offerdaysongs.service.RecordingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recordings")
public class RecordingController {
    private static final String ID = "id";
    private final RecordingService recordingService;

    public RecordingController(RecordingService recordingService) {
        this.recordingService = recordingService;
    }

    @GetMapping("/")
    public List<RecordingDto> getAll() {
        return recordingService.getAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id:[\\d]+}")
    public RecordingDto get(@PathVariable(ID) long id) {
        var recording = recordingService.getById(id);
        return convertToDto(recording);
    }

    @PostMapping("/copyright")
    public RecordingDto addCopyright(AddCopyrightRequest request) {
        return convertToDto(recordingService.addCopyright(request));

    }

    @GetMapping("/getPay")
    public Integer getPayByRecording(GetPayByRecordingRequest request) {
        return recordingService.getPayByRecording(request);
    }


    @PostMapping("/create")
    public RecordingDto create(@RequestBody CreateRecordingRequest request) {
        return convertToDto(recordingService.create(request));
    }

    @PostMapping("/update")
    public RecordingDto update(@RequestBody UpdateRecordingRequest request) {
        return convertToDto(recordingService.update(request));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteRecordingRequest request) {
        recordingService.delete(request);
    }


    private RecordingDto convertToDto(Recording recording) {
        var singer = recording.getSinger();
        return new RecordingDto(recording.getId(),
                recording.getTitle(),
                recording.getVersion(),
                recording.getReleaseTime(),
                singer != null ? new SingerDto(singer.getId(), singer.getName()) : null,
                recording.getPrice()
        );


    }
}
