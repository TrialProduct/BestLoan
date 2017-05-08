package com.wl.atomsparenting.domain;

/**
 * Created by le on 2017/4/10.
 */

public class GriddoGoodTrick {
    private String img;
    private String title;
    private int number;
    private String name;
    @Override
    public String toString() {
        return "Griddomaiozhao{" +
                "img=" + img +
                ", title='" + title + '\'' +
                ", number=" + number +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GriddoGoodTrick() {


    }

    public GriddoGoodTrick(String img, String title, int number, String name) {

        this.img = img;
        this.title = title;
        this.number = number;
        this.name = name;
    }
}
