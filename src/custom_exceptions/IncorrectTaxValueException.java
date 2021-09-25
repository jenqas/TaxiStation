package custom_exceptions;

public class IncorrectTaxValueException extends Exception{

    // Percentage taxForEachOrder can't be <1% or >99%
    // TaxiStation Tax for Drivers with own cars should have less amount than for drivers, that use company cars
    public IncorrectTaxValueException(String description) {
        super(description);
    }

}
