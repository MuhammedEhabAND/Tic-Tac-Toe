package tictactoe.presenter.auth_server;

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
    boolean state =true;

    public NetworkListener( boolean state,DataInputStream dataInputStream, User user,
                           String type, PrintStream printStream, NetworkResponse callback) {

        this.dataInputStream = dataInputStream;
        this.user = user;
        this.callback = callback;
        this.printStream = printStream;
        this.type = type;
        this.state=state;
    }

    @Override
    public void run() {
        try {
            while (state) {
                printStream.println(type);
                String response = dataInputStream.readLine();
                System.out.println(response);

                if (response.equals(Constants.SERVER_STOP)) {
                    callback.onError("Network Error");
                    state =false;

                } else {

                    printStream.println(user.getUserName());
                    printStream.println(user.getPassword());
                    String remoteUserName = dataInputStream.readLine();
                    System.out.println(remoteUserName);

                    if (remoteUserName.equals(user.getUserName())) {
                        String loginOrRegister = dataInputStream.readLine();
                        System.out.println(loginOrRegister);
                        if (loginOrRegister.equals(Constants.LOGIN)) {
                            String loginState = dataInputStream.readLine();
                            System.out.println(loginState);
                            if (loginState.equals(Constants.NOT_VALID_LOGIN)) {

                                callback.onError("Login Failed");
                            } else if(loginState.equals(Constants.VALID_LOGIN)){
                                callback.onSuccess(new Validation(true, "Login complete"));
                            }
                            state =false;
                        } else if (loginOrRegister.equals(Constants.REGISTER)) {
                            String registerState = dataInputStream.readLine();
                            System.out.println(registerState);
                            if (registerState.equals(Constants.NOT_VALID_REGISTER)) {
                                callback.onError("Signup Failed");
                            } else if (registerState.equals(Constants.VALID_REGISTER)) {
                                callback.onSuccess(new Validation(true, "Signup complete"));


                            }
                            state =false;
                        }
                    }
                }
            }
        } catch (IOException ex) {
            callback.onError(ex.getMessage());
        }
    }
}



