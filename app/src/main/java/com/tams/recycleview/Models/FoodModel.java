package com.tams.recycleview.Models;

public class FoodModel {
    int image;
    String text;


    public FoodModel(int image, String text){
        this.image = image;
        this.text = text;
    }

    public int getImage(){
        return image;
    }
    public void setImage(int image){
        this.image = image;
    }
    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }

}
