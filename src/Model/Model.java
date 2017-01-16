package Model;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Model {
 
    private String model;
    private int number_seats;
    private String origin;
    private LocalDate fabrication;
    private int turbines;

    public Model(String model, int number_seats, String origin, LocalDate fabrication, int turbines) {
        this.model = model;
        this.number_seats = number_seats;
        this.origin = origin;
        this.fabrication = fabrication;
        this.turbines = turbines;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDate getFabrication() {
        return fabrication;
    }

    public void setFabrication(LocalDate fabrication) {
        this.fabrication = fabrication;
    }

    public int getTurbines() {
        return turbines;
    }

    public void setTurbines(int turbines) {
        this.turbines = turbines;
    }
    
    
    
}
