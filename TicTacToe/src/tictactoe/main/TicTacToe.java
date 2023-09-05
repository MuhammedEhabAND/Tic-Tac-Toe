/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.main;

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



/**
 *
 * @author Mohammed
 */
public class TicTacToe extends Application implements EventHandler<ActionEvent> {
    private Stage stage;
    private Login login;
    private Register register;
    private PlayOffline playOff;
    private GameBoard game;
    private PlayOnline playOn;
    private Scene loginScene; // Store the Scene for the login screen
    private Scene registerScene; // Store the Scene for the login screen
    private Scene playOffScene; // Store the Scene for the login screen
    private Scene gameScene; // Store the Scene for the login screen


    private Scene playOnScene; // Store the Scene for the login screen

    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        login = new Login();
        register = new Register();
        playOff = new PlayOffline();


        playOn=new PlayOnline();

        game = new GameBoard();
        
        login.getLoginBtn().setOnAction(this);
        login.getRegisterBtn().setOnAction(this);
        login.getPlayOfflineBtn().setOnAction(this);


       register.getSignUpBtn().setOnAction(this);

        register.getAlreadyHaveAccBtn().setOnAction(this);
        register.getPlayOfflineBtn().setOnAction(this);
        playOff.getTwoPlayerBtn().setOnAction(this);
        
        stage.setResizable(false);
        loginScene = new Scene(login); // Create the Scene for the login screen
        registerScene = new Scene(register); // Create the Scene for the login screen

        playOffScene = new Scene(playOff); // Create the Scene for the login screen
        playOnScene = new Scene(playOn); // Create the Scene for the login screen

        gameScene = new Scene(game); // Create the Scene for the login screen
        
        stage.setScene(loginScene); // Set the initial scene
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == playOff.getTwoPlayerBtn()) {
            stage.setScene(gameScene);
        }
        if (event.getSource() == login.getRegisterBtn()) {
            System.out.print("clicked");
            stage.setScene(registerScene);
        }
        if (event.getSource() == login.getPlayOfflineBtn() || event.getSource() == register.getPlayOfflineBtn()) {
            stage.setScene(playOffScene);
        }
        if (event.getSource() == register.getAlreadyHaveAccBtn()) {
            stage.setScene(loginScene); // Set the login screen Scene again
        }


          if (event.getSource() == register.getSignUpBtn()||event.getSource()==login.getLoginBtn()) {
            stage.setScene(playOnScene); // Set the login screen Scene again
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}

