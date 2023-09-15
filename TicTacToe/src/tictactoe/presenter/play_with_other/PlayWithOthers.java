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

public class PlayWithOthers implements Runnable {

    private final DataInputStream dataInputStream;
    private final String myUserName;
    private final ServerResponse callback;
    private final PrintStream printStream;
    private final String type;
    private final String opUserName;
    String result = "";

    public PlayWithOthers(DataInputStream dataInputStream, String user,
            String type, PrintStream printStream, ServerResponse callback, String opUserName) {

        this.dataInputStream = dataInputStream;
        this.myUserName = user;
        this.callback = callback;
        this.printStream = printStream;
        this.type = type;
        this.opUserName = opUserName;

    }

    void sendRequestToPlay() {
        printStream.println(myUserName);
        printStream.println(opUserName);
        callback.onSuccess();
    }

    @Override
    public void run() {
        try {
            printStream.println(type);
            if (dataInputStream.readLine().equals(Constants.SERVER_STOP)) {
                System.out.println("Server Stopped");
            } else {
                System.out.println("Server is Running");
                sendRequestToPlay();
            }

        } catch (IOException ex) {
            callback.onError(ex.getMessage());
        }
    }

}
