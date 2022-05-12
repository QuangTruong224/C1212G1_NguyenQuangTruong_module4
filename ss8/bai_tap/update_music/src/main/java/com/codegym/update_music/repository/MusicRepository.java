package com.codegym.update_music.repository;

import com.codegym.update_music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public class MusicRepository implements JpaRepository<Music,Integer> {
}
