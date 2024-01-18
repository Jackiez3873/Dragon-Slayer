public class Sword {
    private int swordAttack;
    private int dodgeRating;
    public Sword() {
        swordAttack = 10;
        dodgeRating = 20;
    }

    public int getSwordAttack() {
        return swordAttack;
    }

    public int getDodgeRating() {
        return dodgeRating;
    }

    public void swordUpgrade() {
        swordAttack += 4;
        dodgeRating += 4;
    }
}
