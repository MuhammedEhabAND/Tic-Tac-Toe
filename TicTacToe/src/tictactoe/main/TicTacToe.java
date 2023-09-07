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
import tictactoe.view.game_board.GameBoard;
import tictactoe.view.login.play_offline.PlayOffline;
import tictactoe.view.register.Register;
import tictactoe.view.login.Login;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import tictactoe.view.play_online.PlayOnline;
public class TicTacToe extends Application {
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    @Override
    public void start(Stage stage) {

        stage.setResizable(false);
        stage.show();
        try {
            mySocket = new  Socket(Constants.HOST, Constants.PORT);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
           new Login(stage,ps,dis);
           new Register(stage, ps, dis);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}

