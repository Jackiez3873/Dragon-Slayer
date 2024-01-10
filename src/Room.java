public class Room {
    private boolean isSearched;
    private String roomName;
    private String[] room = {"the den", "the cave", "the forest", "the swamp", "the castle"};
    private Player player;
    private boolean roomsCleared;
    public Room(Player player) {
        this.player = player;
        isSearched = false;
    }

    public void enterRoom() {
        roomsCleared = false;
        roomName = room[0];
        String[] newList = new String[room.length - 1];
        int index = 0;
        for(int i = 1; i < room.length; i++) {
            newList[index] = room[i];
            index++;
        }
        room = newList;
        int numDragons = (int)(Math.random() * 3) + 1;
        System.out.println("You entered " + roomName + "\nYou see " + numDragons + " dragons");
        for(int i = 0; i < numDragons; i++) {
            Dragon dragon  = new Dragon(player);
            System.out.println("The dragon is level " + dragon.getDragonLevel() + "\nIt has " + dragon.getDragonHealth() + " health");
            while(dragon.getDragonHealth() >= 0) {
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
                }
            }
        }
        if (room.length == 0) {
            System.out.println("You cleared all the rooms.\nYou Win!");
            roomsCleared = true;
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
