package com.example.week3;

public class Customer {
    private String ID;
    private String name;
    private boolean sex;
    private int age;

    public void setID(String ID) {
        this.ID  = ID;
    }

    public String getID(){
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(String sex) {
        if(sex.equalsIgnoreCase("male")){
            this.sex = true;
        } else {
            this.sex = false;
        }
    }

    public boolean getSex() {
        return this.sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Customer() {
        this("", null, "female", 0);
    }
    public Customer(String ID, String n, String s, int a) {
        setID(ID);
        setName(n);
        setSex(s);
        setAge(a);
    }
}
