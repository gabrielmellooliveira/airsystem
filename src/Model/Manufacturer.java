package Model;

/**
 *
 * @author User
 */
public class Manufacturer {

    private int id_manufacturer;
    private String manufacturer;
    private String focus;
    private String country_origin;
    private String phone;
    private String email;

    public Manufacturer(int id_manufacturer, String manufacturer, String focus, String country_origin, String phone, String email) {
        this.id_manufacturer = id_manufacturer;
        this.manufacturer = manufacturer;
        this.focus = focus;
        this.country_origin = country_origin;
        this.phone = phone;
        this.email = email;
    }

    public Manufacturer(String manufacturer, String focus, String country_origin, String phone, String email) {
        this.manufacturer = manufacturer;
        this.focus = focus;
        this.country_origin = country_origin;
        this.phone = phone;
        this.email = email;
    }

    public int getId_manufacturer() {
        return id_manufacturer;
    }

    public void setId_manufacturer(int id_manufacturer) {
        this.id_manufacturer = id_manufacturer;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getCountry_origin() {
        return country_origin;
    }

    public void setCountry_origin(String country_origin) {
        this.country_origin = country_origin;
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
    
    
    
}
