package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
    void deleteBySsBook(int ssBook);
}
