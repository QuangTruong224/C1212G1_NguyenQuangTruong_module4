package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class MoneyServiceImpl implements MoneyService{
    @Override
    public Double convert(double usd, double rate) {
        return usd * rate;
    }
}
