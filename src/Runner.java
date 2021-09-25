import cars.CompanyCar;

import java.util.Arrays;
import java.util.List;
import cars.*;
import custom_exceptions.IncorrectTaxValueException;
import custom_exceptions.WrongPriceAmountException;
import models.CarCategory;

public class Runner {

    public static void main(String[] args) throws WrongPriceAmountException {

        List<? extends Car> allCars = Arrays.asList(
                new CompanyCar("Opel", "Astra", 2010,5.5, CarCategory.COMFORT, 7100),
                new CompanyCar("VW", "Polo", 2012, 9.6, CarCategory.ECONOM, 7400),
                new CompanyCar("VW", "Polo", 2018, 10, CarCategory.COMFORT, 13000),
                new CompanyCar("Renault", "Logan", 2009, 6.7, CarCategory.ECONOM, 6000),
                new CompanyCar("BMW", "GT", 2013, 12, CarCategory.BUSINESS, 21200),
                new CompanyCar("Hyundai", "Solaris", 2015, 7.5, CarCategory.ECONOM, 8300),
                new CompanyCar("Audi", "A6", 2012, 11, CarCategory.BUSINESS, 18000),
                new DriversCar("Renault", "Laguna", 2008, 6.6,  CarCategory.ECONOM),
                new DriversCar("Opel", "Insignia", 2010, 7.1,  CarCategory.BUSINESS),
                new DriversCar("Skoda", "Rapid", 2017, 7.9,  CarCategory.ECONOM)
        );

        // Создать таксопарк
        TaxiStation taxiStation = new TaxiStation(allCars);
        try { taxiStation.setTaxes(allCars, 5, 10); } catch (IncorrectTaxValueException e){
            e.printStackTrace();
        }
        System.out.println("Full Car List:\n"  +   allCars);

        // Посчитать стоимость автопарка.
        System.out.println("\nTotal Costs of owned by company cars:\n" + taxiStation.calculateOwnedCarsCosts(taxiStation.getCompanyCars()));

        // Провести сортировку автомобилей парка по расходу топлива.
        taxiStation.sortCarsByFuelConsumption();
        System.out.println("\nAll Cars sorted by Fuel Consumption:\n" + allCars);

        //  Найти автомобиль в компании, соответствующий заданному диапазону параметров и записать его в файл
        taxiStation.findCompanyCarByParameters();

        // добавить 1 пользовательское исключение

        // Дополнить сценарии, реализованные в задании 2.1 – добавить чтение данных из файла / запись данных в файл, используя I/O Streams.
    }

}
