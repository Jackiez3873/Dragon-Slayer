import java.util.Scanner;
public class Room {
    private String[] searchedRooms;
    private String roomName;
    private String[] room = {"the den", "the cave", "the forest", "the swamp", "the castle"}; //list of room names
    private Player player;
    private int roomNumber;
    private boolean roomsCleared;
    private Scanner myScanner;
    public Room(Player player) {
        roomsCleared = false;
        myScanner = new Scanner(System.in);
        roomNumber = 0;
        this.player = player;
        roomsCleared = false;
        searchedRooms = new String[5];
    }

    public void enterRoom() {
        while (roomsCleared == false) {
            roomNumber++;
            roomName = room[0];
            String[] newList = new String[room.length - 1];
            int index = 0;
            for (int i = 1; i < room.length; i++) { //removes a room from the roomList
                newList[index] = room[i];
                index++;
            }
            room = newList;
            int numDragons = (int) (Math.random() * 3) + 1;
            try {
                Thread.sleep(2000);  // 2000 milliseconds, or 2 seconds
            } catch (Exception e) {
                System.out.println("error");
            }
            ConsoleUtility.clearScreen();
            System.out.println("You entered " + ConsoleUtility.CYAN + roomName + ConsoleUtility.RESET + "\n" + numDragons + " dragons spawn");
            for (int i = 0; i < numDragons; i++) { // loop that creates 1 to 3 dragons per room
                Dragon dragon = new Dragon(player);
                System.out.println("The dragon is level " + dragon.getDragonLevel() + "\nIt has " + dragon.getDragonHealth() + " health");
                while (dragon.getDragonHealth() > 0 && player.getPlayerHealth() > 0) {
                    System.out.println("You entered " + ConsoleUtility.CYAN + roomName + ConsoleUtility.RESET + ". Do you want to search the room(s), attack the dragon(a), use a health pot(u), inspect dragon level(i), view current health(h), view current weapon stats(w) (s/a/u/i/h/w)?");
                    String choice = myScanner.nextLine();
                    if (choice.equals("s")) {
                        searchRoom();
                    } else if (choice.equals("a")) {
                        if ((player.getPlayerHealth()) > 0 && (dragon.getDragonHealth() > 0)) {
                            int playerAttack = player.playerAttack();
                            System.out.println("You attack the dragon for " + playerAttack + " damage");
                            dragon.setDragonHealth(dragon.getDragonHealth() - playerAttack);
                            System.out.println("The dragon now has " + ConsoleUtility.RED + dragon.getDragonHealth() + ConsoleUtility.RESET + " health");
                        }
                        if (dragon.getDragonHealth() <= 0) {
                            dragon.deadDragon();
                        } else {
                            player.playerTakeDamage(dragon.dragonAttack());
                            System.out.println("You have " + ConsoleUtility.RED + player.getPlayerHealth() + ConsoleUtility.RESET + " health");
                            if (player.getPlayerHealth() <= 0) {
                                System.out.println(ConsoleUtility.RED + "You died\nGame Over" + ConsoleUtility.RESET);
                            }
                        }
                    } else if (choice.equals("u")) {
                        if (player.getHasHealthPot() == true) {
                            player.useHealthPot();
                            System.out.println("You used a health pot and you now have " + ConsoleUtility.RED + player.getPlayerHealth() + ConsoleUtility.RESET + " health");
                        } else {
                            System.out.println("You don't have a health pot");
                        }
                    } else if (choice.equals("i")) {
                        System.out.println("The dragon is level " + dragon.getDragonLevel());
                    } else if (choice.equals("h")) {
                        System.out.println("You have " + player.getPlayerHealth() + " health");
                    } else if (choice.equals("w")) {
                        System.out.println(player.getPlayerSwordInfo());
                    }
                }
                if (room.length == 0) {
                    roomsCleared = true;
                }
            }
        }
        if (room.length == 0) {
            System.out.println(ConsoleUtility.YELLOW + "You cleared all the rooms.\nYou Win!" + ConsoleUtility.RESET);
        }
        player.recordScore(roomsCleared);
        System.out.println("Your score is " + player.getPlayerScore());
    }
    public void searchRoom() {
        boolean isSearched = false;
        for (int i = 0; i < searchedRooms.length; i++) { //list of rooms that are searched
            if (searchedRooms[i] != null) {
                if (roomName.equals(searchedRooms[i])) {
                    isSearched = true;
                }
            }
        }
        if (isSearched == false) {
            int randNum = (int) (Math.random() * 2) + 1;
            if (randNum == 1) {
                System.out.println("You searched the room and found a health pot!");
                if (player.getHasHealthPot() == true) {
                    System.out.println("You already have a health pot and can only hold one so you decide to use your previous health pot");
                    player.useHealthPot();
                }
                player.setHasHealthPotion(true);
            } else {
                System.out.println("You found nothing");
            }
            searchedRooms[roomNumber - 1] = roomName;
        } else {
            System.out.println("You have already searched this room");
        }
    }

}
