package com.gr.jiang.po;

import java.util.LinkedHashMap;

/**
 * Created by jiang on 2017/1/5.
 */
public class Person {
    private String name;
    private int age;
    private String url;

    public Person() {
        LinkedHashMap maps = new LinkedHashMap();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", url='" + url + '\'' +
                '}';
    }
}
