package tictactoe.presenter.auth_validation;

public interface AuthInputValidator {
    Boolean passwordValidator(String password);
    Boolean usernameValidator(String userName);
}
