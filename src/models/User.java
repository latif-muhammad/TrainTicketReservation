package models;

public class User {
    public  int user_id;
    public String user_name;
    public String user_address;
    String role;
    String phone;
    String password;

    public User(int user_id, String user_name, String pass, String phone, String user_address,String role){
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_address = user_address;
        this.password = pass;
        this.phone = phone;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getUser_address() {
        return user_address;
    }

    public String getUser_name() {
        return user_name;
    }
}
