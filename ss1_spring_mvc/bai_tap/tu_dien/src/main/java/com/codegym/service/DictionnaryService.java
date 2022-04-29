package com.codegym.service;

import java.util.Map;

public interface DictionnaryService {
    public Map<String, String> mapDictionnary();

    public String translate(String search);
}
