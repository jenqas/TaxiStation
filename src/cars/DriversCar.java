package cars;

import custom_exceptions.IncorrectTaxValueException;
import models.*;

public class DriversCar extends Car{

    //TaxiStation requires less TAX amount if employee use his own car for work (5% instead of 10)
    private int taxiStationTax;

    public DriversCar(String brand, String model, int year, double fuelConsumption, CarCategory category){
        super(brand, model, year, fuelConsumption, category);
    }

    public int getTaxiStationTax() {
        return taxiStationTax;
    }

    public void setTaxiStationTax(int taxiStationTax) {
        this.taxiStationTax = taxiStationTax;
    }

    @Override
    public String toString() {
        String carsBase = super.toString().replace("}",
                ", Tax=" + taxiStationTax +
                        "% }");
        carsBase = carsBase.replace("{","DriversCar { ");
        return carsBase;
    }

}
