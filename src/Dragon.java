public class Dragon {
    private int dragonHealth;
    private int dragonLevel;
    private static Player player;
    public Dragon(Player player) {
        dragonLevel = (int) (Math.random() * 3) + 1;
        dragonHealth = 100;
        this.player = player;
    }

    public int dragonAttack() {
        return dragonLevel *((int)(Math.random() * 5) + 2);
    }

    public void dragonTakeDamage() {
        dragonHealth -= player.playerAttack();
        if (dragonHealth <= 0) {
            System.out.println("You killed a dragon");
            deadDragon();
        }
    }

    public void deadDragon() {
        int randomNum = (int) (Math.random() * 4) + 1;
        int goldAmount = (int) (Math.random() * 51) + 25;
        if (randomNum == 1) {
            player.setPlayerGold(player.getPlayerGold() + goldAmount);
            System.out.println("You got " + goldAmount + " gold");
        } else if (randomNum == 2) {
            player.getSword().swordUpgrade();
            System.out.println("You got a sword upgrade and upgraded your sword");
        } else if (randomNum == 3) {
            player.useHealthPot();
            System.out.println("You got a health bonus and your new health is " + player.getPlayerHealth());
        } else {
            System.out.println("You got nothing");
        }
    }

    public int getDragonLevel() {
        return dragonLevel;
    }

    public int getDragonHealth() {
        return dragonHealth;
    }

    public void setDragonHealth(int dragonHealth) {
        this.dragonHealth = dragonHealth;
    }
}
