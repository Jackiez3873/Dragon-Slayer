import java.sql.SQLOutput;
import java.util.Scanner;
public class DragonSlayer {
    private Scanner myScanner;
    public DragonSlayer() {
        myScanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to the Dragon Slayer game!");
        int x = 1;
        while(x == 1) {
            System.out.println("What is your name? ");
            String name = myScanner.nextLine();
            Player player = new Player(name);
            Room room = new Room(player);
            System.out.println("MAIN MENU\n1.START NEW GAME\n2.QUIT\n3.VEIW TOP SCORE\n Enter your choice(1,2,3)");
            String number = myScanner.nextLine();
            if(number.equals("1")) {
                System.out.println("Do you want to enter a room(y/n)?");
                String answer = myScanner.nextLine();
                if (answer.equals("y")) {
                    room.enterRoom();
                }
            } else if(number.equals("2")) {
                System.out.println("You quit");
                x = 0;
            } else if(number.equals("3")) {
                System.out.println("Top Score: " + player.getTopScore());
            }

        }
    }
}
