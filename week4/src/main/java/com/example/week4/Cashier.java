package com.example.week4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = {"/getChange/{money}"}, method = {RequestMethod.GET})
    public Change getChange(@PathVariable String money){
        int mymoney = Integer.parseInt(money);

        int b1000 = mymoney/1000;
        mymoney = mymoney%1000;
        int b500 = mymoney/500;
        mymoney = mymoney%500;
        int b100 = mymoney/100;
        mymoney = mymoney%100;
        int b20 = mymoney/20;
        mymoney = mymoney%20;
        int b10 = mymoney/10;
        mymoney = mymoney%10;
        int b5 = mymoney/5;
        mymoney = mymoney%5;
        int b1 = mymoney/1;

        return new Change(b1000, b500, b100, b20, b10, b5, b1);
    }
}
