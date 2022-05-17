package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Borrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BorrowService {
    Iterable<Borrow> findAll();
    Page<Borrow> findAll(Pageable pageable);

    Optional<Borrow> findById(int id);

    void save(Borrow borrow);

    void remove(int id);

    void removeBySsBook(int ssBook);

}
