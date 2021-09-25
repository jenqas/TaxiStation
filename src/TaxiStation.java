import cars.*;
import custom_exceptions.IncorrectTaxValueException;
import models.CarCategory;

import java.io.*;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class TaxiStation {

    private List<? extends Car> cars;

    public TaxiStation(List<? extends Car> cars) {
        this.cars = cars;
    }

    public static ArrayList<? extends Car> getAllCars(List<CompanyCar> companyCars, List<DriversCar> driversCars){
        ArrayList<Car> allCars = new ArrayList<>();

        for (CompanyCar cCar: companyCars ) {
            allCars.add(cCar);
        }
        for (DriversCar dCar: driversCars ) {
            allCars.add(dCar);
        }

        return allCars;
    }

    public List<CompanyCar> getCompanyCars(){

        List<CompanyCar> companyCars = new ArrayList<>();

        for (Car car : cars) {
            if (car instanceof CompanyCar) {
                companyCars.add((CompanyCar) car);
            }
        }

        return companyCars;
    }

    public List<DriversCar> getDriversCars(){

        List<DriversCar> driversCars = new ArrayList<>();

        for (Car car : cars) {
            if (car instanceof DriversCar) {
                driversCars.add((DriversCar) car);
            }
        }

        return driversCars;
    }

    public void printTaxiStationCars(){
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).toString());
        }
    }

    public void printTaxiStationCars(List<? extends Car> carList){
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).toString());
        }
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

    public void findCompanyCarsByParameters(){

        List<CompanyCar> filteredCompanyCars = getCompanyCars();

        try (FileReader reader = new FileReader("data/searchCarParameters.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter("data/searchResult.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            ArrayList<String> strings = new ArrayList<>();
            bufferedReader.lines().forEach(strings::add);

            String brand = strings.get(0).replace("Brand='","").replace("'","");
            String model = strings.get(1).replace("Model='","").replace("'","");
            int year = Integer.parseInt(strings.get(2).replace("Year='","").replace("'",""));
            double fuelConsumption = Double.parseDouble(strings.get(3).replace("FuelConsumption='","").replace("'",""));
            CarCategory category = CarCategory.valueOf(strings.get(4).replace("Category='","").replace("'",""));
            double price = Double.parseDouble(strings.get(5).replace("Price='","").replace("'",""));;

            filteredCompanyCars.removeIf(o -> !Objects.equals(o.getBrand(), brand));
            filteredCompanyCars.removeIf(o -> !Objects.equals(o.getModel(), model));
            filteredCompanyCars.removeIf(o -> !Objects.equals(o.getYear(), year));
            filteredCompanyCars.removeIf(o -> !Objects.equals(o.getFuelConsumption(), fuelConsumption));
            filteredCompanyCars.removeIf(o -> !Objects.equals(o.getCategory(), category));
            filteredCompanyCars.removeIf(o -> !Objects.equals(o.getPrice(), price));

            if (filteredCompanyCars.size()==0) {
                bufferedWriter.write("No cars found, please check your input parameters...");
            } else {
                bufferedWriter.write(filteredCompanyCars.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setTaxes(List<? extends Car> cars, int taxForDriversWithOwnCars, int taxForDriversOnCompanyCars) throws IncorrectTaxValueException {

        if (taxForDriversWithOwnCars >= taxForDriversOnCompanyCars) throw new IncorrectTaxValueException("TaxiStation Tax for Drivers with own cars should have less amount than for drivers, that use company cars");
        if (taxForDriversWithOwnCars >50 | taxForDriversWithOwnCars <1) throw new IncorrectTaxValueException("TaxiStation Tax for drivers can't be 0% or >50%");
        if (taxForDriversOnCompanyCars >50 | taxForDriversOnCompanyCars <1) throw new IncorrectTaxValueException("TaxiStation Tax for drivers can't be 0% or >50%");

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) instanceof DriversCar) ((DriversCar) cars.get(i)).setTaxiStationTax(taxForDriversWithOwnCars);
            if (cars.get(i) instanceof CompanyCar) ((CompanyCar) cars.get(i)).setTaxiStationTax(taxForDriversOnCompanyCars);
        }

    }

}
