package tictactoe.view.game_board;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoe.Game;
import tictactoe.GameType;
import tictactoe.MiniMax;
import tictactoe.model.Move;
import tictactoe.model.Player;
import tictactoe.model.Result;
import tictactoe.model.Symbol;
import tictactoe.view.result_popup.ResultPopUpDialog;

public class GameBoard extends AnchorPane {

    protected final Rectangle rectangle;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final StackPane stackPane;
    protected final ImageView imageView;
    protected final StackPane stackPane0;
    protected final ImageView imageView0;
    protected final StackPane stackPane1;
    protected final ImageView imageView1;
    protected final StackPane stackPane2;
    protected final ImageView imageView2;
    protected final StackPane stackPane3;
    protected final ImageView imageView3;
    protected final StackPane stackPane4;
    protected final ImageView imageView4;
    protected final StackPane stackPane5;
    protected final ImageView imageView5;
    protected final StackPane stackPane6;
    protected final ImageView imageView6;
    protected final StackPane stackPane7;
    protected final ImageView imageView7;
    protected final Label label;
    protected final Label label0;
    protected final Label userScore;
    protected final Label cpuScore;
    protected final Label label1;
    Player player1;
    Player player2;
    Symbol symbol;
    Game game;
    MiniMax miniMax;
    GameType gameType;
    Image xImage;
    Image oImage;
    int userScoreInt = 0;
    int cpuScoreInt = 0;
    
    public GameBoard(GameType gameType) {

        player1 = new Player("Guest-X", Symbol.X);
        player2 = new Player("Guest-O", Symbol.O);
        symbol = player1.getSymbol();
        this.gameType = gameType;


        game = new Game(player1, player2);
        miniMax = new MiniMax();

        rectangle = new Rectangle();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        stackPane = new StackPane();
        imageView = new ImageView();
        stackPane0 = new StackPane();
        imageView0 = new ImageView();
        stackPane1 = new StackPane();
        imageView1 = new ImageView();
        stackPane2 = new StackPane();
        imageView2 = new ImageView();
        stackPane3 = new StackPane();
        imageView3 = new ImageView();
        stackPane4 = new StackPane();
        imageView4 = new ImageView();
        stackPane5 = new StackPane();
        imageView5 = new ImageView();
        stackPane6 = new StackPane();
        imageView6 = new ImageView();
        stackPane7 = new StackPane();
        imageView7 = new ImageView();
        label = new Label();
        label0 = new Label();
        userScore = new Label();
        cpuScore = new Label();
        label1 = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color:linear-gradient(to bottom, #1978ae,#33cccc);");


        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(285.0);
        rectangle.setLayoutX(117.0);
        rectangle.setLayoutY(79.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(352.0);

        gridPane.setGridLinesVisible(true);
        gridPane.setLayoutX(117.0);
        gridPane.setLayoutY(79.0);
        gridPane.setPrefHeight(285.0);
        gridPane.setPrefWidth(352.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        stackPane.setPrefHeight(150.0);
        stackPane.setPrefWidth(200.0);

        StackPane.setAlignment(imageView, javafx.geometry.Pos.CENTER);
        imageView.setFitHeight(94.0);
        imageView.setFitWidth(117.0);
        imageView.setOnMouseClicked((MouseEvent mouseEvent) -> {this.onTap(mouseEvent, 0, 0);});
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        GridPane.setColumnIndex(stackPane0, 1);
        stackPane0.setLayoutX(10.0);
        stackPane0.setLayoutY(10.0);
        stackPane0.setPrefHeight(150.0);
        stackPane0.setPrefWidth(200.0);

        StackPane.setAlignment(imageView0, javafx.geometry.Pos.CENTER);
        imageView0.setFitHeight(94.0);
        imageView0.setFitWidth(117.0);
        imageView0.setOnMouseClicked((MouseEvent mouseEvent) -> {this.onTap(mouseEvent, 0, 1);});
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);

        GridPane.setColumnIndex(stackPane1, 2);
        stackPane1.setLayoutX(10.0);
        stackPane1.setLayoutY(10.0);
        stackPane1.setPrefHeight(150.0);
        stackPane1.setPrefWidth(200.0);

        StackPane.setAlignment(imageView1, javafx.geometry.Pos.CENTER);
        imageView1.setFitHeight(94.0);
        imageView1.setFitWidth(117.0);
        imageView1.setOnMouseClicked((MouseEvent mouseEvent) -> {this.onTap(mouseEvent, 0, 2);});
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);

        GridPane.setRowIndex(stackPane2, 1);
        
        stackPane2.setLayoutX(10.0);
        stackPane2.setLayoutY(10.0);
        stackPane2.setPrefHeight(150.0);
        stackPane2.setPrefWidth(200.0);

        StackPane.setAlignment(imageView2, javafx.geometry.Pos.CENTER);
        imageView2.setFitHeight(94.0);
        imageView2.setFitWidth(117.0);
        imageView2.setOnMouseClicked((MouseEvent mouseEvent) -> {this.onTap(mouseEvent, 1, 0);});
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);

        GridPane.setColumnIndex(stackPane3, 1);
        GridPane.setRowIndex(stackPane3, 1);
        stackPane3.setLayoutX(10.0);
        stackPane3.setLayoutY(10.0);
        stackPane3.setPrefHeight(150.0);
        stackPane3.setPrefWidth(200.0);

        StackPane.setAlignment(imageView3, javafx.geometry.Pos.CENTER);
        imageView3.setFitHeight(94.0);
        imageView3.setFitWidth(117.0);
        imageView3.setOnMouseClicked((MouseEvent mouseEvent) -> {this.onTap(mouseEvent, 1, 1);});
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);

        GridPane.setColumnIndex(stackPane4, 2);
        GridPane.setRowIndex(stackPane4, 1);
        stackPane4.setLayoutX(10.0);
        stackPane4.setLayoutY(10.0);
        stackPane4.setPrefHeight(150.0);
        stackPane4.setPrefWidth(200.0);

        StackPane.setAlignment(imageView4, javafx.geometry.Pos.CENTER);
        imageView4.setFitHeight(94.0);
        imageView4.setFitWidth(117.0);
        imageView4.setOnMouseClicked((MouseEvent mouseEvent) -> {this.onTap(mouseEvent, 1, 2);});
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);

        GridPane.setRowIndex(stackPane5, 2);
        stackPane5.setLayoutX(10.0);
        stackPane5.setLayoutY(10.0);
        stackPane5.setPrefHeight(150.0);
        stackPane5.setPrefWidth(200.0);

        StackPane.setAlignment(imageView5, javafx.geometry.Pos.CENTER);
        imageView5.setFitHeight(94.0);
        imageView5.setFitWidth(117.0);
        imageView5.setOnMouseClicked((MouseEvent mouseEvent) -> {this.onTap(mouseEvent, 2, 0);});
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);

        GridPane.setColumnIndex(stackPane6, 1);
        GridPane.setRowIndex(stackPane6, 2);
        stackPane6.setLayoutX(10.0);
        stackPane6.setLayoutY(10.0);
        stackPane6.setPrefHeight(150.0);
        stackPane6.setPrefWidth(200.0);

        StackPane.setAlignment(imageView6, javafx.geometry.Pos.CENTER);
        imageView6.setFitHeight(94.0);
        imageView6.setFitWidth(117.0);
        imageView6.setOnMouseClicked((MouseEvent mouseEvent) -> {this.onTap(mouseEvent, 2, 1);});
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);

        GridPane.setColumnIndex(stackPane7, 2);
        GridPane.setRowIndex(stackPane7, 2);
        stackPane7.setLayoutX(128.0);
        stackPane7.setLayoutY(200.0);
        stackPane7.setPrefHeight(150.0);
        stackPane7.setPrefWidth(200.0);

        StackPane.setAlignment(imageView7, javafx.geometry.Pos.CENTER);
        imageView7.setFitHeight(94.0);
        imageView7.setFitWidth(117.0);
        imageView7.setOnMouseClicked((MouseEvent mouseEvent) -> {this.onTap(mouseEvent, 2, 2);});
        imageView7.setPickOnBounds(true);
        imageView7.setPreserveRatio(true);

        label.setLayoutX(14.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(47.0);
        label.setPrefWidth(190.0);
        label.setText(player1.getUserName());
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("SansSerif Bold Italic", 30.0));

        label0.setLayoutX(469.0);
        label0.setLayoutY(14.0);
        label0.setPrefHeight(47.0);
        label0.setPrefWidth(132.0);
        label0.setText(player2.getUserName());
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("SansSerif Bold Italic", 30.0));

        userScore.setLayoutX(38.0);
        userScore.setLayoutY(69.0);
        userScore.setPrefHeight(47.0);
        userScore.setPrefWidth(49.0);
        userScore.setText(String.valueOf(userScoreInt));
        userScore.setTextFill(javafx.scene.paint.Color.WHITE);
        userScore.setFont(new Font("SansSerif Bold Italic", 20.0));

        cpuScore.setLayoutX(496.0);
        cpuScore.setLayoutY(69.0);
        cpuScore.setPrefHeight(47.0);
        cpuScore.setPrefWidth(39.0);
        cpuScore.setText(String.valueOf(cpuScoreInt));
        cpuScore.setTextFill(javafx.scene.paint.Color.WHITE);
        cpuScore.setFont(new Font("SansSerif Bold Italic", 20.0));

        label1.setLayoutX(281.0);
        label1.setLayoutY(14.0);
        label1.setPrefHeight(47.0);
        label1.setPrefWidth(49.0);
        label1.setText("VS");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("SansSerif Bold Italic", 30.0));

        getChildren().add(rectangle);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        stackPane.getChildren().add(imageView);
        gridPane.getChildren().add(stackPane);
        stackPane0.getChildren().add(imageView0);
        gridPane.getChildren().add(stackPane0);
        stackPane1.getChildren().add(imageView1);
        gridPane.getChildren().add(stackPane1);
        stackPane2.getChildren().add(imageView2);
        gridPane.getChildren().add(stackPane2);
        stackPane3.getChildren().add(imageView3);
        gridPane.getChildren().add(stackPane3);
        stackPane4.getChildren().add(imageView4);
        gridPane.getChildren().add(stackPane4);
        stackPane5.getChildren().add(imageView5);
        gridPane.getChildren().add(stackPane5);
        stackPane6.getChildren().add(imageView6);
        gridPane.getChildren().add(stackPane6);
        stackPane7.getChildren().add(imageView7);
        gridPane.getChildren().add(stackPane7);
        getChildren().add(gridPane);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(userScore);
        getChildren().add(cpuScore);
        getChildren().add(label1);
        xImage = new Image(getClass().getResource("/tictactoe/resources/x.png").toExternalForm());
        oImage = new Image(getClass().getResource("/tictactoe/resources/o.png").toExternalForm());
    }
    
    boolean isGameOn = true;
    
    protected void onTap(MouseEvent mouseEvent, int x, int y){
        
        if(isGameOn){
            ImageView imageClicked = (ImageView) mouseEvent.getSource();
            if(imageClicked.getImage() == null) {
                Move move = new Move(symbol, y, x);
                addMove(imageClicked);
                String winner = game.makeMove(move);
                System.out.println("guest move" + move.getRaw() + ", " + move.getColumn());
                checkWinner(winner);
                
                if ((gameType == GameType.EASY || gameType == GameType.MEDIUM || gameType == GameType.HARD) && isGameOn) {
                    playCpu();
                }
            }
        }
        
        game.printBoard();
        System.out.println("=========================");
    }
    
    private void playCpu() {
        ImageView imageClicked = null;
        symbol = Symbol.O;
        int[] bestMove = miniMax.minimax(game.getBoard(), symbol);
                
        int row = bestMove[0], col = bestMove[1];
        switch (row) {
            case 0:
                if (col == 0) imageClicked = imageView;
                if (col == 1) imageClicked = imageView0;
                if (col == 2) imageClicked = imageView1;
                break;
            case 1:
                if (col == 0) imageClicked = imageView2;
                if (col == 1) imageClicked = imageView3;
                if (col == 2) imageClicked = imageView4;
                break;
            case 2:
                if (col == 0) imageClicked = imageView5;
                if (col == 1) imageClicked = imageView6;
                if (col == 2) imageClicked = imageView7;
        }
                
        addMove(imageClicked);
        String winner = game.makeMove(new Move(Symbol.O, col, row));
        checkWinner(winner);
        System.out.println("cpu move: " + row + ", " + col);
    }
    
    private void addMove(ImageView imageClicked) {
        if(isGameOn){
            if(imageClicked.getImage() == null) {
                if(symbol.equals(Symbol.X)){
                    imageClicked.setImage(xImage);
                    symbol = symbol.equals(Symbol.X) ? Symbol.O : Symbol.X;
                
                } else {
                    imageClicked.setImage(oImage);
                    imageClicked.setFitWidth(60);        
                    symbol = symbol.equals(Symbol.X) ? Symbol.O : Symbol.X;
            
                }
            }
        }
    }
    
    private void checkWinner(String winner) {
        if (winner != null) {
            isGameOn = false;
            showPopUp(winner);
            if (winner.equals("draw")) {
                // Draw
                System.out.println("Game is draw");
            } else {
                if (winner.equals(player1.getUserName())) {
                    // Win
                    userScoreInt += 5;
                    userScore.setText(String.valueOf(userScoreInt));
                    System.out.println("You win");
                } else {
                    // Lose
                    cpuScoreInt +=5;
                    cpuScore.setText(String.valueOf(userScoreInt));
                    System.out.println("You losed");
                }
            }
        }
    }

    private void showPopUp(String winner) {
        ResultPopUpDialog result = new ResultPopUpDialog();
          
        Stage dialogStage = new Stage();
        dialogStage.initStyle(StageStyle.UNDECORATED);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        
        if(winner.equals("draw")){
            result.getWinnerLabel().setText("DRAW");
        }else{
            result.getWinnerLabel().setText("The Winner is : " + winner);
        }
        result.getRestartBtn().setOnAction((event) -> {
            reset();
            dialogStage.close();
        });
        
        Scene scene = new Scene(result);
        
        dialogStage.setScene(scene);
        
        dialogStage.showAndWait();
        
    }

    private void reset() {
        game.printBoard();
        System.out.println("=========================");
        
        game = new Game(player1 , player2);
        symbol =Symbol.X;
        resetImages();
        isGameOn = true;
    }

    private void resetImages() {
        imageView.setImage(null);
        imageView0.setImage(null);
        imageView1.setImage(null);
        imageView2.setImage(null);
        imageView3.setImage(null);
        imageView4.setImage(null);
        imageView5.setImage(null);
        imageView6.setImage(null);
        imageView7.setImage(null);
        
        imageView.setFitWidth(117.0);
        imageView0.setFitWidth(117.0);
        imageView1.setFitWidth(117.0);
        imageView2.setFitWidth(117.0);
        imageView3.setFitWidth(117.0);
        imageView4.setFitWidth(117.0);
        imageView5.setFitWidth(117.0);
        imageView6.setFitWidth(117.0);
        imageView7.setFitWidth(117.0);
     }
}
