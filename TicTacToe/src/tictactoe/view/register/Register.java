package tictactoe.view.register;

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
import tictactoe.view.login.Login;
import tictactoe.view.play_offline.PlayOffline;
import tictactoe.view.play_online.PlayOnline;

import java.io.DataInputStream;
import java.io.PrintStream;

public class Register extends BorderPane implements EventHandler<ActionEvent> {

    protected final AnchorPane anchorPane;
    protected final TextField nameTF;
    protected final TextField passwordTF;
    protected final Label label;


    protected final Label label0;
    protected final Label label1;
    protected final Button alreadyHaveAccBtn;
    protected final Button signUpBtn;
    protected final Button playOfflineBtn;
    protected final TextField confirmPasswordTF;
    protected final Label label2;
    protected final AnchorPane anchorPane0;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final ImageView imageView;
    private Stage stage;
    private PlayOnline playOn;
    DataInputStream dataInputStream;
    PrintStream outStream;

    public Register(Stage stage, PrintStream outStream, DataInputStream dataInputStream) {
        this.stage = stage;
        this.outStream = outStream;
        this.dataInputStream = dataInputStream;
        anchorPane = new AnchorPane();
        nameTF = new TextField();
        passwordTF = new TextField();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        alreadyHaveAccBtn = new Button();
        signUpBtn = new Button();
        playOfflineBtn = new Button();
        confirmPasswordTF = new TextField();
        label2 = new Label();
        anchorPane0 = new AnchorPane();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(500.0);
        anchorPane.setPrefWidth(493.0);

        nameTF.setLayoutX(145.0);
        nameTF.setLayoutY(154.0);
        nameTF.setPrefHeight(33.0);
        nameTF.setPrefWidth(286.0);
        nameTF.setPromptText("Enter your name");
        nameTF.setStyle("-fx-background-color: transparent; -fx-border-color: #1978ae; -fx-border-width: 0px 0px 2px 0px;");

        passwordTF.setLayoutX(148.0);
        passwordTF.setLayoutY(196.0);
        passwordTF.setPrefHeight(33.0);
        passwordTF.setPrefWidth(284.0);
        passwordTF.setPromptText("Enter your password ");
        passwordTF.setStyle("-fx-background-color: transparent; -fx-border-color: #1978ae; -fx-border-width: 0px 0px 2px 0px;");

        label.setLayoutX(15.0);
        label.setLayoutY(155.0);
        label.setPrefHeight(30.0);
        label.setPrefWidth(56.0);
        label.setText("Name");
        label.setFont(new Font("SansSerif Italic", 15.0));

        label0.setLayoutX(14.0);
        label0.setLayoutY(197.0);
        label0.setPrefHeight(30.0);
        label0.setPrefWidth(76.0);
        label0.setText("Password");
        label0.setFont(new Font("SansSerif Italic", 15.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setLayoutX(19.0);
        label1.setLayoutY(52.0);
        label1.setPrefHeight(73.0);
        label1.setPrefWidth(409.0);
        label1.setText("Welcome");
        label1.setFont(new Font("SansSerif Bold Italic", 59.0));

        alreadyHaveAccBtn.setLayoutX(15.0);
        alreadyHaveAccBtn.setLayoutY(353.0);
        alreadyHaveAccBtn.setMnemonicParsing(false);
        alreadyHaveAccBtn.setPrefHeight(55.0);
        alreadyHaveAccBtn.setPrefWidth(416.0);
        alreadyHaveAccBtn.setStyle("-fx-background-color: WHITE; -fx-border-color: #33cccc;");
        alreadyHaveAccBtn.setText("Already have an account");
        alreadyHaveAccBtn.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        alreadyHaveAccBtn.setFont(new Font("System Bold", 20.0));

        signUpBtn.setLayoutX(15.0);
        signUpBtn.setLayoutY(289.0);
        signUpBtn.setMnemonicParsing(false);
        signUpBtn.setPrefHeight(55.0);
        signUpBtn.setPrefWidth(416.0);
        signUpBtn.setStyle("-fx-background-color: #1978ae;");
        signUpBtn.setText("Sign Up");
        signUpBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        signUpBtn.setFont(new Font("SansSerif Bold", 20.0));

        playOfflineBtn.setLayoutX(15.0);
        playOfflineBtn.setLayoutY(419.0);
        playOfflineBtn.setMnemonicParsing(false);
        playOfflineBtn.setPrefHeight(55.0);
        playOfflineBtn.setPrefWidth(416.0);
        playOfflineBtn.setStyle("-fx-background-color: WHITE; -fx-border-color: #33cccc;");
        playOfflineBtn.setText("Play Offline");
        playOfflineBtn.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        playOfflineBtn.setFont(new Font("SansSerif Bold", 20.0));

        confirmPasswordTF.setLayoutX(148.0);
        confirmPasswordTF.setLayoutY(236.0);
        confirmPasswordTF.setPrefHeight(33.0);
        confirmPasswordTF.setPrefWidth(284.0);
        confirmPasswordTF.setPromptText("Confirm password");
        confirmPasswordTF.setStyle("-fx-background-color: transparent; -fx-border-color: #1978ae; -fx-border-width: 0px 0px 2px 0px;");

        label2.setLayoutX(14.0);
        label2.setLayoutY(237.0);
        label2.setPrefHeight(30.0);
        label2.setPrefWidth(127.0);
        label2.setText("Confirm Password");
        label2.setFont(new Font("SansSerif Italic", 15.0));
        setLeft(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(500.0);
        anchorPane0.setPrefWidth(250.0);
        anchorPane0.setStyle("-fx-background-color: #1978ae;");

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setLayoutX(14.0);
        label3.setLayoutY(14.0);
        label3.setPrefHeight(60.0);
        label3.setPrefWidth(227.0);
        label3.setText("Tic");
        label3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setTextOverrun(javafx.scene.control.OverrunStyle.LEADING_WORD_ELLIPSIS);
        label3.setFont(new Font("SansSerif Bold Italic", 40.0));

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setLayoutX(17.0);
        label4.setLayoutY(416.0);
        label4.setPrefHeight(60.0);
        label4.setPrefWidth(227.0);
        label4.setText("Tac");
        label4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label4.setTextFill(javafx.scene.paint.Color.WHITE);
        label4.setTextOverrun(javafx.scene.control.OverrunStyle.LEADING_WORD_ELLIPSIS);
        label4.setFont(new Font("SansSerif Bold Italic", 40.0));

        label5.setAlignment(javafx.geometry.Pos.CENTER);
        label5.setLayoutX(14.0);
        label5.setLayoutY(316.0);
        label5.setPrefHeight(60.0);
        label5.setPrefWidth(227.0);
        label5.setText("Toe");
        label5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label5.setTextFill(javafx.scene.paint.Color.WHITE);
        label5.setTextOverrun(javafx.scene.control.OverrunStyle.LEADING_WORD_ELLIPSIS);
        label5.setFont(new Font("SansSerif Bold Italic", 40.0));

        imageView.setFitHeight(180.0);
        imageView.setFitWidth(202.0);
        imageView.setLayoutX(24.0);
        imageView.setLayoutY(91.0);
        //   imageView.setImage(new Image(getClass().getResource("/tictactoe/resources/Logo.gif").toExternalForm()));
        setRight(anchorPane0);

        anchorPane.getChildren().add(nameTF);
        anchorPane.getChildren().add(passwordTF);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(alreadyHaveAccBtn);
        anchorPane.getChildren().add(signUpBtn);
        anchorPane.getChildren().add(playOfflineBtn);
        anchorPane.getChildren().add(confirmPasswordTF);
        anchorPane.getChildren().add(label2);
        anchorPane0.getChildren().add(label3);
        anchorPane0.getChildren().add(label4);
        anchorPane0.getChildren().add(label5);
        anchorPane0.getChildren().add(imageView);
        init();

    }

    void signUp() {
        AuthInputValidator authInputValidator = new AuthInputValidatorImpl();
        Authentication authentication = new AuthenticationImpl(authInputValidator);
        String password = passwordTF.getText();
        String userName = nameTF.getText();
        String confirmPassword = confirmPasswordTF.getText();
        Validation validation = authentication.signUp(new User(userName, password), confirmPassword);
        if (validation.isValid()) {
            new Thread(
                    new NetworkListener(
                            dataInputStream,
                            new User(userName, password),
                            Constants.REGISTER,
                            outStream,
                            new NetworkResponse() {
                                @Override
                                public void onSuccess(Validation validation) {
                                    Platform.runLater(() -> {
                                        stage.setScene(new PlayOnline(stage).getScene());
                                    });
                                }

                                @Override
                                public void onError(String errorMessage) {
                                }
                            }
                    )
            ) .start();


        } else {
            System.out.println(validation.getMessage());
        }
    }

    private void init() {
        new Scene(this);
        signUpBtn.setOnAction(this);
        alreadyHaveAccBtn.setOnAction(this);
        playOfflineBtn.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == signUpBtn) {
            playOn = new PlayOnline(stage);
            signUp();
        } else if (event.getSource() == alreadyHaveAccBtn) {
            stage.setScene( new Login(stage, outStream, dataInputStream).getScene());
        } else if (event.getSource() == playOfflineBtn) {
            stage.setScene(new PlayOffline(stage).getScene());
        }
    }

}
