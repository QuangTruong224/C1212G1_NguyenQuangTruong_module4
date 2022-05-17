package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findAll(Pageable pageable);

    Page<Book>findAllByName(Pageable pageable,String name);
    Page<Book> findByNameContaining(String name, Pageable pageable);
    Book findById(int id);

}
