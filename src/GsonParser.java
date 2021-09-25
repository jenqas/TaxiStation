import cars.Car;
import cars.CompanyCar;
import cars.DriversCar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class GsonParser {

    static Gson gson = new Gson();

    public static List<CompanyCar> parseCompanyCars(){
        try (FileReader reader = new FileReader("data/companyCars.json")){

            List<CompanyCar> companyCarsList = new ArrayList<>();
            Type listType = new TypeToken<List<CompanyCar>>() {}.getType();
            companyCarsList = gson.fromJson(reader, listType);
            return companyCarsList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<DriversCar> parseDriversCars(){
        try (FileReader reader = new FileReader("data/driversCars.json")){

            List<DriversCar> driversCarList = new ArrayList<>();
            Type listType = new TypeToken<List<DriversCar>>() {}.getType();
            driversCarList = gson.fromJson(reader, listType);
            return driversCarList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
