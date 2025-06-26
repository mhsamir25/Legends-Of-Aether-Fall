/*ID: 230042101
 * Name: Mahmudul Hossain Samir
 */
public class RegionalWarLord extends Enemy {
    public RegionalWarLord() {
        super("RegionalWarlord", 130, 110);
    }

    @Override
    public void standardAttack(Character opponent) {
        if (this.getPowerLevel() >= 10) {
            System.out.println(this.getName() + " used attack on " + opponent.getName());
            this.reducePower(10);
            opponent.takeDamage(20);
            System.out.println(this.getName() + " caused 20 damage to " + opponent.getName());
            System.out.println("The power of " + this.getName() + " was reduced by 10");
        } else {
            System.out.println(this.getName() + " tried to attack but didn't have enough power.");
        }
    }

     @Override
    public void specialMove(Character opponent) {
        toxicAura(opponent);
    }

    public void toxicAura(Character opponent) {
        if (this.getPowerLevel() >= 35) {
            System.out.println(this.getName() + " used Special: Toxic Aura on " + opponent.getName());
            this.reducePower(35);
            opponent.takeDamage(30);
            opponent.blockForSeconds(20);  

            System.out.println(this.getName() + " caused 30 damage to " + opponent.getName());
            System.out.println(opponent.getName() + " is blocked from attacking for 20 seconds!");
            System.out.println("The power of " + this.getName() + " was reduced by 35");
        } else {
            System.out.println(this.getName() + " tried to use Special move but didn't have enough power.");
        }
    }

    

}

