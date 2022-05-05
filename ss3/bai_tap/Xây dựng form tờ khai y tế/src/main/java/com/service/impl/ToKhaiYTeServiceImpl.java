package com.service.impl;

import com.model.ToKhaiYTe;
import com.service.ToKhaiYTeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ToKhaiYTeServiceImpl implements ToKhaiYTeService {
    private static List<ToKhaiYTe> toKhaiYTes = new ArrayList<>();

    @Override
    public List<ToKhaiYTe> showList() {
        return toKhaiYTes;
    }

    @Override
    public void addNewForm(ToKhaiYTe toKhaiYTe) {
        toKhaiYTes.add(toKhaiYTe);
    }
}
