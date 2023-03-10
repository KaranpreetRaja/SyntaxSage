package CustomComponents;

import java.lang.Exception.*;

public class CustomException extends Exception {
    public CustomException(String errorMessage) {
        super(errorMessage);
    }
}

public class AccountNotFoundException extends CustomException {
    public AccountNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

class AccountSignUpException extends CustomException {
    public AccountSignUpException(String errorMessage) {
        super(errorMessage);
    }
}

class AccountUsernameException extends CustomException {
    public AccountUsernameException(String errorMessage) {
        super(errorMessage);
    }
}