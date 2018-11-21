package com.example.gursehajharika.dronomatic;


class Userinformation  {

    private String name;
    private String email;
    private String password;
    private String productID;

    public Userinformation(){

    }

    public Userinformation(String email, String name, String password, String productID) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.productID = productID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
    public String getProductID(){
        return productID;

    }
    public void setProductID(){
        this.productID = productID;
    }
}