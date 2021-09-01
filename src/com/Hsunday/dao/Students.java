package com.Hsunday.dao;

public class Students {
    private int id;
    private int studentid;
    private String name;
    private String sex;
    private String birthday;
    private  String grade;
    private int age;
    private String time;



    public Students() {
    }

    public Students(int id, int studentid, String name, String sex, String birthday, String grade, int age, String time) {
        this.id = id;
        this.studentid = studentid;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.grade = grade;
        this.age = age;
        this.time = time;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", studentid=" + studentid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", grade='" + grade + '\'' +
                ", age=" + age +
                ", time='" + time + '\'' +
                '}';
    }
}
