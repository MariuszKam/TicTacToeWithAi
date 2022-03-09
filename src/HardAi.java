import java.util.Random;

public class HardAi extends TicTacToe {
    private int x;
    private int y;
    @Override
    public void printGrid() {
        super.printGrid();
    }

    @Override
    public void moveX(String level) {
        System.out.println("Making move level \"" + level + "\"");
        if(emptySquares() == 9) {
            Random random = new Random();
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            matrix[x][y] = 'X';
        } else {
            System.out.println("Minimax here");
            minimaxX(true);
            matrix[x][y] = 'X';
        }
    }

    @Override
    public void moveO(String level) {
        System.out.println("Making move level \"" + level + "\"");
        if(emptySquares() == 8) {
            matrix[1][1] = 'O';
        } else {
            minimaxO(true);
            matrix[x][y] = 'O';
        }

    }

    @Override
    public void startGame() {
        printGrid();
        while (!checkStatus()) {
            if (Menu.players[1].equals("user")) {
                getX();
            } else if(Menu.players[1].equals("easy")) {
                super.moveX("easy");
            } else if(Menu.players[1].equals("medium")){
                super.moveX("medium");
            } else {
                moveX("hard");
            }
            printGrid();
            if(checkStatus()) {
                break;
            }
            if(Menu.players[2].equals("user")) {
                getO();
            } else if(Menu.players[2].equals("easy")) {
                super.moveO("easy");
            } else if(Menu.players[2].equals("medium")) {
                super.moveO("medium");
            } else {
                moveO("hard");
            }
            printGrid();
        }
    }
    private int emptySquares() {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }


    int minimaxX(boolean isMaximizing) {
        char result = checkWinner();
        if (result == 'X') {
            return (emptySquares() + 1);
        } else if (result == 'O') {
            return -1 * (emptySquares() + 1);
        } else if (emptySquares() == 0) {
            return 0;
        }
        if(isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == ' ') {
                        matrix[i][j] = 'X';
                        int score = minimaxX(false);
                        matrix[i][j] = ' ';
                        if(score > bestScore) {
                            bestScore = score;
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == ' ') {
                        matrix[i][j] = 'O';
                        int score = minimaxX(false);
                        matrix[i][j] = ' ';
                        if(score < bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
    }
    int minimaxO(boolean isMaximizing) {
        char result = checkWinner();
        if (result == 'O') {
            return (emptySquares() + 1);
        } else if (result == 'X') {
            return -1 * (emptySquares() + 1);
        } else if (emptySquares() == 0) {
            return 0;
        }
        if(isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == ' ') {
                        matrix[i][j] = 'O';
                        int score = minimaxO(false);
                        matrix[i][j] = ' ';
                        if(score > bestScore) {
                            bestScore = score;
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == ' ') {
                        matrix[i][j] = 'X';
                        int score = minimaxO(false);
                        matrix[i][j] = ' ';
                        if(score < bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
    }
}
