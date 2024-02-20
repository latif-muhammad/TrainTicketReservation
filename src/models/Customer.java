package models;

import java.util.ArrayList;

public class Customer {
    public String customer_name;
    public String customer_mobile;
    public String age;

    public Customer(String customer_name, String customer_mobile, String age){
        this.customer_mobile=customer_mobile;
        this.customer_name=customer_name;
        this.age = age;
    }
}
