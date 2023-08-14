package com.example.lab3;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class GeneratePasswordService {
    @RequestMapping(path = "{name:[a-z]+}.generate", method = {RequestMethod.GET})
    public String generate(@PathVariable("name") String name) {
        Random rand = new Random();
        int min = 100000000;
        int max = 999999999;
        int randomNum = min+(int)(Math.random()*((max-min)+1));

        return  "Hi, " + name + "\n" + "Your new password is " + randomNum;
    }
}
