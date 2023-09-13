/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.play_with_other;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import tictactoe.presenter.retrieve_online_users.ServerResponse;
import tictactoe.utils.Constants;

/**
 *
 * @author Mohammed
 */
public class PlayWithOthers implements Runnable {
    private final DataInputStream dataInputStream;
    private final String user;
    private final ServerResponse callback;
    private final PrintStream printStream;
    private final String type;
    private  String opUserName;
   

    public PlayWithOthers( DataInputStream dataInputStream, String user,
                           String type, PrintStream printStream, ServerResponse callback , String opUserName ) {

        this.dataInputStream = dataInputStream;
        this.user = user;
        this.callback = callback;
        this.printStream = printStream;
        this.type = type;
        this.opUserName = opUserName;
        
        
    }

 
    @Override
    public void run() {
        try {
            printStream.println(type);
          
            if (dataInputStream.readLine().equals(Constants.SERVER_STOP)) {
                        // Server Stopped
                        System.out.println("Server Stopped");
                    } else {
                        // Server is Running
                        System.out.println("Server is Running");
                          printStream.println(user);
                          printStream.println(opUserName);

                        String remoteUserName = dataInputStream.readLine();
                        if (remoteUserName.equals(user)) {
                            // Server returned to this user
                            System.out.println("here we are");
                           opUserName = dataInputStream.readLine();

                            String message = dataInputStream.readLine();

                            if(message.equals(Constants.SEBD_REQUEST_TO_PLAY)) {
                                // username 2
                                // Get Response from dialog
                                String userResponse = Constants.USER_REJECTED;
                                printStream.println(Constants.PLAY_WITH_USER_RESPONSE);
                                printStream.println(opUserName);
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
                        }else{
                            System.out.println("We are here");
                        }
                    }
            
        }  catch (IOException ex) {
            callback.onError(ex.getMessage());
        }
    }
    
}







