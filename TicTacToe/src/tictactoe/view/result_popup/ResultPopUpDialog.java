package tictactoe.view.result_popup;

import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public  class ResultPopUpDialog extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button restartBtn;
    protected final Label winnerLabel;
    protected final Button exitBtn;

    public Label getWinnerLabel() {
        return winnerLabel;
    }
    protected final MediaView mediaView;

    public Button getRestartBtn() {
        return restartBtn;
    }

    public Button getExitBtn() {
        return exitBtn;
    }

    public ResultPopUpDialog() {
        Media media = new Media(new File("WinnerVideo.mp4").toURI().toString());  
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);  
       
        mediaView = new MediaView (mediaPlayer); 
        anchorPane = new AnchorPane();
        restartBtn = new Button();
        exitBtn = new Button();
        winnerLabel = new Label();
        
        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        setStyle("-fx-background-color:black;");

        anchorPane.setMaxHeight(USE_PREF_SIZE);
        anchorPane.setMaxWidth(USE_PREF_SIZE);
        anchorPane.setMinHeight(USE_PREF_SIZE);
        anchorPane.setMinWidth(USE_PREF_SIZE);
        anchorPane.setPrefHeight(85.0);
        anchorPane.setPrefWidth(500.0); 
        
        winnerLabel.setLayoutX(70.0);
        winnerLabel.setLayoutY(17.0);
        winnerLabel.setMnemonicParsing(false);
        winnerLabel.setTextFill(Color.WHITE);
        winnerLabel.setFont(new Font("System Bold", 20.0));
        
        restartBtn.setStyle("-fx-background-color: green;");
        restartBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        restartBtn.setFont(new Font("System Bold", 20.0));
        restartBtn.setLayoutX(328.0);
        restartBtn.setLayoutY(12.0);
        restartBtn.setMnemonicParsing(false);
        restartBtn.setText("Restart");
        
        
        setBottom(anchorPane);

        BorderPane.setAlignment(mediaView, javafx.geometry.Pos.CENTER);
        mediaView.setFitHeight(250.0);
        mediaView.setFitWidth(500.0);
        setCenter(mediaView);
        anchorPane.getChildren().add(restartBtn);
        anchorPane.getChildren().add(winnerLabel);

    }
}
