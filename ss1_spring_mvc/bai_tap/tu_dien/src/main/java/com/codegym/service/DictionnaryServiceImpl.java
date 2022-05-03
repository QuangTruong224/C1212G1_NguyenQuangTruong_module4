package com.codegym.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionnaryServiceImpl implements DictionnaryService{


    @Override
    public String translate(String search) {
        Map<String,String>  stringMap=new HashMap<>();
        stringMap.put("Pig","Heo");
        stringMap.put("Mouse","Chuột");
        stringMap.put("Dog","Chó");
        stringMap.put("Snake","rắn");
        stringMap.put("Fish","cá");
        String result=stringMap.get(search);
        if (result==null) {
            return "Không tìm thấy";
        }
        return result;
    }
}
