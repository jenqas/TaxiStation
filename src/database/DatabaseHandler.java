package database;

import cars.CompanyCar;

import java.sql.*;

public class DatabaseHandler extends Configs {

    static Connection dbConnection;

    public static Connection getDbConnection()
            throws ClassNotFoundException,SQLException {

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort  + "/" + dbName;

//        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;

    }

    //Write db
    public static void addToDBCompanyCar(CompanyCar car){

        String insert = "INSERT INTO " + Const.CARS_TABLE +"(" +
                Const.CARS_BRAND + "," + Const.CARS_MODEL + "," +
                Const.CARS_YEAR + "," + Const.CARS_FUEL_CONSUMPTION + "," +
                Const.CARS_CATEGORY + "," + Const.CARS_PRICE + ")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, car.getBrand());
            prSt.setString(2, car.getModel());
            prSt.setInt(3, car.getYear());
            prSt.setDouble(4, car.getFuelConsumption());
            prSt.setString(5, car.getCategory().name());
            prSt.setDouble(6, car.getPrice());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //Read db and print fetching data
    public static void printDatabaseTableCompanyCars(){
        try {
            Statement stmt = getDbConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + Const.CARS_TABLE);

            System.out.println("Reading DB Table Company Cars and printing result:\n---------------------------");

            while(rs.next()) {
                String brand = rs.getString(Const.CARS_BRAND) ;
                System.out.println(rs.getString(Const.CARS_BRAND) + " " + rs.getString(Const.CARS_MODEL) + ", " +
                        rs.getString(Const.CARS_YEAR) + ", Fuel Cons.= " + rs.getString(Const.CARS_FUEL_CONSUMPTION) + ", " +
                        rs.getString(Const.CARS_PRICE) + "$");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // clearing db table
    public static void clearDBCompanyCarsTable(){
        try {
            Statement stmt = getDbConnection().createStatement();

            stmt.executeUpdate("DELETE FROM " + Const.CARS_TABLE + " WHERE carid>0" );

            System.out.println("\nClearing MySQL DB Table...");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
