package tictactoe.presenter.auth_validation;

import tictactoe.model.User;
import tictactoe.utils.Validation;

public interface Authentication {
    Validation login(User user);
    Validation signUp(User user,String ConfirmPassword);

}
