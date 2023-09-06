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
    
    public Player makeMove(Move move) {
        Player player = userChoices.poll();
        board.addMove();
        doChanges(move, player);
        Result result = board.getSituation();
        if(result != null && result != Result.ONGOING) {
            return player;
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
        
        System.out.println(board.getSituation() + " ggghhh");
    }
    
    private void checkRows() {
        for(int i = 0; i < 3; i++) {
            Symbol start = board.getBoard()[i][0];
            if (start.equals(Symbol.UNDEFINED)) break;
            int count = 0;
            for(int  j = 0; j < 3; j++) {
                if(board.getBoard()[i][j].equals(start)) count  = count + 1;
            }
            if(count == 3) board.setSituation(Result.WIN);
        }
        
        System.out.println(board.getSituation() + " ggghhh rows");
    }
    
    private void checkColumns() {
        for(int i = 0; i < 3; i++) {
            Symbol start = board.getBoard()[0][i];
            if (start.equals(Symbol.UNDEFINED)) break;
            int count = 0;
            for(int j = 0; j < 3; j++){
                if(board.getBoard()[j][i] == start) count  = count + 1;
            }
            if(count == 3) board.setSituation(Result.WIN);
        }     
        
        System.out.println(board.getSituation() + " ggghhh col");
    }
    
    private void checkDiagonal() {
        Symbol start = board.getBoard()[0][0];
        int count = 0;
        for(int i = 0; i < 3; i++){
            if (start.equals(Symbol.UNDEFINED)) break;
            if(board.getBoard()[i][i] == start) count = count + 1;
        }
        if(count == 3) board.setSituation(Result.WIN);
        
        System.out.println(board.getSituation() + " ggghhh dia");
    }
    
    private void checkReverseDiagonal() {
        int count = 0;
        Symbol start = board.getBoard()[0][2];
        for (int i = 0 ; i < 3; ++i){
            for (int  j = 0 ; j < 3; ++j){
                if (start.equals(Symbol.UNDEFINED)) break;
                if((i + j) == 2){
                    if(board.getBoard()[i][j] == start) count = count + 1;
                }
            }
        }
        if(count == 3) board.setSituation(Result.WIN);
        
        System.out.println(board.getSituation() + " ggghhh reverse");
    }
}
