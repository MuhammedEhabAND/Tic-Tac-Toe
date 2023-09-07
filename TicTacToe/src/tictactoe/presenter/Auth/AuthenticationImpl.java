package tictactoe.presenter.Auth;

import tictactoe.model.User;
import tictactoe.utils.Constants;
import tictactoe.utils.Validation;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AuthenticationImpl implements Authentication {
  //  AuthInputValidator authInputValidator;
  AuthInputValidatorImpl authInputValidatorImp=new AuthInputValidatorImpl();
    @Override
    public Validation login(User user) {
        if(!authInputValidatorImp.usernameValidator(user.getUserName())){
           return new Validation(false,"Username not valid");
        }else if (!authInputValidatorImp.passwordValidator(user.getPassword())) {
            return new Validation(false,"Password not valid");
        }
        return new Validation(true,"");
    }

    @Override
    public Validation signUp(User user, String confirmPassword) {
        if(!authInputValidatorImp.usernameValidator(user.getUserName())){
            return new Validation(false,"Username not valid");
        }else if (!authInputValidatorImp.passwordValidator(user.getPassword())) {
            return new Validation(true,"Password not valid");
        } else if (!Objects.equals(user.getPassword(), confirmPassword)) {
            return new Validation(false,"Password not Equal");
        }
        return new Validation(true,"");
    }

    public CompletableFuture<Validation> serverCheck(
            PrintStream outStream,
            DataInputStream dataInputStream, User user,
            String  type) {
        CompletableFuture<Validation> future = new CompletableFuture<>();

            try {
                outStream.println(type);
                outStream.println(user.getUserName());
                outStream.println(user.getPassword());
            } catch (Exception ignored) {
            }
            try {

                new Thread(() -> {
                    Validation validation = null;
                    while (true) {
                        try {
                            if (dataInputStream.readLine().equals(Constants.SERVER_STOP)) {
                                validation = new Validation(false, "NetWork Error");
                            } else {
                                validation = new Validation(false, "NetWork Good");
                                String remoteUserName = dataInputStream.readLine();
                                if (remoteUserName.equals(user.getUserName())) {
                                    String message = dataInputStream.readLine();

                                    if (message.equals(Constants.LOGIN)) {
                                        if (dataInputStream.readLine().equals(Constants.NotValidPasswordAndUseName)) {
                                            validation = new Validation(false, "Login Failed");
                                        } else {
                                            validation = new Validation(true, "Login complete");
                                        }
                                    } else if (message.equals(Constants.REGISTER)) {
                                        String registerState =dataInputStream.readLine();
                                        if (registerState.equals(Constants.NotValid_REGISTER)) {
                                            validation = new Validation(false, "Signup Failed");
                                            System.out.println("Signup Failed");
                                        } else if(registerState.equals(Constants.Valid_REGISTER)) {
                                            validation = new Validation(true, "Signup complete");
                                            System.out.println("Signup complete");

                                        }
                                    }
                                }
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } finally {
                            // Complete the CompletableFuture with the result
                            future.complete(validation);
                        }
                    }
                }).start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        return future;
    }
}
