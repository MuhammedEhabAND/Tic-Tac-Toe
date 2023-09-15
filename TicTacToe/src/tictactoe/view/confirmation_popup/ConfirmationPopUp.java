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

public class ConfirmationPopUp extends AnchorPane {

    protected final Button yesBtn;
    protected final Button noBtn;
    protected final Label label;
    protected final ImageView imageView;
    private boolean imageShown = false;

    public ConfirmationPopUp(String opUsername) {
        yesBtn = new Button("YES");
        noBtn = new Button("NO");
        label = new Label("Are you sure you want to play with "+ opUsername+"?");
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(200.0);
        setPrefWidth(433.0);
        setStyle("-fx-background-color: #33cccc;");

        yesBtn.setLayoutX(74.0);
        yesBtn.setLayoutY(133.0);
        yesBtn.setMnemonicParsing(false);
        yesBtn.setPrefHeight(31.0);
        yesBtn.setPrefWidth(103.0);
        yesBtn.setStyle("-fx-background-color: #1978ae;");
        yesBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        yesBtn.setFont(new Font(18.0));

        noBtn.setLayoutX(256.0);
        noBtn.setLayoutY(132.0);
        noBtn.setMnemonicParsing(false);
        noBtn.setPrefHeight(31.0);
        noBtn.setPrefWidth(103.0);
        noBtn.setStyle("-fx-background-color: #1978ae;");
        noBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        noBtn.setFont(new Font(18.0));

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
//        imageView.setImage(new Image(getClass().getResource("../../resources/loading.gif").toExternalForm()));

        getChildren().add(yesBtn);
        getChildren().add(noBtn);
        getChildren().add(label);
        getChildren().add(imageView);

        yesBtn.setOnAction((ActionEvent event) -> {
            if (!imageShown) {
                imageView.setVisible(true);
                imageShown = true;
                yesBtn.setDisable(true);
                noBtn.setDisable(true);
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
        });

        noBtn.setOnAction(new EventHandler<ActionEvent>() {
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
