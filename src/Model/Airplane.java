package Model;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Airplane {

    private int id_airplane;
    private String model;
    private int number_seats;
    private LocalDate fabrication;
    private String manufacturer;
    private String company;
    private String color;
    private String description;
    private String audio;
    private String img;

    public Airplane(int id_airplane, String model, int number_seats, LocalDate fabrication, String manufacturer, String company, String color, String description, String audio, String img) {
        this.id_airplane = id_airplane;
        this.model = model;
        this.number_seats = number_seats;
        this.fabrication = fabrication;
        this.manufacturer = manufacturer;
        this.company = company;
        this.color = color;
        this.description = description;
        this.audio = audio;
        this.img = img;
    }

    public Airplane(String model, int number_seats, LocalDate fabrication, String manufacturer, String company, String color, String description, String audio, String img) {
        this.model = model;
        this.number_seats = number_seats;
        this.fabrication = fabrication;
        this.manufacturer = manufacturer;
        this.company = company;
        this.color = color;
        this.description = description;
        this.audio = audio;
        this.img = img;
    }

    public int getId_airplane() {
        return id_airplane;
    }

    public void setId_airplane(int id_airplane) {
        this.id_airplane = id_airplane;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumber_seats() {
        return number_seats;
    }

    public void setNumber_seats(int number_seats) {
        this.number_seats = number_seats;
    }

    public LocalDate getFabrication() {
        return fabrication;
    }

    public void setFabrication(LocalDate fabrication) {
        this.fabrication = fabrication;
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
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
