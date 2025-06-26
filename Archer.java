/*ID: 230042101
 * Name: Mahmudul Hossain Samir
 */
import java.util.Scanner;
public class Archer extends Hero{
    public Archer(String name){
        super(name, 100, 100);
    }

    @Override
    public void standardAttack(Character opponent){
        if(this.getPowerLevel()>=8){
            System.out.println(this.getName()+" used attack on "+opponent.getName());
            this.reducePower(8);
            int damage = (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) ? 7 : 15;
            opponent.takeDamage(damage); 
            System.out.println(this.getName()+" caused "+damage+ " damage to " +opponent.getName());
            System.out.println("The power of "+this.getName()+" was reduced by 8");

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Special Move for "+this.getName()+ ": ");
        System.out.println("1. Quick Shot(25 Power, 30 Damage");
        System.out.println("2. Multi Shot(50 Power, 60 Damage)");
        int choice = scanner.nextInt();

        if(choice == 1 ){
            quickShot(opponent);
        }
        else if(choice == 2){
            multiShot(opponent);
        }
        else{
            System.out.println("Invalid choice, Special move skipped");
        }
    }

    public void quickShot(Character opponent){
        if(this.getPowerLevel()>=25){
            System.out.println(this.getName()+" used Quick Shot on "+opponent.getName());
            this.reducePower(25);
            int damage = (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) ? 15 : 30;
            opponent.takeDamage(damage);
            System.out.println(this.getName()+" caused "+damage+ " damage to " +opponent.getName());
            System.out.println("The power of "+this.getName()+" was reduced by 25");

            if (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) {
                reduceWeakenedAttacksRemaining();
                if (getWeakenedAttacksRemaining() == 0) {
                    setNextAttackWeakened(false);
                }
            }
        }
        else{
            System.out.println(this.getName()+" tried to use Special move Quick Shot but didn't have enough power");
        }
    }

    public void multiShot(Character opponent){
        if(this.getPowerLevel()>=50){
            System.out.println(this.getName()+" used Multi Shot on "+opponent.getName());
            this.reducePower(50);
            int damage = (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) ? 30 : 60;
            opponent.takeDamage(damage);
            System.out.println(this.getName()+" caused "+damage+ " damage to " +opponent.getName());
            System.out.println("The power of "+this.getName()+" was reduced by 50");

            if (isNextAttackWeakened() && getWeakenedAttacksRemaining() > 0) {
                reduceWeakenedAttacksRemaining();
                if (getWeakenedAttacksRemaining() == 0) {
                    setNextAttackWeakened(false);
                }
            }
        }
        else{
            System.out.println(this.getName()+" tried to use Special move Multi Shot but didn't have enough power");
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

