package com.example.andy.pigeonapplication;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

//defaultValue默认值  string
//unique唯一性   boolean
//nullable可为空 boolean
//ignore 是否忽略 boolean

public class PigeonBean extends LitePalSupport{

    private String country;  //国家

    private String year;     //年份

    private String area;     //地区

    private String number;   //号码

    @Column(defaultValue = "暂无")
    private String sex;      //性别

    private String eye;      //眼睛

    private String color;    //羽色

    private String birth;    //出壳日期

    private String father;   //父亲

    private String mather;   //母亲

    @Column(defaultValue = "在棚")
    private String state;    //状态

    @Column(defaultValue = "暂无")
    private String notes;    //备注

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMather() {
        return mather;
    }

    public void setMather(String mather) {
        this.mather = mather;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
