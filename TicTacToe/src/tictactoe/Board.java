package tictactoe;

import tictactoe.model.Move;
import tictactoe.model.Result;
import tictactoe.model.Symbol;

public class Board {
    
    private Symbol[][] board;
    private int movesNo;
    private Result situation;
    
    public Board() {
        board = new Symbol[3][3];
        movesNo = 0;
        situation = Result.ONGOING;
        
        for(int i = 0; i < 3; i++){
             for(int j = 0; j < 3; j++){
                 board[i][j] = Symbol.UNDEFINED;
             }
        }
    }
    
    public void addMove() {
        movesNo++;
    }
    
    public int getMoves() {
        return movesNo;
    }
    
    public void setSituation(Result situation) {
        this.situation = situation;
    }
    
    public Result getSituation() {
        return situation;
    }
    
    public void setItemOnBoard(Move move) {
        board [move.getRaw()][move.getColumn()] = move.getSymbol();
    }
    
    public void setBoard(Symbol[][] symbols) {
        board = symbols;
    }
    
    public Symbol[][] getBoard() {
        return board;
    }
}
