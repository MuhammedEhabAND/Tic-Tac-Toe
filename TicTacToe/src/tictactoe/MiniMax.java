package tictactoe;

import tictactoe.model.Symbol;

public class MiniMax {
    
    GameType gameType;
    
    public MiniMax(GameType gameType) {
        this.gameType = gameType;
    }
    
    public int[] minimax(Symbol[][] symbols, Symbol symbol) {
        int[] bestMove = new int[] { -1, -1 };

        int bestScore = (gameType == GameType.EASY) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (symbols[row][col] == Symbol.UNDEFINED) {
                    symbols[row][col] = symbol;
                    int score = minimaxHelper(symbols, 0, false);
                    symbols[row][col] = Symbol.UNDEFINED;

                    if ((gameType == GameType.HARD && score > bestScore) || (gameType == GameType.EASY && score < bestScore)) {
                        bestScore = score;
                        bestMove[0] = row;
                        bestMove[1] = col;
                    }
                }
            }
        }

        return bestMove;
    }

    private int minimaxHelper(Symbol[][] symbols, int depth, boolean isMaximizing) {
        Symbol result = checkGameResult(symbols);
        if (result != Symbol.UNDEFINED) {
            return (result == Symbol.X) ? -1 : (result == Symbol.O) ? 1 : 0;
        }

        int bestScore = (isMaximizing) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        Symbol symbol = (isMaximizing) ? Symbol.O : Symbol.X;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (symbols[row][col] == Symbol.UNDEFINED) {
                    symbols[row][col] = symbol;
                    int score = minimaxHelper(symbols, depth + 1, !isMaximizing);
                    symbols[row][col] = Symbol.UNDEFINED;

                    if (isMaximizing) {
                        bestScore = Math.max(score, bestScore);
                    } else {
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
        }

        return bestScore;
    }
    
    private Symbol checkGameResult(Symbol[][] symbols) {
        // Check for a win
        for (int i = 0; i < 3; i++) {
            if (symbols[i][0] == symbols[i][1] && symbols[i][1] == symbols[i][2] && symbols[i][0] != Symbol.UNDEFINED) {
                return symbols[i][0];
            }
            if (symbols[0][i] == symbols[1][i] && symbols[1][i] == symbols[2][i] && symbols[0][i] != Symbol.UNDEFINED) {
                return symbols[0][i];
            }
        }

        // Check diagonals
        if (symbols[0][0] == symbols[1][1] && symbols[1][1] == symbols[2][2] && symbols[0][0] != Symbol.UNDEFINED) {
            return symbols[0][0];
        }
        if (symbols[0][2] == symbols[1][1] && symbols[1][1] == symbols[2][0] && symbols[0][2] != Symbol.UNDEFINED) {
            return symbols[0][2];
        }

        // Check for a draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (symbols[i][j] == Symbol.UNDEFINED) {
                    return Symbol.UNDEFINED;
                }
            }
        }

        return null; // Draw
    }
}
