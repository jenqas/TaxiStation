package cars;

import models.CarCategory;

abstract public class Car {

    private long carId;
    private String Brand;
    private String Model;
    private int Year;
    private double fuelConsumption;
    CarCategory category;

    public Car(long carId, String brand, String model, int year, double fuelConsumption, CarCategory category) {
        this.carId = carId;
        this.Brand = brand;
        this.Model = model;
        this.Year = year;
        this.fuelConsumption = fuelConsumption;
        this.category = category;
    }

    public long getCarId() {
        return carId;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public int getYear() {
        return Year;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setYear(int year) {
        Year = year;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public CarCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "{" +
                "Brand='" + Brand + '\'' +
                ", Model='" + Model + '\'' +
                ", Year=" + Year +
                ", fuelConsumption=" + fuelConsumption +
                ", category=" + category + '}';
    }
}
