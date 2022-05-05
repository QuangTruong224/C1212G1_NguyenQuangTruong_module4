package com.service;

import com.model.Mail;

import java.util.List;

public interface MailService {
    public List<Mail> showList();

    void addNewForm(Mail mail);
}
