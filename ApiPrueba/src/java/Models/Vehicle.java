package Models;

/**
 *
 * @author Cert-555
 */
public class Vehicle {
    
    public String idvehicle;
    public String brand;
    public String model;
    public String color;
    public String countryorigin;

    public Vehicle() {
    }

    public Vehicle(String idvehicle, String brand, String model, String color, String countryorigin) {
        this.idvehicle = idvehicle;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.countryorigin = countryorigin;
    }

    public String getIdvehicle() {
        return idvehicle;
    }

    public void setIdvehicle(String idvehicle) {
        this.idvehicle = idvehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountryorigin() {
        return countryorigin;
    }

    public void setCountryorigin(String countryorigin) {
        this.countryorigin = countryorigin;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "idvehicle=" + idvehicle + ", brand=" + brand + ", model=" + model + ", color=" + color + ", countryorigin=" + countryorigin + '}';
    }

    
    
}
