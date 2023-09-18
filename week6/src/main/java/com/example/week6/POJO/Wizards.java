package com.example.week6.POJO;

import com.example.week6.POJO.Wizard;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Wizards {
    private ArrayList<Wizard> model;
    public ArrayList<Wizard> getModel(){
        return model;
    }
    public void setModel(ArrayList<Wizard> model) {
        this.model = model;
    }
//    public ArrayList<String> model;
//
//    public Wizards() {
//        this.model = new ArrayList<>();
//    }

}
