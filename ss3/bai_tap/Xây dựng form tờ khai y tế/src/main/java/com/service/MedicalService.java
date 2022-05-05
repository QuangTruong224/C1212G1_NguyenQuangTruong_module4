package com.service;

import com.model.Medical;

import java.util.List;

public interface MedicalService {
    public List<Medical> showList();
    void addNewForm(Medical toKhaiYTe);
}
