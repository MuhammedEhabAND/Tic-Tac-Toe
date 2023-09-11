package tictactoe.view.login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.model.User;
import tictactoe.presenter.auth_validation.AuthInputValidator;
import tictactoe.presenter.auth_validation.AuthInputValidatorImpl;
import tictactoe.presenter.auth_validation.Authentication;
import tictactoe.presenter.auth_validation.AuthenticationImpl;
import tictactoe.presenter.auth_server.NetworkResponse;
import tictactoe.presenter.auth_server.NetworkListener;
import tictactoe.utils.Constants;
import tictactoe.utils.Validation;
import tictactoe.view.play_offline.PlayOffline;
import tictactoe.view.play_online.PlayOnline;
import tictactoe.view.register.Register;

import java.io.DataInputStream;
import java.io.PrintStream;
import javafx.scene.image.Image;

public class Login extends BorderPane implements EventHandler<ActionEvent> {
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane0;
    protected final TextField nameTextField;
    protected final TextField passwordTextField;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Button loginBtn;
    protected final Button registerBtn;

    private final Stage stage;
    private PlayOnline playOn;
    protected final Button playOfflineBtn;
    DataInputStream dataInputStream;
    PrintStream outStream;


    private void init() {
        stage.setScene(new Scene(this));
        loginBtn.setOnAction(this);
        registerBtn.setOnAction(this);
        playOfflineBtn.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == loginBtn) {
            playOn = new PlayOnline(stage);
            signIn();
        } else if (event.getSource() == registerBtn) {
            stage.setScene(new Register(stage, outStream, dataInputStream).getScene());
        } else if (event.getSource() == playOfflineBtn) {
            stage.setScene(new PlayOffline(stage).getScene());
        }
    }

    void signIn() {
        String password = passwordTextField.getText();
        String userName = nameTextField.getText();
        AuthInputValidator authInputValidator = new AuthInputValidatorImpl();
        Authentication authentication = new AuthenticationImpl(authInputValidator);
        Validation validation = authentication.login(new User(userName, password));
        if (validation.isValid()) {
            new Thread(
                    new NetworkListener(
                            true,
                            dataInputStream,
                            new User(userName, password),
                            Constants.LOGIN,
                            outStream,
                            new NetworkResponse() {
                                @Override
                                public void onSuccess(Validation validation) {
                                    Platform.runLater(() ->
                                            stage.setScene(new PlayOnline(stage).getScene()));
                                }

                                @Override
                                public void onError(String errorMessage) {
                                    System.out.println(errorMessage);

                                }
                            }
                    )
            ) .start();
        }else {
            System.out.println(validation.getMessage());
        }




    }


    public Login(Stage stage, PrintStream outStream, DataInputStream dataInputStream) {
        this.stage = stage;
        this.outStream = outStream;
        this.dataInputStream = dataInputStream;
        anchorPane = new AnchorPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        imageView = new ImageView();
        anchorPane0 = new AnchorPane();
        nameTextField = new TextField();
        passwordTextField = new TextField();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        loginBtn = new Button();
        registerBtn = new Button();
        playOfflineBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(500.0);
        anchorPane.setPrefWidth(250.0);
        anchorPane.setStyle("-fx-background-color: #1978ae;");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(12.0);
        label.setLayoutY(21.0);
        label.setPrefHeight(60.0);
        label.setPrefWidth(227.0);
        label.setText("Tic");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setTextOverrun(javafx.scene.control.OverrunStyle.LEADING_WORD_ELLIPSIS);
        label.setFont(new Font("SansSerif Bold Italic", 40.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(12.0);
        label0.setLayoutY(304.0);
        label0.setPrefHeight(60.0);
        label0.setPrefWidth(227.0);
        label0.setText("Tac");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setTextOverrun(javafx.scene.control.OverrunStyle.LEADING_WORD_ELLIPSIS);
        label0.setFont(new Font("SansSerif Bold Italic", 40.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setLayoutX(12.0);
        label1.setLayoutY(388.0);
        label1.setPrefHeight(60.0);
        label1.setPrefWidth(227.0);
        label1.setText("Toe");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setTextOverrun(javafx.scene.control.OverrunStyle.LEADING_WORD_ELLIPSIS);
        label1.setFont(new Font("SansSerif Bold Italic", 40.0));

        imageView.setFitHeight(180.0);
        imageView.setFitWidth(202.0);
        imageView.setLayoutX(24.0);
        imageView.setLayoutY(91.0);
        setLeft(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(500.0);
        anchorPane0.setPrefWidth(493.0);

        nameTextField.setLayoutX(88.0);
        nameTextField.setLayoutY(176.0);
        nameTextField.setPrefHeight(31.0);
        nameTextField.setPrefWidth(339.0);
        nameTextField.setPromptText("Enter your name");
        nameTextField.setStyle("-fx-background-color: transparent; -fx-border-color: #1978ae; -fx-border-width: 0px 0px 2px 0px;");

        passwordTextField.setLayoutX(89.0);
        passwordTextField.setLayoutY(228.0);
        passwordTextField.setPrefHeight(31.0);
        passwordTextField.setPrefWidth(340.0);
        passwordTextField.setPromptText("Enter your password ");
        passwordTextField.setStyle("-fx-background-color: transparent; -fx-border-color: #1978ae; -fx-border-width: 0px 0px 2px 0px;");

        label2.setLayoutX(14.0);
        label2.setLayoutY(177.0);
        label2.setPrefHeight(30.0);
        label2.setPrefWidth(56.0);
        label2.setText("Name");
        label2.setFont(new Font("SansSerif Italic", 15.0));

        label3.setLayoutX(14.0);
        label3.setLayoutY(230.0);
        label3.setPrefHeight(30.0);
        label3.setPrefWidth(76.0);
        label3.setText("Password");
        label3.setFont(new Font("SansSerif Italic", 15.0));

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setLayoutX(19.0);
        label4.setLayoutY(67.0);
        label4.setPrefHeight(73.0);
        label4.setPrefWidth(409.0);
        label4.setText("Welcome");
        label4.setFont(new Font("SansSerif Bold Italic", 59.0));

        loginBtn.setLayoutX(15.0);
        loginBtn.setLayoutY(295.0);
        loginBtn.setMnemonicParsing(false);

        loginBtn.setPrefHeight(55.0);
        loginBtn.setPrefWidth(416.0);
        loginBtn.setStyle("-fx-background-color: #1978ae;");
        loginBtn.setText("Login");
        loginBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        loginBtn.setFont(new Font("System Bold", 20.0));

        registerBtn.setLayoutX(15.0);
        registerBtn.setLayoutY(360.0);
        registerBtn.setMnemonicParsing(false);
        registerBtn.setPrefHeight(55.0);
        registerBtn.setPrefWidth(416.0);
        registerBtn.setStyle("-fx-background-color: WHITE; -fx-border-color: #33cccc;");
        registerBtn.setText("Register");
        registerBtn.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        registerBtn.setFont(new Font("SansSerif Bold", 20.0));

        playOfflineBtn.setLayoutX(16.0);
        playOfflineBtn.setLayoutY(423.0);
        playOfflineBtn.setMnemonicParsing(false);
        playOfflineBtn.setPrefHeight(55.0);
        playOfflineBtn.setPrefWidth(416.0);
        playOfflineBtn.setStyle("-fx-background-color: WHITE; -fx-border-color: #33cccc;");
        playOfflineBtn.setText("Play Offline");
        playOfflineBtn.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        playOfflineBtn.setFont(new Font("SansSerif Bold", 20.0));
        setRight(anchorPane0);

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(imageView);
        anchorPane0.getChildren().add(nameTextField);
        anchorPane0.getChildren().add(passwordTextField);
        anchorPane0.getChildren().add(label2);
        anchorPane0.getChildren().add(label3);
        anchorPane0.getChildren().add(label4);
        anchorPane0.getChildren().add(loginBtn);
        anchorPane0.getChildren().add(registerBtn);
        anchorPane0.getChildren().add(playOfflineBtn);
               imageView.setImage(new Image(getClass().getResource("/tictactoe/resources/Logo.gif").toExternalForm()));

        
        
        init();
    }


}
