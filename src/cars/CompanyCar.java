package cars;

import models.CarCategory;

public class CompanyCar extends Car {

    private double price;
    private double taxForEachOrder=10.0;

    public CompanyCar(long carId, String brand, String model, int year, double fuelConsumption, CarCategory category, double price){
        super(carId, brand, model, year, fuelConsumption, category);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public double getTaxForEachOrder() {
        return taxForEachOrder;
    }

    @Override
    public String toString() {
        String carsBase = super.toString().replace("}",
                ", taxForEachOrder=" + taxForEachOrder +
                        "%"+
                        ", price=" + price + "}");
        carsBase = carsBase.replace("{","\nCompanyCar {");
        return carsBase;
    }

}
