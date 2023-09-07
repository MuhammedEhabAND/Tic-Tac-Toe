package tictactoe.presenter.auth.validation;

public interface AuthInputValidator {
    Boolean passwordValidator(String password);
    Boolean usernameValidator(String userName);
}
