package com.codegym.update_music.service.impl;

import com.codegym.update_music.dto.MusicDto;
import com.codegym.update_music.model.Music;
import com.codegym.update_music.repository.IMusicRepository;
import com.codegym.update_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;


    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        this.musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Music music) {
        musicRepository.save(music);
    }


//    @Override
//    public List<MusicDto> searchByContent(String name) {
//        return musicRepository.searchByContent("%" + name + "%");
//    }

//    @Override
//    public Page<MusicDto> findAllBy(Pageable pageable) {
//        return musicRepository.findAll(pageable);
//    }
}
