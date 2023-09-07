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

public abstract class accept_invitationBase extends AnchorPane {

    protected final Label label;
    protected final Button button;
    protected final Button button0;
    protected final ImageView imageView;
    private boolean imageShown = false;

    public accept_invitationBase(String userName) {
        label = new Label(userName + " wants to play with you");
        button = new Button("Accept");
        button0 = new Button("Decline");
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

        button.setLayoutX(62.0);
        button.setLayoutY(126.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(26.0);
        button.setPrefWidth(106.0);
        button.setStyle("-fx-background-color: #1978ae;");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font(18.0));

        button0.setLayoutX(262.0);
        button0.setLayoutY(126.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(26.0);
        button0.setPrefWidth(106.0);
        button0.setStyle("-fx-background-color: #1978ae;");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font(18.0));

        imageView.setFitHeight(59.0);
        imageView.setFitWidth(71.0);
        imageView.setLayoutX(168.0);
        imageView.setLayoutY(49.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setVisible(false);
        imageView.setImage(new Image(getClass().getResource("../../resources/loading.gif").toExternalForm()));

        getChildren().add(label);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(imageView);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!imageShown) {
                    imageView.setVisible(true);
                    imageShown = true;
                    label.setVisible(false);
                    button.setDisable(true);
                    button0.setDisable(true);

                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            startGame();
                        }
                    }));
                    timeline.setCycleCount(1);
                    timeline.play();
                }
            }
        });

        button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closePopup();
            }
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
