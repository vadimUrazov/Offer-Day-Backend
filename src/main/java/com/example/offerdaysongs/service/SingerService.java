package com.example.offerdaysongs.service;

import com.example.offerdaysongs.dto.requests.CreateSingerRequest;
import com.example.offerdaysongs.dto.requests.DeleteSingerRequest;
import com.example.offerdaysongs.dto.requests.UpdateSingerRequest;
import com.example.offerdaysongs.model.Singer;
import com.example.offerdaysongs.repository.SingerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SingerService {
    private final SingerRepository singerRepository;

    public SingerService(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    public List<Singer> getAllSingers() {
        return singerRepository.findAll();
    }

    public void deleteAll() {
        singerRepository.deleteAll();
    }

    public Singer getById(long id) {
        return singerRepository.getById(id);
    }

    public Singer create(CreateSingerRequest request) {
        Singer singer = new Singer();
        singer.setName(request.getName());
        return singerRepository.save(singer);
    }

    @Transactional
    public Singer update(UpdateSingerRequest request) {
        var singer = singerRepository.getById(request.getSinger().getId());
        singer.setName(request.getSinger().getName());
        return singerRepository.save(singer);
    }

    @Transactional
    public void delete(DeleteSingerRequest request) {
        singerRepository.delete(request.getSinger());

    }

}
