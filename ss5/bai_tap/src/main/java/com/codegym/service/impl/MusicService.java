package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
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
        musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        musicRepository.update(music);
    }

    @Override
    public void remove(Music music) {
        musicRepository.remove(music);
    }
}

//    @Override
//    public void remove(int id) {
//        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
//        entityTransaction.begin();
//        Music music=this.findById(id);
//        BaseRepository.entityManager.remove(music);
//        entityTransaction.commit();
//    }

