package com.example.week4;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MathAPI {
    @RequestMapping(value = {"/plus/{n1}/{n2}"}, method = {RequestMethod.GET})
    public String myPlus(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return String.valueOf(n1+n2);
    }

    @RequestMapping(value = {"/minus/{n1}/{n2}"}, method = {RequestMethod.GET})
    public String myMinus(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return String.valueOf(n1-n2);
    }

    @RequestMapping(value = {"/divide/{n1}/{n2}"}, method = {RequestMethod.GET})
    public String myDivide(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return String.valueOf(n1/n2);
    }

    @RequestMapping(value = {"/multi/{n1}/{n2}"}, method = {RequestMethod.GET})
    public String myMulti(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return String.valueOf(n1*n2);
    }

    @RequestMapping(value = {"/mod/{n1}/{n2}"}, method = {RequestMethod.GET})
    public String myMod(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return String.valueOf(n1%n2);
    }

    @RequestMapping(value = {"/max"}, method = {RequestMethod.POST})
    public double myMax(@RequestBody MultiValueMap<String, String> n) {
        Map<String, String> d = n.toSingleValueMap();
        double maxnumber = Math.max(Double.parseDouble(d.get("n1")), Double.parseDouble(d.get("n2")));
        return  maxnumber;
    }

}
