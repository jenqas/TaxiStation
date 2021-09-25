import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cars.*;
import custom_exceptions.IncorrectTaxValueException;
import custom_exceptions.WrongPriceAmountException;
import database.DatabaseHandler;
import models.CarCategory;

public class Runner {

    public static void main(String[] args) {

        // Чтение из json-файла
        List<CompanyCar> companyCars = GsonParser.parseCompanyCars();
        List<DriversCar> driversCars = GsonParser.parseDriversCars();

        ArrayList<? extends Car> allCars = TaxiStation.getAllCars(companyCars,driversCars);

        // Создать таксопарк
        TaxiStation taxiStation = new TaxiStation(allCars);
        try { taxiStation.setTaxes(allCars, 5, 10); } catch (IncorrectTaxValueException e){
            e.printStackTrace();
        } // setting taxes for Drivers w/ & w/o own car

        System.out.println("Taxi Station Cars:\n---------------------------");
        taxiStation.printTaxiStationCars();

        // Посчитать стоимость автопарка.
        System.out.println("\nSum of Company Car Prices:\n---------------------------\n" + taxiStation.calculateOwnedCarsCosts(taxiStation.getCompanyCars()) + " $");

        // Провести сортировку автомобилей парка по расходу топлива.
        taxiStation.sortCarsByFuelConsumption();
        System.out.println("\nSorted by Fuel Consumption:\n---------------------------");
        taxiStation.printTaxiStationCars();

        //  Найти автомобиль в компании, соответствующий заданному диапазону параметров и записать его в файл (чтение данных из файла / запись данных в файл, используя I/O Streams)
        System.out.println("\nSearching a company car by parameters maintained in data/searchCarParameters.txt ...");
        System.out.println("Results were saved to data/searchResult.txt file");
        taxiStation.findCompanyCarsByParameters();

        // writing CompanyCar objects into MySQL table
        DatabaseHandler.clearDBCompanyCarsTable();
        System.out.println("Writing Company Cars to DB Table...");
        for (CompanyCar car: taxiStation.getCompanyCars()) {
            DatabaseHandler.addToDBCompanyCar(car);
        }
        // fetching DB Table and printing Results in console
        DatabaseHandler.printDatabaseTableCompanyCars();

    }

}
