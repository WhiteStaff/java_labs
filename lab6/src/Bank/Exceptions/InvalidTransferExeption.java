package Bank.Exceptions;

public class InvalidTransferExeption extends RuntimeException {
    public InvalidTransferExeption(String message) {
        super(message);
    }
}
