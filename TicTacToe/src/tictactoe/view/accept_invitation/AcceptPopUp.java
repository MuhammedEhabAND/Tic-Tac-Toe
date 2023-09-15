package tictactoe.view.accept_invitation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AcceptPopUp extends AnchorPane {

    protected final Label label;
    protected final Button yesBtn;
    protected final Button noBtn;
    protected final ImageView imageView;
    private boolean imageShown = false;

    public AcceptPopUp(String userName) {
        label = new Label(userName + " wants to play with you");
        yesBtn = new Button("Accept");
        noBtn = new Button("Decline");
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(200.0);
        setPrefWidth(433.0);
        setStyle("-fx-background-color: #33cccc;");

        label.setLayoutX(85.0);
        label.setLayoutY(45.0);
        label.setPrefHeight(27.0);
        label.setPrefWidth(281.0);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(18.0));

        yesBtn.setLayoutX(62.0);
        yesBtn.setLayoutY(126.0);
        yesBtn.setMnemonicParsing(false);
        yesBtn.setPrefHeight(26.0);
        yesBtn.setPrefWidth(106.0);
        yesBtn.setStyle("-fx-background-color: Green;");
        yesBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        yesBtn.setFont(new Font(18.0));

        noBtn.setLayoutX(262.0);
        noBtn.setLayoutY(126.0);
        noBtn.setMnemonicParsing(false);
        noBtn.setPrefHeight(26.0);
        noBtn.setPrefWidth(106.0);
        noBtn.setStyle("-fx-background-color: Red;");
        noBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        noBtn.setFont(new Font(18.0));

        imageView.setFitHeight(59.0);
        imageView.setFitWidth(71.0);
        imageView.setLayoutX(168.0);
        imageView.setLayoutY(49.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setVisible(false);
        imageView.setImage(new Image(getClass().getResource("/tictactoe/resources/loading.gif").toExternalForm()));

        getChildren().add(label);
        getChildren().add(yesBtn);
        getChildren().add(noBtn);
        getChildren().add(imageView);

        yesBtn.setOnAction((ActionEvent event) -> {
            if (!imageShown) {
                imageView.setVisible(true);
                imageShown = true;
                label.setVisible(false);
                yesBtn.setDisable(true);
                noBtn.setDisable(true);
                
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event1) -> {
                    startGame();
                }));
                timeline.setCycleCount(1);
                timeline.play();
            }
        });

        noBtn.setOnAction((ActionEvent event) -> {
            closePopup();
        });
    }

    private void startGame() {
        Stage stage = (Stage) getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameBoardScreen.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closePopup() {
        Stage stage = (Stage) getScene().getWindow();
        stage.close();
    }
}
