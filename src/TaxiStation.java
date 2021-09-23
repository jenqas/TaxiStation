import cars.*;
import models.CarCategory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiStation {

    private List<? extends Car> cars;

    public TaxiStation(List<? extends Car> cars) {
        this.cars = cars;
    }

    public List<CompanyCar> getTaxiStationCars(){

        List<CompanyCar> ownedCars = new ArrayList<>();

        for (Car car : cars) {
            if (car instanceof CompanyCar) {
                ownedCars.add((CompanyCar) car);
            }
        }

        return ownedCars;
    }

    public double calculateOwnedCarsCosts(List <CompanyCar> ownedCars){
        double totalCostsOfOwnedCars = 0;
        for (CompanyCar car : ownedCars) {
            totalCostsOfOwnedCars += car.getPrice();
        }

        return totalCostsOfOwnedCars;
    }

    public void sortCarsByFuelConsumption(){
        cars.sort(Comparator.comparing(Car::getFuelConsumption));
    }

    public List<CompanyCar> findTaxiStationCarByParameters(String brand, String model, int year, double fuelConsumption, CarCategory category, double price){

        List<CompanyCar> ownedCars = new ArrayList<>();

        for (Car car : cars) {
            if (car instanceof CompanyCar) {
                ownedCars.add((CompanyCar) car);
            }
        }

        ownedCars.removeIf(o -> o.getBrand()!=brand);
        ownedCars.removeIf(o -> o.getModel()!=model);
        ownedCars.removeIf(o -> o.getYear()!=year);
        ownedCars.removeIf(o -> o.getFuelConsumption()!=fuelConsumption);
        ownedCars.removeIf(o -> o.getCategory()!=category);
        ownedCars.removeIf(o -> o.getPrice()!=price);

        return ownedCars;
    }

    public List<DriversCar> findDriversCarByParameters(String brand, String model, int year, double fuelConsumption, CarCategory category){

        List<DriversCar> driversCars = new ArrayList<>();

        for (Car car : cars) {
            if (car instanceof DriversCar) {
                driversCars.add((DriversCar) car);
            }
        }

        driversCars.removeIf(o -> o.getBrand()!=brand);
        driversCars.removeIf(o -> o.getModel()!=model);
        driversCars.removeIf(o -> o.getYear()!=year);
        driversCars.removeIf(o -> o.getFuelConsumption()!=fuelConsumption);
        driversCars.removeIf(o -> o.getCategory()!=category);

        return driversCars;

    }

}
