package com.service;

import com.model.ToKhaiYTe;

import java.util.List;

public interface ToKhaiYTeService {
    public List<ToKhaiYTe> showList();
    void addNewForm(ToKhaiYTe toKhaiYTe);
}
