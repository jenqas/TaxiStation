import cars.CompanyCar;

import java.util.Arrays;
import java.util.List;
import cars.*;
import models.CarCategory;

public class Runner {

    public static void main(String[] args) {

        List<Car> allCars = Arrays.asList(
                new CompanyCar(1, "Opel", "Astra", 2010,5.5, CarCategory.COMFORT, 7100),
                new CompanyCar(2, "VW", "Polo", 2012, 9.6, CarCategory.ECONOM, 7400),
                new CompanyCar(3, "VW", "Polo", 2018, 10, CarCategory.COMFORT, 13000),
                new CompanyCar(4, "Renault", "Logan", 2009, 6.7, CarCategory.ECONOM, 6000),
                new CompanyCar(5, "BMW", "GT", 2013, 12, CarCategory.BUSINESS, 21200),
                new CompanyCar(6, "Hyundai", "Solaris", 2015, 7.5, CarCategory.ECONOM, 8300),
                new CompanyCar(7, "Audi", "A6", 2012, 11, CarCategory.BUSINESS, 18000),
                new DriversCar(8, "Renault", "Laguna", 2008, 6.6,  CarCategory.ECONOM),
                new DriversCar(9, "Opel", "Insignia", 2010, 7.1,  CarCategory.BUSINESS),
                new DriversCar(10, "Skoda", "Rapid", 2017, 7.9,  CarCategory.ECONOM)
        );

        System.out.println("Full Car list used in TaxiStation:\n"  +   allCars);

        TaxiStation taxiStation = new TaxiStation(allCars);          //       Создать таксопарк.
        System.out.println("\nTotal Costs of owned by company cars:\n" + taxiStation.calculateOwnedCarsCosts(taxiStation.getTaxiStationCars())); // Посчитать стоимость автопарка.
        taxiStation.sortCarsByFuelConsumption();                     //       Провести сортировку автомобилей парка по расходу топлива.
        System.out.println("\nAll Cars sorted by Fuel Consumption:\n" + allCars);

        //  Найти автомобиль в компании, соответствующий заданному диапазону параметров.

        List<? extends Car> foundCars = taxiStation.findTaxiStationCarByParameters("Opel", "Astra", 2010,5.5, CarCategory.COMFORT,7100);
        if (foundCars.size()==0) { System.out.println("\nNo company cars were found by your parameters.."); }
        else {
            System.out.println("\nFound by Parameters Company Car(s):\n" + foundCars);
        }

        foundCars = taxiStation.findDriversCarByParameters("Skoda", "Rapid", 2017,7.9, CarCategory.ECONOM);
        if (foundCars.size()==0) {  System.out.println("\nNo driver cars were found by your parameters.."); }
        else {  System.out.println("\nFound by Parameters Drivers Car(s):\n" + foundCars);  }

//                Для объектной модели, реализованной в задании 2.1, необходимо реализовать классы пользовательских исключений
//                и организовать обработку возможных исключительных ситуаций,
//                например, если элемент отсутствует в коллекции, если мы не можем удалить текущий элемент и т.д. Комментарии оставлять в классах исключений.
//                Создать минимум 3 пользовательских исключения и использовать минимум 5 встроенных исключений.

//                Дополнить сценарии, реализованные в задании 2.1 – добавить чтение данных из файла / запись данных в файл, используя I/O Streams.


    }

}
