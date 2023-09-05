package tictactoe.model;

import java.util.ArrayList;

public class Record {
    String Date;
    Player player1;
    Player player2;
    ArrayList<Move> positionOfMoves;

    public Record(String date, Player player1, Player player2, ArrayList<Move> positionOfMoves) {
        Date = date;
        this.player1 = player1;
        this.player2 = player2;
        this.positionOfMoves = positionOfMoves;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
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

    public ArrayList<Move> getPositionOfMoves() {
        return positionOfMoves;
    }

    public void setPositionOfMoves(ArrayList<Move> positionOfMoves) {
        this.positionOfMoves = positionOfMoves;
    }
}