package tictactoe.presenter.Auth;

public interface AuthInputValidator {
    Boolean passwordValidator(String password);
    Boolean usernameValidator(String userName);
}
