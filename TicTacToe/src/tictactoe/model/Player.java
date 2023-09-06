package tictactoe.model;

public class Player extends UserData {
    public Player(String userName, Symbol symbol) {
        super(userName);
        this.symbol = symbol;
    }

    Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
