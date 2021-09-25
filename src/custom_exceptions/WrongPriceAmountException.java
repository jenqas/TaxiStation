package custom_exceptions;

public class WrongPriceAmountException extends Exception {

    // Car Price value is incorrect (price < 1000 || price > 100000) -> class CompanyCar
    public WrongPriceAmountException(String description) {
        super(description);
    }

}
