public class TikTakToe {
    private final char[][] board = new char[3][3];
    char player = 'X';
    int noOfMoves = 0;

    public TikTakToe() {
        initializeBoard();
    }

    public char getPlayer() {
        return this.player;
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }
    }

    private boolean checkHorizontal(int row) {
        for (int i = 0; i < 3; i++) {
            if (board[row][i] != this.player)
                return false;
        }
        return true;
    }

    private boolean checkVertical(int col) {
        for (int i = 0; i < 3; i++) {
            if (board[i][col] != this.player)
                return false;
        }
        return true;
    }

    private boolean checkRightDiagonal() {
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != this.player)
                return false;
        }

        return true;
    }

    private boolean checkLeftDiagonal() {
        for (int i = 0; i < 3; i++) {
            if (board[i][3 - i - 1] != this.player)
                return false;
        }

        return true;
    }

    public boolean hasWon(int row, int col) {
        return checkHorizontal(row) || checkVertical(col) || checkRightDiagonal() || checkLeftDiagonal();
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid Move! Out of Boundary!");
            return false;
        }

        if (this.board[row][col] != '.') {
            System.out.println("Invalid Move! Place already occupied.");
            return false;
        }

        this.board[row][col] = this.player;
        this.noOfMoves++;

        if (noOfMoves == 9) {
            printBoard();
            System.out.println("Match Draw!");
            System.exit(0);
        }

        if (hasWon(row, col)) {
            System.out.println("Player " + this.player + " wins!");
            return true;
        }

        if (this.player == 'X')
            this.player = 'O';
        else
            this.player = 'X';

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
