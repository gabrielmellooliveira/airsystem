package Model;

/**
 *
 * @author User
 */
public class Airplane {

    private String model;
    private String manufacturer;
    private String company;
    private String color;
    private String description;
    private String audio;

    public Airplane(String model, String manufacturer, String company, String color, String description, String audio) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.company = company;
        this.color = color;
        this.description = description;
        this.audio = audio;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
    
    
    
}
