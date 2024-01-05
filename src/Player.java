public class Player {
    private String playerName;
    private int playerHealth;
    private int playerGold;
    private boolean hasHealthPotion;
    private Sword sword;
    public Player(String playerName) {
        this.playerName = playerName;
        playerHealth = 100;
        playerGold = 0;
        hasHealthPotion = false;
        sword = new Sword();
    }

    public void PlayerAttack() {

    }

    public void PlayerTakeDamage() {

    }
}
