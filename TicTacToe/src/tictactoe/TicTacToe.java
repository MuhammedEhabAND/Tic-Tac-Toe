/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;


/**
 *
 * @author Mohammed
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        LoginScreen login = new LoginScreen();
        Scene loginScene = new Scene(login);
        
        RegisterScreen register = new RegisterScreen();
        Scene registerScene = new Scene(register);
        
        
        PlayOfflineScreen playOff = new PlayOfflineScreen();
        Scene playOffScene = new Scene(playOff);
        
        register.playOfflineBtn.setOnAction((event) -> {
            stage.setScene(playOffScene);
        });
        
        login.playOfflineBtn.setOnAction((event) -> {
            stage.setScene(playOffScene);
        });
        
        login.registerBtn.setOnAction((event) -> {
            stage.setScene(registerScene);
        });
        register.alreadyHaveAccBtn.setOnAction((event) -> {
            stage.setScene(loginScene);
        });
        stage.setResizable(false);
        stage.setScene(loginScene);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
