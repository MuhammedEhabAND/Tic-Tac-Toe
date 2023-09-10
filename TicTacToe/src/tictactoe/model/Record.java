package tictactoe.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Record implements Serializable {
    String date;
    Player player1;
    Player player2;
    ArrayList<Move> moves;

    public Record(Player player1, Player player2) {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        date = localDate.format(format);
        
        this.player1 = player1;
        this.player2 = player2;
        this.moves = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void addMove(Move moves) {
        this.moves.add(moves);
    }
    
    @Override
    public String toString() {
        return new StringBuffer("Date: ")
                .append(this.date)
                .append("Player1: ")
                .append(this.player1.getUserName())
                .append("Player2: ")
                .append(this.player2.getUserName())
                .append("positionOfMoves: ")
                .append(this.moves).toString();
    }
}