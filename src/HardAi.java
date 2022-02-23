public class HardAi extends TicTacToe {
    @Override
    public void printGrid() {
        super.printGrid();
    }

    @Override
    public void moveX(String level) {
        super.moveX("hard");
    }

    @Override
    public void moveO(String level) {
        super.moveO("hard");
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
                moveX("hard");
            }
            printGrid();
        }
    }
}
