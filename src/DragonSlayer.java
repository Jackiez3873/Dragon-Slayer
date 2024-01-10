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
        int x = 1;
        while(x == 1) {
            System.out.println("Do you want to enter a room(y/n)?");
            String answer = myScanner.nextLine();
            if (answer.equals("y")) {
                room.enterRoom();
            }
        }
    }
}
