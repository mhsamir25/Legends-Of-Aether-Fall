/*ID: 230042101
 * Name: Mahmudul Hossain Samir
 */
public class CorruptedMortal extends Enemy{


    public CorruptedMortal() {
        super("CorruptedMortal", 90, 90);
    }

    @Override
    public void standardAttack(Character opponent) {
        if (this.getPowerLevel() >= 9) {
            System.out.println(this.getName() + " used attack on " + opponent.getName());
            this.reducePower(9);
            opponent.takeDamage(18);
            System.out.println(this.getName() + " caused 18 damage to " + opponent.getName());
            System.out.println("The power of " + this.getName() + " was reduced by 9");
        } else {
            System.out.println(this.getName() + " tried to attack but didn't have enough power.");
        }
    }

    @Override
    public void specialMove(Character opponent) {
        curse(opponent);
    }

    public void curse(Character opponent) {
        if (this.getPowerLevel() >= 20) {
            System.out.println(this.getName() + " used Special: Curse on " + opponent.getName());
            this.reducePower(20);
            opponent.takeDamage(25);
            System.out.println(this.getName() + " caused 25 damage to " + opponent.getName());
            System.out.println("The power of " + this.getName() + " was reduced by 20");
        } else {
            System.out.println(this.getName() + " tried to use Special move but didn't have enough power.");
        }
    }
}

