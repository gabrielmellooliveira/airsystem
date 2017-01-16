package Model;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class User {
   
    private String name;
    private String last_name;
    private String address;
    private LocalDate date_birth;
    private String phone;
    private String user;
    private String password;
    private String img;

    public User(String name, String last_name, String address, LocalDate date_birth, String phone, String user, String password) {
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.date_birth = date_birth;
        this.phone = phone;
        this.user = user;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(LocalDate date_birth) {
        this.date_birth = date_birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
