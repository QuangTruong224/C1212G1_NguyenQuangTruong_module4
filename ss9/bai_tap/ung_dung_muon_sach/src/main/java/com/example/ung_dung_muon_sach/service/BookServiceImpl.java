package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookServcie {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> searchByName(String name, Pageable pageable) {
        return bookRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Book findOne(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> save(List<Book> customers) {
        return bookRepository.saveAll(customers);
    }

    @Override
    public boolean exists(int id) {
        return bookRepository.existsById(id);
    }

    @Override
    public List<Book> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void delete(Book blog) {
        bookRepository.delete(blog);
    }

    @Override
    public void delete(List<Book> blogList) {
        bookRepository.deleteAll(blogList);
    }

    @Override
    public void deleteAll() {

    }
}
