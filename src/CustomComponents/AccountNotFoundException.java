package CustomComponents;

public class AccountNotFoundException extends CustomException {
    public AccountNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}