package tictactoe.presenter.auth.server;

import tictactoe.model.User;
import tictactoe.utils.Constants;
import tictactoe.utils.Validation;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;


public class NetworkListener implements Runnable {
    private final DataInputStream dataInputStream;
    private final User user;
    private final NetworkResponse callback;
    private final PrintStream printStream;
    private final String type;

    public NetworkListener(DataInputStream dataInputStream, User user,
                           String type, PrintStream printStream, NetworkResponse callback) {

        this.dataInputStream = dataInputStream;
        this.user = user;
        this.callback = callback;
        this.printStream = printStream;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String response = dataInputStream.readLine();
                if (response.equals(Constants.SERVER_STOP)) {
                    callback.onError("Network Error");
                } else {
                    printStream.println(type);
                    printStream.println(user.getUserName());
                    printStream.println(user.getPassword());
                    String remoteUserName = dataInputStream.readLine();

                    if (remoteUserName.equals(user.getUserName())) {
                        String loginOrRegister = dataInputStream.readLine();
                        if (loginOrRegister.equals(Constants.LOGIN)) {
                            String loginState = dataInputStream.readLine();
                            if (loginState.equals(Constants.NotValidPasswordAndUseName)) {

                                callback.onError("Login Failed");
                            } else {
                                callback.onSuccess(new Validation(true, "Login complete"));
                            }
                        } else if (loginOrRegister.equals(Constants.REGISTER)) {
                            String registerState = dataInputStream.readLine();
                            if (registerState.equals(Constants.NotValid_REGISTER)) {
                                callback.onError("Signup Failed");
                            } else if (registerState.equals(Constants.Valid_REGISTER)) {
                                callback.onSuccess(new Validation(true, "Signup complete"));


                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            callback.onError(ex.getMessage());
        }
    }
}



