public class MediumAi extends TicTacToe {
    @Override
    public void printGrid() {
        super.printGrid();
    }

    @Override
    public void moveX(String level) {
        super.moveX(level);
    }

    @Override
    public void moveO(String level) {
        super.moveO(level);
    }

    @Override
    public void startGame() {
        printGrid();
        while (!checkStatus()) {
            if (Menu.players[1].equals("user")) {
                getX();
            } else if(Menu.players[1].equals("easy")) {
                moveX("easy");
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
                moveO("easy");
            } else {
                moveO("medium");
            }
            printGrid();
        }
    }

    @Override
    protected boolean checkDoubleO() {
        return super.checkDoubleO();
    }

    @Override
    protected boolean checkDoubleX() {
        return super.checkDoubleX();
    }

    @Override
    protected NextMove setMove() {
        return super.setMove();
    }
}