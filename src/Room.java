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
        System.out.println("You entered " + roomName);
        int numDragons = (int)(Math.random() * 3) + 1;
        for(int i = 0; i < numDragons; i++) {
            Dragon dragon  = new Dragon(player);
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
