/*ID: 230042101
 * Name: Mahmudul Hossain Samir
 */
public abstract class Character {
    private String name;
    private int healthLevel;
    private int powerLevel;
    private boolean isAlive;
    private boolean nextAttackWeakened = false;
    private long blockedUntil = 0;
    private int weakenedAttacksRemaining = 0;

    public Character(String name, int healthLevel, int powerLevel){
        this.name = name;
        this.healthLevel = healthLevel;
        this.powerLevel = powerLevel;
        this.isAlive = true;
    }

    public abstract void standardAttack(Character opponent);
    public abstract void specialMove(Character opponent);

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHealthLevel(){
        return this.healthLevel;
    }

    public void setHealthLevel(int healthLevel){
        this.healthLevel = healthLevel;
        if(this.healthLevel<=0){
            this.healthLevel = 0;
            this.isAlive = false;
        }
    }

    public int getPowerLevel(){
        return this.powerLevel;
    }

    public void setPowerLevel(int powerLevel){
        this.powerLevel = powerLevel;
        if(this.powerLevel<=0){
            this.powerLevel = 0;
        }
    }

    public String getAliveStatus(){
        String condition = this.isAlive? "Alive": "Dead";
        return condition;
    }

    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public boolean isNextAttackWeakened() {
    return this.nextAttackWeakened;
    }

    public int getWeakenedAttacksRemaining(){
        return this.weakenedAttacksRemaining;
    }

    public void setWeakenedAttacksRemaining(int weakenedAttacksRemaining){
        this.weakenedAttacksRemaining = weakenedAttacksRemaining;
    }

    public void reduceWeakenedAttacksRemaining(){
        this.weakenedAttacksRemaining--;
    }

    public void setNextAttackWeakened(boolean status) {
    this.nextAttackWeakened = status;
    }

    public void takeDamage(int damage){
        setHealthLevel(this.healthLevel - damage);
    }

    public void reducePower(int amount){
        setPowerLevel(this.powerLevel - amount);
    }

    public void displayStats(){
       System.out.println("----------Game Stats---------");
       System.out.println(getName()+" - Health: "+getHealthLevel()+", Power: "+getPowerLevel());
    }

    public void blockForSeconds(int seconds) {
    this.blockedUntil = System.currentTimeMillis() + seconds * 1000L;
    }

    public boolean isBlocked() {
        return System.currentTimeMillis() < this.blockedUntil;
    }

    
}
