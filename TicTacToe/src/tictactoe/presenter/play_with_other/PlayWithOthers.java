/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.play_with_other;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import tictactoe.model.User;
import tictactoe.presenter.retrieve_online_users.ServerResponse;
import tictactoe.utils.Constants;

/**
 *
 * @author Mohammed
 */
public class PlayWithOthers implements Runnable {
    private final DataInputStream dataInputStream;
    private final User user;
    private final ServerResponse callback;
    private final PrintStream printStream;
    private final String type;
    private final String opUserName;
    boolean state =true;

    public PlayWithOthers( boolean state,DataInputStream dataInputStream, User user,
                           String type, PrintStream printStream, ServerResponse callback , String opUserName ) {

        this.dataInputStream = dataInputStream;
        this.user = user;
        this.callback = callback;
        this.printStream = printStream;
        this.type = type;
        this.state=state;
        this.opUserName = opUserName;
        
        
    }

 
    @Override
    public void run() {
        try {
            while (state) {
            printStream.println(type);
            printStream.println(user.getUserName());
            printStream.println(opUserName);

            if (dataInputStream.readLine().equals(Constants.SERVER_STOP)) {
                        // Server Stopped
                        System.out.println("Server Stopped");
                    } else {
                        // Server is Running
                        System.out.println("Server is Running");
                        String remoteUserName = dataInputStream.readLine();
                        if (remoteUserName.equals(user.getUserName())) {
                            // Server returned to this user
                            
                            String message = dataInputStream.readLine();
                         
                            if(message.equals(Constants.PLAY_WITH_USER)) {
                                // username 2
                                // Get Response from dialog
                                String userResponse = Constants.USER_REJECTED;
                                printStream.println(Constants.PLAY_WITH_USER_RESPONSE);
                                printStream.println(user.getUserName());
                                printStream.println(userResponse);
                            
                            } else if (message.equals(Constants.PLAY_WITH_USER_RESPONSE)) {
                                // username 1
                                String userResponse = dataInputStream.readLine();
                                if (userResponse.equals(Constants.USER_ACCEPTED)) {
                                    System.out.println("User Accepted");
                                } else {
                                    System.out.println("User Rejected");
                                }
                            }
                        }
                    }
            }
        }  catch (IOException ex) {
            callback.onError(ex.getMessage());
        }
    }
    
}







