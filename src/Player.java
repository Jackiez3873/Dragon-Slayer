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
        topScore = 0;
        this.playerName = playerName;
        playerHealth = 100;
        playerGold = 0;
        hasHealthPotion = false;
        sword = new Sword();
    }

    public int playerAttack() {
        return sword.getSwordAttack() * ((int)(Math.random() * 3) + 1);
    }

    public void playerTakeDamage(int damage) {
        int num = (int) (Math.random() * 100) + 1;
        if (num > sword.getDodgeRating()) {
            playerHealth -= damage;
            System.out.println("You took " + damage + " damage");
        } else {
            System.out.println("You dodged the dragon's attack");
        }
        if(playerHealth <= 0) {
            System.out.println("You died\nGame Over");
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
    public boolean getHasHealthPot() {
        return hasHealthPotion;
    }

    public void setHasHealthPotion(boolean hasHealthPotion) {
        this.hasHealthPotion = hasHealthPotion;
    }

    public void setScore(int playerScore) {
        this.playerScore = playerScore;
        if (playerScore > topScore) {
            topScore = playerScore;
        }
    }
}
