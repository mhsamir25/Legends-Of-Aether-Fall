/*ID: 230042101
 * Name: Mahmudul Hossain Samir
 */
public class DarkOverlord extends Enemy {


    public DarkOverlord(){
        super("DarkOverlord", 200, 150);
    }
    
    @Override
    public void standardAttack(Character opponent){
        if(this.getPowerLevel()>=17){
            System.out.println(this.getName() + " used attack on "+opponent.getName());
            this.reducePower(17);
            opponent.takeDamage(25);

            System.out.println(this.getName() + " caused 25 damage to " + opponent.getName());
            System.out.println("The power of " + this.getName() + " was reduced by 17");
        } else {
            System.out.println(this.getName() + " tried to attack but didn't have enough power.");
        }
    }

     @Override
    public void specialMove(Character opponent) {
        summonDarkness(opponent);
    }

     public void summonDarkness(Character opponent) {
        if (this.getPowerLevel() >= 40) {
            System.out.println(this.getName() + " used Special: summonDarkness on " + opponent.getName());
            this.reducePower(40);

            opponent.takeDamage(50);
            opponent.setNextAttackWeakened(true);

            System.out.println(this.getName() + " caused 50 damage to " + opponent.getName()+"  and weakened next 3 attacks");
            System.out.println("The power of " + this.getName() + " was reduced by 40");
        } else {
            System.out.println(this.getName() + " tried to use Special move but didn't have enough power.");
        }
    }
}


