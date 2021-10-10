package com.example.offerdaysongs.service;

import com.example.offerdaysongs.dto.requests.*;
import com.example.offerdaysongs.model.Recording;
import com.example.offerdaysongs.model.Singer;
import com.example.offerdaysongs.repository.CopyrightRepository;
import com.example.offerdaysongs.repository.RecordingRepository;
import com.example.offerdaysongs.repository.SingerRepository;
import com.example.offerdaysongs.repository.TimeValidateRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecordingService {
    private final RecordingRepository recordingRepository;
    private final SingerRepository singerRepository;
    private final CopyrightRepository copyrightRepository;
    private final TimeValidateRepository timeValidateRepository;

    public RecordingService(RecordingRepository recordingRepository,
                            SingerRepository singerRepository,
                            CopyrightRepository copyrightRepository, TimeValidateRepository timeValidateRepository) {
        this.recordingRepository = recordingRepository;
        this.singerRepository = singerRepository;
        this.copyrightRepository = copyrightRepository;
        this.timeValidateRepository = timeValidateRepository;
    }

    public void deleteAll() {
        recordingRepository.deleteAll();
    }

    public List<Recording> getAll() {
        return recordingRepository.findAll();
    }

    public Recording getById(long id) {
        return recordingRepository.getById(id);
    }

    @Transactional
    public Recording update(UpdateRecordingRequest request) {
        var recording = recordingRepository.getById(request.getRecord().getId());
        if (recording != null) {
            recording.setSinger(recording.getSinger());
            recording.setReleaseTime(recording.getReleaseTime());
            recording.setTitle(recording.getTitle());
            recording.setVersion(recording.getVersion());
            recording.setPrice(recording.getPrice());
        }
        return recordingRepository.save(recording);
    }

    @Transactional
    public Recording addCopyright(AddCopyrightRequest request) {
        var recording = recordingRepository.getById(request.getId());
        recording.getCopyrights().add(request.getCopyright());
        copyrightRepository.save(request.getCopyright());
        timeValidateRepository.save(request.getCopyright().getTimeValidate());
        return recordingRepository.save(recording);
    }


    @Transactional
    public void delete(DeleteRecordingRequest request) {
        var recording = request.getRecording();
        var singerDto = request.getRecording().getSinger();
        singerRepository.delete(singerDto);
        recordingRepository.delete(recording);


    }

    public Integer getPayByRecording(GetPayByRecordingRequest request) {
        var recording = recordingRepository.getById(request.getId());
        return recording.getPrice();
    }

    @Transactional
    public Recording create(CreateRecordingRequest request) {
        Recording recording = new Recording();
        recording.setTitle(request.getTitle());
        recording.setVersion(request.getVersion());
        recording.setReleaseTime(request.getReleaseTime());
        recording.setCopyrights(recording.getCopyrights());
        recording.setPrice(request.getPrice());
        var singerDto = request.getSinger();
        if (singerDto != null) {
            var singer = singerRepository.findById(singerDto.getId()).orElseGet(() -> {
                var temp = new Singer();
                temp.setName(singerDto.getName());
                return singerRepository.save(temp);
            });
            recording.setSinger(singer);
        }
        return recordingRepository.save(recording);
    }

}
