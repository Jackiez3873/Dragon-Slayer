public class Room {
    private boolean isSearched;
    private String roomName;
    private static String[] room = {"the den", "the cave", "the forest", "the swamp", "the castle"};
    private Player player;
    public Room(Player player) {
        isSearched = false;
        roomName = room[0];
        String[] newList = new String[room.length - 1];
        int index = 0;
        for(int i = 1; i < room.length; i++) {
            newList[index] = room[i];
            index++;
        }

    }


    public void enterRoom() {
        int numDragons = (int)(Math.random() * 3) + 1;
        System.out.println("You entered " + roomName + "\nYou see " + numDragons + " dragons");
        for(int i = 0; i < numDragons; i++) {
            Dragon dragon  = new Dragon(player);
            System.out.println("The dragon is level " + dragon.getDragonLevel() + "\nIt has " + dragon.getDragonHealth() + " health");
        }
    }

    public void searchRoom() {
        int randNum = (int)(Math.random() * 2) + 1;
        if (randNum == 1) {
            player.setHasHealthPotion(true);
            System.out.println("You found a health pot!");
        } else {
            System.out.println("You found nothing");
        }
    }

}
