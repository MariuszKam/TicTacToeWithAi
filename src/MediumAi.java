import java.util.Arrays;

public class MediumAi extends TicTacToe {
    final String[] doubleX = {"XX ", "X X", " XX"};
    final String[] doubleO = {"OO ", "O O", " OO"};
    int x;
    int y;
    @Override
    public void printGrid() {
        super.printGrid();
    }

    @Override
    public void moveX(String level) {
        switch (setMove()) {
            case ATTACK, DEFEND -> {
                System.out.println("Making move level \"" + level + "\"");
                matrix[x][y] = 'X';
            }
            case RANDOM -> super.moveX("medium");
        }
    }

    @Override
    public void moveO(String level) {
        switch (setMove()) {
            case ATTACK, DEFEND -> {
                System.out.println("Making move level \"" + level + "\"");
                matrix[x][y] = 'O';
            }
            case RANDOM -> super.moveO("medium");
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
            } else {
                moveX("medium");
            }
            printGrid();
            if(checkStatus()) {
                break;
            }
            if(Menu.players[2].equals("user")) {
                getO();
            } else if(Menu.players[2].equals("easy")) {
                super.moveO("easy");
            } else {
                moveO("medium");
            }
            printGrid();
        }
    }

    protected boolean checkDoubleX() {
        String diagonalOneX = "" + matrix[0][0] + matrix[1][1] + matrix[2][2];
        String diagonalTwoX = "" + matrix[0][2] + matrix[1][1] + matrix[2][0];
        for(int i = 0; i < matrix.length; i++) {
            StringBuilder checkRowX = new StringBuilder();
            StringBuilder checkColX = new StringBuilder();
            for(int j = 0; j < matrix[i].length; j++) {
                checkRowX.append(matrix[i][j]);
                checkColX.append(matrix[j][i]);
                if(Arrays.stream(doubleX).anyMatch(checkRowX.toString()::matches)) {
                    x = i;
                    y = checkRowX.toString().indexOf(' ');
                    return true;
                } else if(Arrays.stream(doubleX).anyMatch(checkColX.toString()::matches)) {
                    x = checkColX.toString().indexOf(' ');
                    y = i;
                    return true;
                } else if(Arrays.stream(doubleX).anyMatch(diagonalOneX::matches)) {
                    x = diagonalOneX.indexOf(' ');
                    y = diagonalOneX.indexOf(' ');
                    return true;
                } else  if(Arrays.stream(doubleX).anyMatch(diagonalTwoX::matches)) {
                    x = diagonalTwoX.indexOf(' ');
                    if(x == 2) {
                        y = 0;
                    } else if (x == 0) {
                        y = 2;
                    } else if(x == 1) {
                        y = 1;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean checkDoubleO() {
        String diagonalOneO = "" + matrix[0][0] + matrix[1][1] + matrix[2][2];
        String diagonalTwoO = "" + matrix[0][2] + matrix[1][1] + matrix[2][0];
        for(int i = 0; i < matrix.length; i++) {
            StringBuilder checkRowO = new StringBuilder();
            StringBuilder checkColO = new StringBuilder();
            for(int j = 0; j < matrix[i].length; j++) {
                checkRowO.append(matrix[i][j]);
                checkColO.append(matrix[j][i]);
                if(Arrays.stream(doubleO).anyMatch(checkRowO.toString()::matches)) {
                    x = i;
                    y = checkRowO.toString().indexOf(' ');
                    return true;
                } else if(Arrays.stream(doubleO).anyMatch(checkColO.toString()::matches)) {
                    x = checkColO.toString().indexOf(' ');
                    y = i;
                    return true;
                } else if(Arrays.stream(doubleX).anyMatch(diagonalOneO::matches)) {
                    x = diagonalOneO.indexOf(' ');
                    y = diagonalOneO.indexOf(' ');
                    return true;
                } else  if(Arrays.stream(doubleX).anyMatch(diagonalTwoO::matches)) {
                    x = diagonalTwoO.indexOf(' ');
                    if(x == 2) {
                        y = 0;
                    } else if (x == 0) {
                        y = 2;
                    } else if(x == 1) {
                        y = 1;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    protected NextMove setMove() {
            if(Menu.players[1].equals("medium")) {
                if(checkDoubleX()) {
                    return NextMove.ATTACK;
                } else if(checkDoubleO()) {
                    return NextMove.DEFEND;
                }

            }
            if(Menu.players[2].equals("medium")) {
                if(checkDoubleO()) {
                    return NextMove.ATTACK;
                } else if(checkDoubleX()) {
                    return NextMove.DEFEND;
                }
            }
            return NextMove.RANDOM;
    }

}