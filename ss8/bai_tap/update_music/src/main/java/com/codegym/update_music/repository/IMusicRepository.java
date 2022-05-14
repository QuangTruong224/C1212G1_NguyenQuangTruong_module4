package com.codegym.update_music.repository;

import com.codegym.update_music.dto.MusicDto;
import com.codegym.update_music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMusicRepository extends JpaRepository<Music,Integer> {

//    @Query(value = "select * from update_music where name like :name", nativeQuery = true)
//    List<MusicDto> searchByContent(@Param("name") String name);

    Page<Music> findAll(Pageable pageable);
}
