package com.example.week6.POJO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data //บอกว่าเป็น POJO
@Document("Wizard") //บอก collection name ที่คลาสเป็น Data model
public class Wizard implements Serializable {

    @Id //บอกว่าแอททริบิวไหนเป็นคีย์
    private String _id;
    private String sex;
    private String name;
    private String school;
    private String house;
    private String money;
    private String position;

    public Wizard(){}

    public Wizard(String _id, String sex, String name, String school, String house, String money, String position){
        this._id = _id;
        this.sex = sex;
        this.name = name;
        this.school = school;
        this.house = house;
        this.money = money;
        this.position = position;
    }
}
