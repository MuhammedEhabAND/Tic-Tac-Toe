package tictactoe.view.confirmation_popup;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class confirmation_popupBase extends AnchorPane {

    protected final Button button;
    protected final Button button0;
    protected final Label label;
    protected final ImageView imageView;
    private boolean imageShown = false;

    public confirmation_popupBase() {
        button = new Button("YES");
        button0 = new Button("NO");
        label = new Label("Are you sure you want to play with this player?");
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(200.0);
        setPrefWidth(433.0);
        setStyle("-fx-background-color: #33cccc;");

        button.setLayoutX(74.0);
        button.setLayoutY(133.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(103.0);
        button.setStyle("-fx-background-color: #1978ae;");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font(18.0));

        button0.setLayoutX(256.0);
        button0.setLayoutY(132.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(31.0);
        button0.setPrefWidth(103.0);
        button0.setStyle("-fx-background-color: #1978ae;");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font(18.0));

        label.setLayoutX(30.0);
        label.setLayoutY(67.0);
        label.setPrefHeight(27.0);
        label.setPrefWidth(385.0);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(18.0));

        imageView.setFitHeight(74.0);
        imageView.setFitWidth(82.0);
        imageView.setLayoutX(152.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setVisible(false);
        imageView.setImage(new Image(getClass().getResource("../../resources/loading.gif").toExternalForm()));

        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(label);
        getChildren().add(imageView);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!imageShown) {
                    imageView.setVisible(true);
                    imageShown = true;
                    button.setDisable(true);
                    button0.setDisable(true);
                    label.setVisible(false);

                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            closePopup();
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

    private void closePopup() {
        Stage stage = (Stage) getScene().getWindow();
        stage.close();
    }
}
