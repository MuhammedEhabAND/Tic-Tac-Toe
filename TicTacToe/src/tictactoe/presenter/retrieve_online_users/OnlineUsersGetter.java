/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.retrieve_online_users;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import tictactoe.model.User;
import tictactoe.presenter.auth_server.NetworkResponse;
import tictactoe.utils.Constants;
import tictactoe.utils.Validation;

/**
 *
 * @author Mohammed
 */

public class OnlineUsersGetter implements Runnable {
    private final DataInputStream dataInputStream;
    private final User user;
    private final ServerResponse callback;
    private final PrintStream printStream;
    private final String type;
    private ArrayList<String> onlineUsers = new ArrayList<String>();
    boolean state =true;

    public OnlineUsersGetter( boolean state,DataInputStream dataInputStream, User user,
                           String type, PrintStream printStream, ServerResponse callback , ArrayList<String> onlineUsers) {

        this.dataInputStream = dataInputStream;
        this.user = user;
        this.callback = callback;
        this.printStream = printStream;
        this.type = type;
        this.state=state;
        this.onlineUsers = onlineUsers;
        
        
    }

 
    @Override
    public void run() {
        try {
            
            printStream.println(type);
                if (dataInputStream.readLine().equals(Constants.SERVER_STOP)) {
                        // Server Stopped
                        System.out.println("Server Stopped");
                    } else {
                                printStream.println(user.getUserName());

                        // Server is Running
                        System.out.println("Server is Running");
                        String remoteUserName = dataInputStream.readLine();
                        if (remoteUserName.equals(user.getUserName())) {
                            // Server returned to this user
                            
                            String message = dataInputStream.readLine();
                            if(message.equals(type)) {
                                String serverResponse = dataInputStream.readLine();
                                System.out.println("server res :" +serverResponse);
                                
                                
                                int noOfUsers = Integer.parseInt(serverResponse);
                                 
                                for (int i = 0; i < noOfUsers; i++) {
      
                                    String userName = dataInputStream.readLine();
                                    onlineUsers.add(userName);
                                    System.out.println("userName: " + userName);
                                }
                                
                                if(onlineUsers.equals(null)){
                                callback.onError("Empty list of online users");
                                }else{
                                
                                callback.onSuccess();
                                }
                            }
                        }
                    }
                
            
        } catch (IOException ex) {
            callback.onError(ex.getMessage());
        }
    }
    
}





