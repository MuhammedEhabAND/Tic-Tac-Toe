package tictactoe.presenter.auth.server;

import tictactoe.utils.Validation;

public interface NetworkResponse {
    void onSuccess(Validation validation);

    void onError(String errorMessage);
}
