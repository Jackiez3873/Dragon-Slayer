import java.util.Scanner;
public class Room {
    private String[] searchedRooms;
    private String roomName;
    private String[] room = {"the den", "the cave", "the forest", "the swamp", "the castle"};
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
        while(roomsCleared == false) {
            roomNumber++;
            roomName = room[0];
            String[] newList = new String[room.length - 1];
            int index = 0;
            for (int i = 1; i < room.length; i++) {
                newList[index] = room[i];
                index++;
            }
            room = newList;
            int numDragons = (int) (Math.random() * 3) + 1;
            System.out.println("You entered " + roomName + "\nYou see " + numDragons + " dragons");
            for (int i = 0; i < numDragons; i++) {
                Dragon dragon = new Dragon(player);
                System.out.println("The dragon is level " + dragon.getDragonLevel() + "\nIt has " + dragon.getDragonHealth() + " health");
                while (dragon.getDragonHealth() > 0) {
                    System.out.println("You entered " + roomName + ". Do you want to search the room, attack the dragon or use a health pot(s/a/u)?");
                    String choice = myScanner.nextLine();
                    if (choice.equals("s")) {
                        searchRoom();
                    } else if (choice.equals("a")) {
                        if ((player.getPlayerHealth()) > 0 && (dragon.getDragonHealth() > 0)) {
                            int playerAttack = player.playerAttack();
                            System.out.println("You attack the dragon for " + playerAttack + " damage");
                            dragon.setDragonHealth(dragon.getDragonHealth() - playerAttack);
                            System.out.println("The dragon now has " + dragon.getDragonHealth() + " health");
                        }
                        if (dragon.getDragonHealth() <= 0) {
                            dragon.deadDragon();
                        } else {
                            player.playerTakeDamage(dragon.dragonAttack());
                            System.out.println("You have " + player.getPlayerHealth() + " health");
                            if(player.getPlayerHealth() <= 0) {
                                System.out.println("You died\nGame Over");
                            }
                        }
                    } else if (choice.equals("u")) {
                        if(player.getHasHealthPot() == true) {
                            player.useHealthPot();
                        } else {
                            System.out.println("You don't have a health pot");
                        }
                    }

                }
            }
            if (room.length == 0) {
                System.out.println("You cleared all the rooms.\nYou Win!");
                roomsCleared = true;

            }
        }
        player.recordScore(roomsCleared);
    }

    public void searchRoom() {
        boolean isSearched = false;
        for (int i  = 0; i < searchedRooms.length; i++) {
            if(searchedRooms[i] != null) {
                if(roomName.equals(searchedRooms[i])) {
                    isSearched = true;
                }
            }
        }
        if (isSearched == false) {
            int randNum = (int)(Math.random() * 2) + 1;
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
