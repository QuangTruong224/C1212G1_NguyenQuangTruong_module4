package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.Borrow;
import com.example.ung_dung_muon_sach.service.BookServcie;
import com.example.ung_dung_muon_sach.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping({"/book",""})
public class BookController {
    @Autowired
    private BookServcie bookServcie;

    @Autowired
    private BorrowService borrowService;

    @GetMapping("")
    public String index(Model model, Pageable pageable) {
        Page<Book> books = bookServcie.findAll(pageable);
        model.addAttribute("books", books);
        return "/book/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("books", new Book());
        return "/book/create";
    }

    @PostMapping("/save")
    public String save(Book book, RedirectAttributes redirectAttributes, Model model, Pageable pageable) {
        bookServcie.save(book);
        Page<Book> blogs = bookServcie.findAll(pageable);
        model.addAttribute("books", blogs);
        redirectAttributes.addFlashAttribute("success", "Addnew Success");
        return "redirect:/book";
    }

    @GetMapping("/{id}/borrow")
    public String edit(@PathVariable int id, Model model) {
        Book book = bookServcie.findById(id);
        if (book != null) {
            if (book.getQuantity() > 0) {
                model.addAttribute("book", book);
                model.addAttribute("code",randomBorrowedNumber());
                return "book/borrow";
            } else {
                throw new NumberFormatException("");
            }
        } return "redirect:/";
    }

    @PostMapping("/borrow")
    public String update(Book book,Model model,@RequestParam(name = "code")int code, Pageable pageable) {
        book.setQuantity(book.getQuantity()-1);
        Borrow borrow = new Borrow(code,book);
        borrowService.save(borrow);

        bookServcie.save(book);
        return "redirect:/";
    }

    @GetMapping("/{id}/return")
    public String delete(@PathVariable int id, Model model) {
        Book book = bookServcie.findById(id);
        model.addAttribute("book", book);
        return "book/return";
    }

    @PostMapping("/return")
    public String delete(Book book, @RequestParam int ssBook, Model model, Pageable pageable, RedirectAttributes redirectAttributes) {
        book.setQuantity(book.getQuantity()+1);
        borrowService.removeBySsBook(ssBook);
        redirectAttributes.addFlashAttribute("message","Bạn đã xóa thành công sách");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", bookServcie.findById(id));
        return "/book/view";
    }
    private String randomBorrowedNumber(){
        String result = "";
        for (int i = 0;i<5;i++){
            result +=randomNumber();
        }
        return result;
    }
    private int randomNumber(){
        int number = (int) Math.round(Math.random()*9);
        return number;
    }
}
