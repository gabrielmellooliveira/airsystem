package Model;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class User {
   
    private int id_user;
    private String name;
    private String last_name;
    private String address;
    private LocalDate date_birth;
    private String phone;
    private String user;
    private String password;
    private String img;

    public User(int id_user, String name, String last_name, String address, LocalDate date_birth, String phone, String user, String password, String img) {
        this.id_user = id_user;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.date_birth = date_birth;
        this.phone = phone;
        this.user = user;
        this.password = password;
        this.img = img;
    }

    public User(String name, String last_name, String address, LocalDate date_birth, String phone, String user, String password, String img) {
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.date_birth = date_birth;
        this.phone = phone;
        this.user = user;
        this.password = password;
        this.img = img;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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
