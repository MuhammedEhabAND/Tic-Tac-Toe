package tictactoe.model;

public class Player {
    public Player(Symbol symbol, Result result) {
        this.symbol = symbol;
        this.result = result;
    }

    Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    Result   result ;
}
