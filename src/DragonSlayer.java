import java.sql.SQLOutput;
import java.util.Scanner;
public class DragonSlayer {
    private Scanner myScanner;
    public DragonSlayer() {
        myScanner = new Scanner(System.in);
    }
    public void play() {
        System.out.println(ConsoleUtility.BLUE + "Welcome to the Dragon Slayer game!" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.BLUE + "What is your name? " + ConsoleUtility.RESET);
        String name = myScanner.nextLine();
        int x = 1;
        while(x == 1) {
            Player player = new Player(name);
            Room room = new Room(player);
            try {
                Thread.sleep(2000);  // 2000 milliseconds, or 2 seconds
            } catch (Exception e) {
                System.out.println("error");
            }
            ConsoleUtility.clearScreen();
            System.out.println(ConsoleUtility.GREEN + "MAIN MENU\n1.START NEW GAME\n2.QUIT\n3.VEIW TOP SCORE\n Enter your choice(1,2,3)" + ConsoleUtility.RESET);
            String number = myScanner.nextLine();
            if(number.equals("1")) {
                System.out.println(ConsoleUtility.BLUE + "Do you want to enter a room(y/n)(You will automatically move to the next room when you beat a room)?" + ConsoleUtility.RESET);
                String answer = myScanner.nextLine();
                if (answer.equals("y")) {
                    room.enterRoom();
                }
            } else if(number.equals("2")) {
                System.out.println(ConsoleUtility.BLUE + "You quit" + ConsoleUtility.RESET);
                x = 0;
            } else if(number.equals("3")) {
                System.out.println(ConsoleUtility.BLUE + "Top Score: " + player.getTopScore() + ConsoleUtility.RESET);
            }
        }
    }
}
