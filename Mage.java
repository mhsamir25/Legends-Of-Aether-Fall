/*ID: 230042101
 * Name: Mahmudul Hossain Samir
 */
public class Mage extends Hero{

    public Mage(String name){
        super(name, 80, 100);
    }

    @Override
    public void standardAttack(Character opponent){
        if(this.getPowerLevel()>=10){
            System.out.println(this.getName()+" used attack on "+opponent.getName());
            this.reducePower(10);
            int damage = (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) ? 10 : 20;
            opponent.takeDamage(damage);
            System.out.println(this.getName()+" caused "+damage+ " damage to " +opponent.getName());
            System.out.println("The power of "+this.getName()+" was reduced by 10");
            
            if (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) {
                reduceWeakenedAttacksRemaining();
                if (getWeakenedAttacksRemaining() == 0) {
                    setNextAttackWeakened(false);
                }
            }
        }

        else{
            System.out.println(this.getName()+" tried to attack but didn't have enough power");
        }
    }

    @Override
    public void specialMove(Character opponent){
        castSpell(opponent);
    }

    public void castSpell(Character opponent){
        if(this.getPowerLevel()>=30){
            System.out.println(this.getName()+" used Special move CastSpell on "+opponent.getName());
            this.reducePower(30);
            int damage = (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) ? 20 : 40;
            opponent.takeDamage(damage);
            System.out.println(this.getName()+" caused "+damage+" damage to  "+opponent.getName());
            System.out.println("The power of "+this.getName()+" was reduced by 30");
            if (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) {
                reduceWeakenedAttacksRemaining();
                if (getWeakenedAttacksRemaining() == 0) {
                    setNextAttackWeakened(false);
                }
            }
        }

        else{
            System.out.println(this.getName()+" tried to use Special but didn't have enough power");
        }
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