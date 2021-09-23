package cars;

import models.*;

public class DriversCar extends Car{

    //TaxiStation requires less TAX amount if employee use his own car for work (5% instead of 10)
    private double taxForEachOrder=5;

    public DriversCar(long carId, String brand, String model, int year, double fuelConsumption, CarCategory category){
        super(carId, brand, model, year, fuelConsumption, category);
    }

    public double getTaxForEachOrder() {
        return taxForEachOrder;
    }

    @Override
    public String toString() {
        String carsBase = super.toString().replace("}",
                ", taxForEachOrder=" + taxForEachOrder +
                        "% }");
        carsBase = carsBase.replace("{","\nDriversCar {");
        return carsBase;
    }

}
