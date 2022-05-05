package com.service;

import com.model.Music;

import java.util.List;

public interface MusicService {
    List<Music> listAll();
    void save(Music music);
}
