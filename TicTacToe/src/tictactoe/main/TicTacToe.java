/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import tictactoe.utils.Constants;
import tictactoe.view.register.Register;
import tictactoe.view.login.Login;
import javafx.application.Application;
import javafx.stage.Stage;
import tictactoe.view.play_offline.PlayOffline;
import tictactoe.view.play_online.PlayOnline;
public class TicTacToe extends Application {
    private Stage stage;
    private Login login;
    private Register register;
    private PlayOnline playOn;
    Socket mySocket;
    DataInputStream dataInputStream;
    PrintStream printStream;
   PlayOffline  playOff;

    @Override
    public void start(Stage stage) {

        stage.setResizable(false);
        stage.show();
        try {
            mySocket = new  Socket(Constants.HOST, Constants.PORT);
            dataInputStream = new DataInputStream(mySocket.getInputStream());
            printStream = new PrintStream(mySocket.getOutputStream());

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }finally {
            new Login(stage, printStream, dataInputStream);
            new Register(stage, printStream, dataInputStream);
        }
         this.stage = stage;
        playOff = new PlayOffline(stage);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

