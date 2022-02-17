import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class TicTacToe {
    protected final char[][] matrix = new char[3][3];


    Scanner scanner = new Scanner(System.in); //Scanner for class

    public TicTacToe() {
        for (char[] chars : matrix) {
            Arrays.fill(chars, ' ');
        }

    }

    public void printGrid() {
        System.out.println("---------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    protected boolean checkStatus() {
        String diagonalOne = "" + matrix[0][0] + matrix[1][1] + matrix[2][2];
        String diagonalTwo = "" + matrix[0][2] + matrix[1][1] + matrix[2][0];
        int countDraw = 0;
        for (int i = 0; i < matrix.length; i++) {
            String checkRow = "";
            String checkCol = "";
            for (int j = 0; j < matrix[i].length; j++) {
                checkRow = checkRow + matrix[i][j];
                checkCol = checkCol + matrix[j][i];
                if (checkRow.equals("XXX") || checkCol.equals("XXX")) {
                    System.out.println("X wins");
                    return true;
                } else if (checkRow.equals("OOO") || checkCol.equals("OOO")) {
                    System.out.println("O wins");
                    return true;
                } else if (diagonalOne.equals("XXX") || diagonalTwo.equals("XXX")) {
                    System.out.println("X wins");
                    return true;
                } else if (diagonalOne.equals("OOO") || diagonalTwo.equals("OOO")) {
                    System.out.println("O wins");
                    return true;
                } else if (matrix[i][j] == 'X' || matrix[i][j] == 'O') {
                    ++countDraw;
                    if (countDraw == 9) {
                        System.out.println("Draw");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void moveO(String level) {
        boolean move = false;
        Random random = new Random();
        System.out.println("Making move level \"" + level + "\"");
        while (!move) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (matrix[x][y] != 'X' && matrix[x][y] != 'O') {
                matrix[x][y] = 'O';
                move = true;
            }

        }
    }

    public void moveX(String level) {
        boolean move = false;
        Random random = new Random();
        System.out.println("Making move level \"" + level + "\"");
        while (!move) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (matrix[x][y] != 'X' && matrix[x][y] != 'O') {
                matrix[x][y] = 'X';
                move = true;
            }

        }
    }

    public void getX() {
        boolean move = false;
        while (!move) {
            System.out.print("Enter the coordinates: ");
            String cords = scanner.nextLine();
            cords = cords.replaceAll("\\s","");
            if (cords.matches("^[0-9]+$")) {
                if (cords.matches("^[1-3]+$")) {
                    int x = Character.getNumericValue(cords.charAt(0));
                    int y = Character.getNumericValue(cords.charAt(1));
                    if (matrix[x - 1][y - 1] != 'X' && matrix[x -1][y - 1] != 'O') {
                        matrix[x - 1][y - 1] = 'X';
                        move = true;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }

    public void getO() {
        boolean move = false;
        while (!move) {
            System.out.print("Enter the coordinates: ");
            String cords = scanner.nextLine();
            cords = cords.replaceAll("\\s","");
            if (cords.matches("^[0-9]+$")) {
                if (cords.matches("^[1-3]+$")) {
                    int x = Character.getNumericValue(cords.charAt(0));
                    int y = Character.getNumericValue(cords.charAt(1));
                    if (matrix[x - 1][y - 1] != 'X' && matrix[x -1][y - 1] != 'O') {
                        matrix[x - 1][y - 1] = 'O';
                        move = true;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }

    public void startGame() {
        printGrid();
        while (!checkStatus()) {
            if (Menu.players[1].equals("user")) {
                getX();
            }else {
                moveX("");
            }
            printGrid();
            if(checkStatus()) {
                break;
            }
            if(Menu.players[2].equals("user")) {
                getO();
            }else {
                moveO("");
            }
            printGrid();
        }
    }

}
