package com.lql.comparabledemo;

public class People implements Comparable<People>{

    private String name;
    private Integer age;
    private String sex;

    public People() {
        super();
    }

    public People(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }


    @Override
    public int compareTo(People o) {
        if(this.age < o.age) return 1;
        return -1;
    }
}
