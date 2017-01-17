package Model;

/**
 *
 * @author User
 */
public class Company {
  
    private int id_company;
    private String name_company;
    private String cnpj;
    private String city;
    private String phone;
    private String email;
    private String img;

    public Company(int id_company, String name_company, String cnpj, String city, String phone, String email, String img) {
        this.id_company = id_company;
        this.name_company = name_company;
        this.cnpj = cnpj;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.img = img;
    }

    public Company(String name_company, String cnpj, String city, String phone, String email, String img) {
        this.name_company = name_company;
        this.cnpj = cnpj;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.img = img;
    }

    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }
    
    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
