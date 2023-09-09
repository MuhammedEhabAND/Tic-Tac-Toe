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
import tictactoe.GameType;
import tictactoe.view.play_online.PlayOnline;

/**
 *
 * @author Mohammed
 */
public class TicTacToe extends Application implements EventHandler<ActionEvent> {
    private Stage stage;
    private Login login;
    private Register register;
    private PlayOffline playOff;
    private PlayOnline playOn;
    private Scene loginScene; // Store the Scene for the login screen
    private Scene registerScene; // Store the Scene for the login screen
    private Scene playOffScene; // Store the Scene for the login screen
    private Scene twoPlayersGameScene; // Store the Scene for the login screen
    private Scene easyGameScene;
    private Scene mediumGameScene;
    private Scene hardGameScene;
    
    private Scene playOnScene; // Store the Scene for the login screen
    
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    
    @Override
    public void start(Stage stage) throws Exception {
        
        try {
            mySocket = new Socket("127.0.0.1", 5007);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
            
            // Login
            ps.println("0");
            ps.println("userName32");
            ps.println("password2");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        String myUserName = "userName32";
        
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    if (dis.readLine().equals("-1")) {
                        // Server Stopped
                        System.out.println("Server Stopped");
                    } else {
                        // Server is Running
                        System.out.println("Server is Running");
                        String remoteUserName = dis.readLine();
                        if (remoteUserName.equals(myUserName)) {
                            // Server returned to this user
                            String message = dis.readLine();
                            if(message.equals("0")) {
                                // Log In Return
                                if (dis.readLine().equals("0")) {
                                    // Wrong userName or password
                                    System.out.println("Wrong userName or password");
                                } else {
                                    // Log In Complete
                                    System.out.println("Log in complete");
                                }
                        
                            } else if (message.equals("1")) {
                                // Sign Up Return
                                if (dis.readLine().equals("0")) {
                                    // Sign Up Failed
                                    System.out.println("Signup Failed");
                                } else {
                                    // Sign Up Complete
                                    System.out.println("Signup complete");
                                }
                            }
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        thread.start();
        
        this.stage = stage;
        login = new Login();
        register = new Register();
        playOff = new PlayOffline(stage);

        playOn = new PlayOnline();
        
        login.getLoginBtn().setOnAction(this);
        login.getRegisterBtn().setOnAction(this);
        login.getPlayOfflineBtn().setOnAction(this);


        register.getSignUpBtn().setOnAction(this);

        register.getAlreadyHaveAccBtn().setOnAction(this);
        register.getPlayOfflineBtn().setOnAction(this);
        playOff.getTwoPlayerBtn().setOnAction(this);
        
        stage.setResizable(false);
        loginScene = new Scene(login); // Create the Scene for the login screen
        registerScene = new Scene(register);

        playOffScene = new Scene(playOff);
        playOnScene = new Scene(playOn);

        stage.setScene(loginScene); // Set the initial scene
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        
        
        if (event.getSource() == login.getRegisterBtn()) {
            stage.setScene(registerScene);
        }
        if (event.getSource() == login.getPlayOfflineBtn() || event.getSource() == register.getPlayOfflineBtn()) {
            stage.setScene(playOffScene);
        }
        if (event.getSource() == register.getAlreadyHaveAccBtn()) {
            stage.setScene(loginScene); // Set the login screen Scene again
        }

        if (event.getSource() == register.getSignUpBtn() || event.getSource() == login.getLoginBtn()) {
            stage.setScene(playOnScene); // Set the login screen Scene again
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

