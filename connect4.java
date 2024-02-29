public class Connect4 {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private int[][] board;
    private int currentPlayer;
    private boolean gameWon;

    public Connect4() {
        board = new int[ROWS][COLUMNS];
        currentPlayer = 1;
        gameWon = false;
    }

public String play(int column) {
    if (gameWon) {
        return "Game has finished!";
    }

    int row;
    for (row = ROWS - 1; row >= 0; row--) {
        if (board[row][column] == 0) {
            board[row][column] = currentPlayer;
            if (checkWin(row, column)) {
                gameWon = true;
                return "Player " + currentPlayer + " wins!";
            }
            break; 
        }
    }

    if (row == -1) {
        return "Column full!";
    }


    if (checkWin(row, column)) {
        gameWon = true;
        return "Player " + currentPlayer + " wins!";
    }

    if (gameWon) {
        return "Game has finished!";
    } else {
        String resultado = "Player " + currentPlayer + " has a turn";
        currentPlayer = 3 - currentPlayer;
        return resultado;
    }
}



    private boolean checkWin(int row, int column) {
        return checkHorizontal(row, column) || checkVertical(row, column) || checkDiagonal(row, column);
    }

    private boolean checkHorizontal(int row, int column) {
        int count = 1;
        int player = board[row][column];
        int col = column - 1;
        while (col >= 0 && board[row][col] == player) {
            count++;
            col--;
        }
        col = column + 1;
        while (col < COLUMNS && board[row][col] == player) {
            count++;
            col++;
        }
        return count >= 4;
    }

    private boolean checkVertical(int row, int column) {
        int count = 1;
        int player = board[row][column];
        int r = row - 1;
        while (r >= 0 && board[r][column] == player) {
            count++;
            r--;
        }
        r = row + 1;
        while (r < ROWS && board[r][column] == player) {
            count++;
            r++;
        }
        return count >= 4;
    }

    private boolean checkDiagonal(int row, int column) {
        return checkDiagonalUp(row, column) || checkDiagonalDown(row, column);
    }

    private boolean checkDiagonalUp(int row, int column) {
        int count = 1;
        int player = board[row][column];
        int r = row - 1;
        int col = column - 1;
        while (r >= 0 && col >= 0 && board[r][col] == player) {
            count++;
            r--;
            col--;
        }
        r = row + 1;
        col = column + 1;
        while (r < ROWS && col < COLUMNS && board[r][col] == player) {
            count++;
            r++;
            col++;
        }
        return count >= 4;
    }

    private boolean checkDiagonalDown(int row, int column) {
        int count = 1;
        int player = board[row][column];
        int r = row + 1;
        int col = column - 1;
        while (r < ROWS && col >= 0 && board[r][col] == player) {
            count++;
            r++;
            col--;
        }
        r = row - 1;
        col = column + 1;
        while (r >= 0 && col < COLUMNS && board[r][col] == player) {
            count++;
            r--;
            col++;
        }
        return count >= 4;
    }
}
