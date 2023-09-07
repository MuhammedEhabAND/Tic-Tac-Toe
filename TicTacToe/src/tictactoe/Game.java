package tictactoe;

import java.util.LinkedList;
import java.util.Queue;
import tictactoe.model.Move;
import tictactoe.model.Player;
import tictactoe.model.Result;
import tictactoe.model.Symbol;

public class Game {
    
    private Board board;
    private Player player1;
    private Player player2;
    private Queue<Player> userChoices  = new LinkedList<>();
    
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        
        board = new Board();

        userChoices.add(this.player1);
        userChoices.add(this.player2);
    }
    
    public void setBoard(Symbol[][] symbols) {
        board.setBoard(symbols);
    }
    
    public Symbol[][] getBoard() {
        return board.getBoard();
    }
    
    public String makeMove(Move move) {
        Player player = userChoices.poll();
        board.addMove();
        doChanges(move, player);
        Result result = board.getSituation();
        if (result == Result.DRAW) {
            return "draw";
        } else if(result != null && result != Result.ONGOING) {
            return player.getUserName();
        } 
        return null;
    }
    
    private void doChanges(Move move, Player player) {
        board.setItemOnBoard(move);
        userChoices.add(player);

        judge();
    }
    
    private void judge() {
        
        checkRows();
        
        checkColumns();

        checkDiagonal();
        
        checkReverseDiagonal();

        if(board.getMoves() < 3 * 3){
            if(!board.getSituation().equals(Result.WIN)) {
                board.setSituation(Result.ONGOING);
            }
        } 
        else {
            if(!board.getSituation().equals(Result.WIN)){
                board.setSituation(Result.DRAW);
            }
        }
    }
    
    private void checkRows() {
        for(int i = 0; i < 3; i++) {
            Symbol start = board.getBoard()[i][0];
            int count = 0;
            for(int  j = 0; j < 3; j++) {
                if(board.getBoard()[i][j].equals(start)) count  = count + 1;
            }
            if(count == 3) {
                if (start.equals(Symbol.X) || start.equals(Symbol.O)) {
                    board.setSituation(Result.WIN);
                }
            }
        }
    }
    
    private void checkColumns() {
        for(int i = 0; i < 3; i++) {
            Symbol start = board.getBoard()[0][i];
            int count = 0;
            for(int j = 0; j < 3; j++){
                if(board.getBoard()[j][i] == start) count  = count + 1;
            }
            if(count == 3) {
                if (start.equals(Symbol.X) || start.equals(Symbol.O)) {
                    board.setSituation(Result.WIN);
                }
            }
        }     
    }
    
    private void checkDiagonal() {
        Symbol start = board.getBoard()[0][0];
        int count = 0;
        for(int i = 0; i < 3; i++){
            if(board.getBoard()[i][i] == start) count = count + 1;
        }
        if(count == 3) {
                if (start.equals(Symbol.X) || start.equals(Symbol.O)) {
                    board.setSituation(Result.WIN);
                }
            }
    }
    
    private void checkReverseDiagonal() {
        int count = 0;
        Symbol start = board.getBoard()[0][2];
        for (int i = 0 ; i < 3; ++i){
            for (int  j = 0 ; j < 3; ++j){
                if((i + j) == 2){
                    if(board.getBoard()[i][j] == start) count = count + 1;
                }
            }
        }
        if(count == 3) {
                if (start.equals(Symbol.X) || start.equals(Symbol.O)) {
                    board.setSituation(Result.WIN);
                }
            }
    }
    
    public void printBoard() {
        board.printBoard();
    }
}