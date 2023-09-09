package tictactoe.view.login.play_offline;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.GameType;
import tictactoe.view.game_board.GameBoard;

public class PlayOffline extends AnchorPane {

    
    protected final Label label;
    protected final Button twoPlayerBtn;
    protected final Label label0;
    
    protected final Button easyBtn;
    protected final Button mediumBtn;
    protected final Button hardBtn;
    private final Stage stage;

    public Label getLabel() {
        return label;
    }

    public Button getTwoPlayerBtn() {
        return twoPlayerBtn;
    }

    public Label getLabel0() {
        return label0;
    }

    public Button getEasyBtn() {
        return easyBtn;
    }

    public Button getMediumBtn() {
        return mediumBtn;
    }

    public Button getHardBtn() {
        return hardBtn;
    }

    public PlayOffline(Stage stage) {
        this.stage =stage;
        label = new Label();
        twoPlayerBtn = new Button();
        label0 = new Label();
        easyBtn = new Button();
        mediumBtn = new Button();
        hardBtn = new Button();

        setId("AnchorPane");
        setPrefHeight(500.0);
        setPrefWidth(736.0);

        label.setLayoutX(152.0);
        label.setLayoutY(75.0);
        label.setText("Two Players");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        label.setFont(new Font("SansSerif Bold Italic", 35.0));

        twoPlayerBtn.setLayoutX(49.0);
        twoPlayerBtn.setLayoutY(175.0);
        twoPlayerBtn.setStyle("-fx-background-color: WHITE; -fx-border-color: #33cccc;");
        twoPlayerBtn.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        twoPlayerBtn.setMnemonicParsing(false);
        twoPlayerBtn.setPrefHeight(71.0);
        twoPlayerBtn.setPrefWidth(205.0);
        
        twoPlayerBtn.setText("Play");
        twoPlayerBtn.setFont(new Font("SansSerif Bold", 22.0));
        
        label0.setLayoutX(518.0);
        label0.setLayoutY(75.0);
        label0.setText("One Player");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#1978ae"));
        label0.setFont(new Font("SansSerif Bold Italic", 35.0));

        easyBtn.setLayoutX(446.0);
        easyBtn.setLayoutY(175.0);
        easyBtn.setMnemonicParsing(false);
        easyBtn.setPrefHeight(71.0);
        easyBtn.setPrefWidth(205.0);
        easyBtn.setStyle("-fx-background-color: #1985ae;");
        easyBtn.setText("Easy");
        easyBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        easyBtn.setFont(new Font("SansSerif Bold", 22.0));
        easyBtn.setOnAction((event) -> {
            
            
            Scene easyGameScene = new Scene(new GameBoard(GameType.EASY));
            stage.setScene(easyGameScene);
        });
        mediumBtn.setLayoutX(330.0);
        mediumBtn.setLayoutY(272.0);
        mediumBtn.setMnemonicParsing(false);
        mediumBtn.setPrefHeight(71.0);
        mediumBtn.setPrefWidth(205.0);
        mediumBtn.setStyle("-fx-background-color: #1985ae;");
        mediumBtn.setText("Medium");
        mediumBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        mediumBtn.setFont(new Font("SansSerif Bold", 22.0));
        mediumBtn.setOnAction((ActionEvent event) -> {
            Scene mediumGameScene = new Scene(new GameBoard(GameType.MEDIUM));
            stage.setScene(mediumGameScene);
        });
        
        hardBtn.setLayoutX(227.0);
        hardBtn.setLayoutY(364.0);
        hardBtn.setMnemonicParsing(false);
        hardBtn.setPrefHeight(71.0);
        hardBtn.setPrefWidth(205.0);
        hardBtn.setStyle("-fx-background-color: #1985ae;");
        hardBtn.setText("Hard");
        hardBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        hardBtn.setFont(new Font("SansSerif Bold", 22.0));
        hardBtn.setOnAction((event) -> {
           
            Scene hardGameScene = new Scene(new GameBoard(GameType.HARD));
            stage.setScene(hardGameScene);
        });
        
        getChildren().add(label);
        getChildren().add(twoPlayerBtn);
        getChildren().add(label0);
        getChildren().add(easyBtn);
        getChildren().add(mediumBtn);
        getChildren().add(hardBtn);

    }
}
