/*ID: 230042101
 * Name: Mahmudul Hossain Samir
 */
public class Warrior extends Hero {

    private boolean isShielded = false;
    public Warrior(String name){
        super(name, 120, 100);
    }
    @Override
    public void standardAttack(Character opponent){
           if(opponent.getHealthLevel()<this.getHealthLevel()){
                isShielded = true;
                System.out.println(this.getName() + "'s shield has been activated");
            }
            else {
                isShielded = false;
                System.out.println(this.getName()+ " could not activate shield");
            }
        if(this.getPowerLevel()>=5){
            System.out.println(this.getName()+" used attack on "+opponent.getName());
            this.reducePower(5);
            int damage = (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) ? 6 : 12;
            opponent.takeDamage(damage);
            System.out.println(this.getName()+" caused "+damage+ " damage to " +opponent.getName());
            System.out.println("The power of "+this.getName()+" was reduced by 5");

            if (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) {
                reduceWeakenedAttacksRemaining();
                if (getWeakenedAttacksRemaining() == 0){
                    setNextAttackWeakened(false);
                }
            }
        }
        else{
            System.out.println(this.getName()+" tried to attack but didn't have enough power");
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (this.isShielded) {
            System.out.println(this.getName() + "'s shield blocked the damage!");
            this.setShielded(false);  
        } else {
            super.takeDamage(damage);
        }
    }

    @Override
    public void specialMove(Character opponent){
        mightyStrike(opponent);
    }

    public void mightyStrike(Character opponent){
        if(this.getPowerLevel()>=35){
            if(opponent.getHealthLevel()<this.getHealthLevel()){
                isShielded = true;
                System.out.println(this.getName() + "'s shield has been activated");
            }
            else {
                isShielded = false;
                System.out.println(this.getName()+ " could not activate shield");
            }
            System.out.println(this.getName()+" used Mighty Strike on "+opponent.getName());
            this.reducePower(35);
            int damage = (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) ? 17 : 35;
            opponent.takeDamage(damage);
            System.out.println(this.getName()+" caused "+damage+ " damage to " +opponent.getName());
            System.out.println("The power of "+this.getName()+" was reduced by 35");
        
            
        }
        else{
            System.out.println(this.getName()+" tried to use Special move Mighty Strike but didn't have enough power");
        }
    }

    public boolean isShielded(){
        return this.isShielded;
    }

    public void setShielded(boolean status){
        this.isShielded = status;
    }

    @Override
    public void setNextAttackWeakened(boolean status) {
        super.setNextAttackWeakened(status);
        if (status) {
            setWeakenedAttacksRemaining(3);
        } else {
            setWeakenedAttacksRemaining(0);
        }
    }

}
