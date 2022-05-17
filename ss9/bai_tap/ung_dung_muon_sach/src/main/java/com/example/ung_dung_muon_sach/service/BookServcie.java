package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookServcie {
    Book findById(int id);
    Page<Book> findAll(Pageable pageable);

    Page<Book> searchByName(String name,Pageable pageable);

    Book findOne(int id);

    Book save(Book book);

    List<Book> save(List<Book> customers);

    boolean exists(int id);

    List<Book> findAll(List<Long> ids);

    long count();

    void delete(int id);

    void delete(Book blog);

    void delete(List<Book> blogList);

    void deleteAll();
}
