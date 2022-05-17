package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Borrow;
import com.example.ung_dung_muon_sach.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    BorrowRepository borrowRepository;

    @Override
    public Iterable<Borrow> findAll() {
        return null;
    }

    @Override
    public Page<Borrow> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Borrow> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    @Override
    public void remove(int id) {

    }


    @Override
    public void removeBySsBook(int ssBook) {
        borrowRepository.deleteBySsBook(ssBook);
    }
}
