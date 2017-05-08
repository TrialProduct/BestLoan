package com.wl.atomsparenting.domain;

/**
 * Created by le on 2017/4/8.
 */

public class Griddomain {
    private int img;
    private String name;

    @Override
    public String toString() {
        return "Griddomain{" +
                "img=" + img +
                ", name='" + name + '\'' +
                '}';
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Griddomain() {

    }

    public Griddomain(int img, String name) {

        this.img = img;
        this.name = name;
    }
}
