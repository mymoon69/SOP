package com.example.week3;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathService {
    @RequestMapping(value = {"/add/{num1}/{num2}"}, method = {RequestMethod.GET})
    public String add(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return String.valueOf(num1+num2);
    }

    @RequestMapping(value = {"/minus/{num1}/{num2}"}, method = {RequestMethod.GET})
    public String minus(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return String.valueOf(num1-num2);
    }

    @RequestMapping(value = {"/multiply"}, method = {RequestMethod.GET})
    public String multiply(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return String.valueOf(num1*num2);
    }

    @RequestMapping(value = {"/divide"}, method = {RequestMethod.GET})
    public String divide(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return  String.valueOf(num1/num2);
    }
}