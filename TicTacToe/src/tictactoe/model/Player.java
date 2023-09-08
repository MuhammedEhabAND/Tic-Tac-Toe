package tictactoe.model;

import java.io.Serializable;

public class Player extends UserData implements Serializable {
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
    
    @Override
    public String toString() {
        return new StringBuffer(this.UserName).toString();
    }
}
