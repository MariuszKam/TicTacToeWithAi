public class Main {
    public static void main(String[] args) {
        TicTacToe game;
        int i = 0;
        do {
            Menu.correctCommand();
            switch (Menu.setLevel()) {
                case MEDIUM -> {
                    game = new MediumAi();
                }
                case EASY -> {
                    game = new EasyAi();
                }
                default -> throw new IllegalStateException("Unexpected value: " + Menu.setLevel());
            }
            game.startGame();
        }while (!Menu.isExit());
    }
}
