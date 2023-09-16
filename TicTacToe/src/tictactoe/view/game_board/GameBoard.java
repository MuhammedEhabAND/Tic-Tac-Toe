package tictactoe.view.game_board;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoe.Files;
import tictactoe.Game;
import tictactoe.GameType;
import tictactoe.MiniMax;
import tictactoe.model.Move;
import tictactoe.model.Player;
import tictactoe.model.Record;
import tictactoe.model.Symbol;
import tictactoe.utils.Constants;
import tictactoe.view.play_offline.PlayOffline;
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
    protected final Button backBtn;
    protected final Button recordBtn;
    protected final Button openRecords;
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
    Files files;
    Boolean isRecording, isRecordPlaying;
    Record record;
    private final Stage stage;
    
    private DataInputStream dis;
    private BufferedReader bufferedReader;
    private PrintStream ps;
    private Socket mySocket;
    private Boolean isFirst;
    
    

    public GameBoard(GameType gameType ,Stage stage , boolean isFirst , String username , String opUsername ) {
        this.stage =stage; 
        
        
        
        
        
        this.gameType = gameType;
     
        this.isFirst = isFirst;
        try {
            mySocket = new  Socket(Constants.HOST, Constants.PORT);
            dis = new DataInputStream(mySocket.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(dis));
            ps = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       /* if(gameType.equals(GameType.ONLINE)) {
            ps.println(Constants.CHANGE_STATE);
            ps.println(player1.getUserName());
            ps.println("in_game");
        }*/

        
        
        
        
        
        
        miniMax = new MiniMax(gameType);
        if(gameType == GameType.ONLINE && isFirst){
        player1 = new Player(username, Symbol.X);   
        player2 = new Player (opUsername , Symbol.O);
        }else if(gameType == GameType.ONLINE && !isFirst){
        player1 = new Player(username, Symbol.O);  
        player2 = new Player(opUsername, Symbol.X);  
        }else if(gameType == GameType.TWO_PLAYERS){
        player1 = new Player("Guest-X" , Symbol.X);
        
        player2 = new Player("Guest-O" , Symbol.O);
        }
        else{
        player1 = new Player("Guest-X" , Symbol.X);  
        player2 = new Player("AI", Symbol.O);
         }
     
        symbol = player1.getSymbol();
        isRecording = isRecordPlaying = false;

        game = new Game(player1, player2);
        files = new Files();
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
        backBtn = new Button();
        recordBtn = new Button();
        openRecords = new Button();

        setId("AnchorPane");
        setPrefHeight(428.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color:linear-gradient(to bottom, #1978ae,#33cccc);");


        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(285.0);
        rectangle.setLayoutX(175.0);
        rectangle.setLayoutY(76.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(352.0);

        gridPane.setGridLinesVisible(true);
        gridPane.setLayoutX(175.0);
        gridPane.setLayoutY(76.0);
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

        label.setLayoutX(71.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(47.0);
        label.setPrefWidth(190.0);
        label.setText(player1.getUserName());
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("SansSerif Bold Italic", 30.0));

        label0.setLayoutX(554.0);
        label0.setLayoutY(14.0);
        label0.setPrefHeight(47.0);
        label0.setPrefWidth(132.0);
        label0.setText(player2.getUserName());
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("SansSerif Bold Italic", 30.0));

        userScore.setLayoutX(103.0);
        userScore.setLayoutY(69.0);
        userScore.setPrefHeight(47.0);
        userScore.setPrefWidth(49.0);
        userScore.setText("0");
        userScore.setTextFill(javafx.scene.paint.Color.WHITE);
        userScore.setFont(new Font("SansSerif Bold Italic", 30.0));

        cpuScore.setLayoutX(581.0);
        cpuScore.setLayoutY(69.0);
        cpuScore.setPrefHeight(47.0);
        cpuScore.setPrefWidth(39.0);
        cpuScore.setText("0");
        cpuScore.setTextFill(javafx.scene.paint.Color.WHITE);
        cpuScore.setFont(new Font("SansSerif Bold Italic", 30.0));

        label1.setLayoutX(326.0);
        label1.setLayoutY(14.0);
        label1.setPrefHeight(47.0);
        label1.setPrefWidth(49.0);
        label1.setText("VS");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("SansSerif Bold Italic", 30.0));

        backBtn.setLayoutX(27.0);
        backBtn.setLayoutY(22.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setStyle("-fx-background-color: #33cccc; -fx-border-color: WHITE;");
        backBtn.setText("<");
        backBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        backBtn.setOnAction((event) -> {
            stage.setScene(new PlayOffline(stage).getScene());

        });

        recordBtn.setLayoutX(250.0);
        recordBtn.setLayoutY(375.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setStyle("-fx-background-color: #1978ae;");
        recordBtn.setText("Record");
        recordBtn.setTextFill(javafx.scene.paint.Color.WHITE);

        openRecords.setLayoutX(368.0);
        openRecords.setLayoutY(375.0);
        openRecords.setMnemonicParsing(false); 
        openRecords.setStyle("-fx-background-color: #33cccc; -fx-border-color: WHITE;");
        openRecords.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        openRecords.setText("Open Records");
        openRecords.setTextFill(javafx.scene.paint.Color.WHITE);

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
        getChildren().add(backBtn);
        getChildren().add(recordBtn);
        getChildren().add(openRecords);
	
        xImage = new Image(getClass().getResource("/tictactoe/resources/x.png").toExternalForm());
       oImage = new Image(getClass().getResource("/tictactoe/resources/o.png").toExternalForm());
        
        // Get Game Recorded Button
        openRecords.setOnMouseClicked((MouseEvent event) -> {
            try {
                Record record = files.openFile();
                playRecorded(record);
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
            }          
        });
        
        // Record Dialog Button
        recordBtn.setOnMouseClicked((MouseEvent  event) -> {
            isRecording = true;
            if(isRecording){
                recordBtn.setText("Recording");
                
            }
            record = new Record(player1, player2);
        });
    
        System.out.println(isFirst+"is first");
                if (isFirst == false){ getMoveFromServer();}
                
           }
    
    
    private void getMoveFromServer() {
       new Thread(new Runnable() {
           @Override
           public void run() {
        ImageView imageClicked = null;
        symbol = player2.getSymbol();
        
        // Get move from server
      
        try {
           // ps.println(Constants.PRINT_NEXT_MOVE);
           // String res =dis.readLine();
            //System.out.println("first response : " +res);
            //if(res.equals(Constants.SERVER_RUNNING)) {
                System.out.println("waiting for the server to play ");  
                
                String res1= bufferedReader.readLine();   
                System.out.println("second response : "+res1);
                int row = Integer.parseInt(res1);
                    System.out.println("row: " + row);
                    
                    int col = Integer.parseInt(bufferedReader.readLine());
                    
                    System.out.println("col: " + col);
            
                    imageClicked = setImage(row, col);
        
                    Move move = new Move(symbol, col, row);
                    if (record != null) record.addMove(move);
        
                    addMove(imageClicked);
                    String winner = game.makeMove(new Move(Symbol.O, col, row));
                    checkWinner(winner);
                
            //}
        } catch (IOException ex) {
            Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error reading from server: " + ex.getMessage());
        }
           }
       }).start();
       
    }
    
    private ImageView setImage(int row, int col) {
        ImageView imageClicked = null;
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
        return imageClicked;
    }
    
private void playRecorded(Record record) {
    new Thread(() -> {
        reset();
        isGameOn = isRecordPlaying = true;
        symbol = Symbol.X;
        ImageView imageClicked = null;

        if (record != null) {
            player1 = record.getPlayer1();
            player2 = record.getPlayer2();
            ArrayList<Move> moves = record.getMoves();
            for (Move move : moves) {
                int row = move.getRaw(), col = move.getColumn();
                imageClicked = setImage(row, col);
                symbol = move.getSymbol();

                addMove(imageClicked);

              
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            reset();
        }
       
        isRecordPlaying = false;
        
    }).start();
}

    boolean isGameOn = true;
    
    protected void onTap(MouseEvent mouseEvent, int x, int y){
        
        try {
            mySocket = new  Socket(Constants.HOST, Constants.PORT);
            dis = new DataInputStream(mySocket.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(dis));
            ps = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(isGameOn && isRecordPlaying== false){
            ImageView imageClicked = (ImageView) mouseEvent.getSource();
            if(imageClicked.getImage() == null) {
                Move move = new Move(symbol, y, x);
                if (gameType == GameType.ONLINE ) sendMoveToServer(move);
                if (record != null) record.addMove(move);
                addMove(imageClicked);
                String winner = game.makeMove(move);
                if(!checkWinner(winner)){
                    if ((gameType == GameType.EASY || gameType == GameType.MEDIUM || gameType == GameType.HARD) && isGameOn) {
                        playCpu();
                    } else if (gameType == GameType.ONLINE && isGameOn) {
                        getMoveFromServer();
                    }
                }
            }
        }
    }
    
    private void sendMoveToServer(Move move) {
        ps.println(Constants.PLAY_ONLINE);
        try {
            dis.readLine();
                    } catch (IOException ex) {
            Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ps.println(player2.getUserName());
        
        ps.println(move.getRaw());
        
        ps.println(move.getColumn());
        
        }
    
    private void playCpu() {
        ImageView imageClicked = null;
        symbol = Symbol.O;
        int[] bestMove = miniMax.minimax(game.getBoard(), symbol);
                
        int row = bestMove[0], col = bestMove[1];
        imageClicked = setImage(row, col);
        
        Move move = new Move(symbol, col, row);
        if (record != null) record.addMove(move);
        
        addMove(imageClicked);
        String winner = game.makeMove(new Move(Symbol.O, col, row));
        checkWinner(winner);
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

    private boolean checkWinner(String winner) {
        if (winner != null) {
            isGameOn = false;
            showPopUp(winner);
            
            if (isRecording) {
                isRecording = false;
                recordBtn.setText("Record");
                files.saveFile(record);
            }
            
            if (winner.equals("draw")) {
                // Draw
                changeScoreInServer("draw");
            } else if(winner.equals(player1.getUserName()) && !isRecordPlaying) {
                userScoreInt += 5;
                userScore.setText(String.valueOf(userScoreInt));
                changeScoreInServer("win");
      
            } else if (!isRecordPlaying) {
                cpuScoreInt += 5;   
                cpuScore.setText(String.valueOf(cpuScoreInt));
                changeScoreInServer("lose");
            }
            return true;
        }
        return false;
    }
    
    private void changeScoreInServer(String gameState) {
        if (gameType.equals(GameType.ONLINE)) {
            ps.println(Constants.CHANGE_SCORE);
            ps.println(player1.getUserName());
            ps.println(gameState);
        }
    }

    private void showPopUp(String winner) {
        ResultPopUpDialog result = null;
        
          
        Stage dialogStage = new Stage();
        dialogStage.initStyle(StageStyle.UNDECORATED);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        
        if(winner.equals("draw")){
            result = new ResultPopUpDialog(2);
            result.getWinnerLabel().setText("TIE !!");
        } else if(winner.equals(player1.getUserName())){
            result = new ResultPopUpDialog(0);
            result.getWinnerLabel().setText("The winner is " + winner);
        } else {
            result = new ResultPopUpDialog((gameType == GameType.TWO_PLAYERS) ? 0 : 1);
            result.getWinnerLabel().setText("The winner is " + winner);
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
