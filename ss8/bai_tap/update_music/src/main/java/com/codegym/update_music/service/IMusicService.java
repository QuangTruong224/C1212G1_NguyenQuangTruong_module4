package com.codegym.update_music.service;

import com.codegym.update_music.dto.MusicDto;
import com.codegym.update_music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void  save(Music music);

    Music findById(int id);

    void update( Music music);
//    void remove(int id);
//    List<MusicDto> searchByContent(String name);
//    Page<MusicDto> findAllBy(Pageable pageable);
}
