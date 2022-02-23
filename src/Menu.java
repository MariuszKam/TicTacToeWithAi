import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    static final String[] commands = {"start user user", "start easy easy", "start user easy", "start easy user",
            "start user medium", "start medium user", "start easy medium", "start medium easy", "start medium medium",
            "start user hard", "start hard user", "start easy hard", "start hard easy", "start medium hard",
            "start hard medium", "start hard hard", "exit"};
    private static final Scanner scanner = new Scanner(System.in);
    public static String command;
    public static String[] players;

    public static boolean checkCommands() {
        return Arrays.stream(commands).noneMatch(command::matches);
    }

    public static void correctCommand() {
        do {
            System.out.println("Input command: ");
            command = scanner.nextLine();
            if(isExit()) {
                System.exit(0);
            }
            if(Menu.checkCommands()) {
                System.out.println("Bad parameters!");
            }
        }while(Menu.checkCommands());
    }

    public static boolean isExit() {
        return command.equals("exit");
    }

    public static void setPlayers() {
        players = command.split(" ");

    }

    public static Level setLevel() {
        setPlayers();
        if(players[1].equals("hard") || players[2].equals("hard")) {
            return Level.HARD;
        } else if(players[1].equals("medium") || players[2].equals("medium")) {
            return Level.MEDIUM;
        }else {
            return Level.EASY;
        }
    }
}
