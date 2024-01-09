import java.util.Scanner;
public class DragonSlayer {
    private Scanner myScanner;
    public DragonSlayer() {
        myScanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to the Dragon Slayer game!");
        System.out.println("What is your name? ");
        String name = myScanner.nextLine();
        Player player = new Player(name);
        Room room = new Room(player);
        room.enterRoom();
    }
}
