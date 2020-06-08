package com.codegym.student.model;

import javax.persistence.*;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String address;
    private String avatar;

    @ManyToOne
    private Classes classes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
    }

    public Student(int id, String name, String address, String avatar, Classes classes) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classes = classes;
        this.avatar = avatar;
    }

    public Student(String name, String address, String avatar, Classes classes) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classes = classes;
        this.avatar = avatar;
    }

    public Student(String name, String address, String avatar) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classes = classes;
        this.avatar = avatar;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
