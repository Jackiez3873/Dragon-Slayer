public class Player {
    private String playerName;
    private int playerHealth;
    private int playerGold;

    private static int topScore;
    private int playerScore;
    private boolean hasHealthPotion;
    private Sword sword;

    private Dragon dragon;
    public Player(String playerName) {
        this.playerName = playerName;
        playerHealth = 100;
        playerGold = 0;
        hasHealthPotion = false;
        sword = new Sword();
    }

    public int playerAttack() {
        return sword.getSwordAttack() * ((int)(Math.random() * 3));
    }

    public void playerTakeDamage() {
        int num = (int) (Math.random() * 100) + 1;
        if (num > sword.getDodgeRating()) {
            playerHealth -= dragon.dragonAttack();
            System.out.println("You took " + dragon.dragonAttack() + " damage");
        } else {
            System.out.println("You dodged the dragon's attack");
        }
    }

    public int getPlayerGold() {
        return playerGold;
    }

    public void setPlayerGold(int playerGold) {
        this.playerGold = playerGold;
    }

    public Sword getSword() {
        return sword;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public void setHasHealthPotion(boolean hasHealthPotion) {
        this.hasHealthPotion = hasHealthPotion;
    }
}
