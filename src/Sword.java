public class Sword {
    private int swordAttack;
    private int dodgeRating;
    public Sword() {
        swordAttack = 10;
        dodgeRating = 20;
    }

    public void swordUpgrade() {
        swordAttack += 2;
        dodgeRating += 2;
    }

    public int getSwordAttack() {
        return swordAttack;
    }

    public int getDodgeRating() {
        return dodgeRating;
    }
}
