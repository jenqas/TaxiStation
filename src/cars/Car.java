package cars;

import models.CarCategory;

import java.io.IOException;

abstract public class Car {

    private String Brand;
    private String Model;
    private int Year;
    private double fuelConsumption;
    CarCategory category;

    public Car(String brand, String model, int year, double fuelConsumption, CarCategory category) {

        try {
            if (year>2021 || year < 2000) throw new IOException("Car Release Year value can not be <2000 and >2021");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (fuelConsumption>15 || fuelConsumption<3) throw new IOException("Fuel Consumption value is invalid..");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (brand=="" || model=="" ) throw new IOException("Brand or Model value can't be empty..");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CarCategory c: CarCategory.values()) {

        }

        this.Brand = brand;
        this.Model = model;
        this.Year = year;
        this.fuelConsumption = fuelConsumption;
        this.category = category;
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
