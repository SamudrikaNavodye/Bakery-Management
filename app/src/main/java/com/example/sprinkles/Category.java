package com.example.sprinkles;


public class Category
{
    private String CategoryId;
    private String CategoryName;

    public Category (String categoryId){

        this.CategoryId = categoryId;
    }
    public Category(String categoryId, String categoryName){
        CategoryId= categoryId;
        CategoryName= categoryName;
    }

    public Category() {

    }

    public void setCategoryId(String categoryId){
        CategoryId=categoryId;
    }

    public String getCategoryId() {

        return CategoryId;
    }
    public void setCategoryName(String categoryName) {

        CategoryName = categoryName;
    }
    public String getCategoryName(){

        return CategoryName;
    }

}
