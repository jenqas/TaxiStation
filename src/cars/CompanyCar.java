package cars;

import custom_exceptions.IncorrectTaxValueException;
import custom_exceptions.WrongPriceAmountException;
import models.CarCategory;

import java.io.Serializable;

public class CompanyCar extends Car implements Serializable {

    private double price;
    private int taxiStationTax;

    public CompanyCar(String brand, String model, int year, double fuelConsumption, CarCategory category, double price) {
        super(brand, model, year, fuelConsumption, category);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public int getTaxiStationTax() {
        return taxiStationTax;
    }

    public void setPrice(double price) throws WrongPriceAmountException {
        if (price < 1000 || price > 100000) throw new WrongPriceAmountException("Car Price can't be equal or less than 1000$");
        this.price = price;
    }

    public void setTaxiStationTax(int taxiStationTax) throws IncorrectTaxValueException {
        if (taxiStationTax>50 | taxiStationTax<1) throw new IncorrectTaxValueException("TaxiStation Tax for drivers can't be 0% or >50%");
        this.taxiStationTax = taxiStationTax;
    }

    @Override
    public String toString() {
        String carsBase = super.toString().replace("}",
                ", Tax=" + taxiStationTax +
                        "%"+
                        ", price=" + price + "}");
        carsBase = carsBase.replace("{","CompanyCar {");
        return carsBase;
    }

}
