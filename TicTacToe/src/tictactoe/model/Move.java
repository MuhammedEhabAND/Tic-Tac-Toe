package tictactoe.model;

import java.io.Serializable;

public class Move implements Serializable {
    
    Symbol symbol;
    int  column ;
    int raw;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRaw() {
        return raw;
    }

    public void setRaw(int raw) {
        this.raw = raw;
    }

    public Move(Symbol symbol, int column, int raw) {
        this.symbol = symbol;
        this.column = column;
        this.raw = raw;
    }
    
    @Override
    public String toString() {
        return new StringBuffer(this.raw)
                .append(this.column).toString();
    }

}
