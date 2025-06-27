/* ID: 230042101
 * Name: Mahmudul Hossain Samir
 */
//JUST FELT LIKE GIVING A RANDOM COMMENT   
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a character: 1. Mage 2. Archer 3. Warrior");
        int heroChoice = scanner.nextInt();
        scanner.nextLine(); 

        while (heroChoice < 1 || heroChoice > 3) {
            System.out.println("Invalid choice. Please choose: 1. Mage 2. Archer 3. Warrior");
            heroChoice = scanner.nextInt();
            scanner.nextLine();
        }

        String heroType = heroChoice == 1 ? "Mage" : heroChoice == 2 ? "Archer" : "Warrior";
        System.out.println("You've chosen " + heroType);
        System.out.println("Enter your " + heroType.toLowerCase() + " name");
        String heroName = scanner.nextLine();

        Hero hero;
        if (heroChoice == 1) {
            hero = new Mage(heroName);
        } else if (heroChoice == 2) {
            hero = new Archer(heroName);
        } else {
            hero = new Warrior(heroName);
        }

        System.out.println("Choose a villain to fight against:");
        System.out.println("1. Dark Overlord");
        System.out.println("2. Regional Warlord");
        System.out.println("3. Corrupted Mortal");
        int enemyChoice = scanner.nextInt();
        scanner.nextLine(); 

        while (enemyChoice < 1 || enemyChoice > 3) {
            System.out.println("Invalid choice. Please choose: 1. Dark Overlord 2. Regional Warlord 3. Corrupted Mortal");
            enemyChoice = scanner.nextInt();
            scanner.nextLine();
        }

        Enemy enemy;
        if (enemyChoice == 1) {
            enemy = new DarkOverlord();
        } else if (enemyChoice == 2) {
            enemy = new RegionalWarLord();
        } else {
            enemy = new CorruptedMortal();
        }

        System.out.println(hero.getName() + " the " + heroType + " enters the world of Aetherfall!");
        System.out.println(enemy.getName() + " rises to spread chaos!");
        System.out.println("Battle Start!");

        boolean isHeroTurn = true;
        while (hero.getHealthLevel() > 0 && enemy.getHealthLevel() > 0) {
            if (isHeroTurn) {
                if (hero.isBlocked()) {
                    System.out.println(hero.getName() + " is blocked and cannot attack!");
                } else {
                    System.out.print("> ");
                    String action = scanner.nextLine().trim().toLowerCase();

                    if (action.equals("attack")) { 
                        if (hero.isNextAttackWeakened()) {
                            System.out.println(hero.getName() + "'s attack is weakened!");
                        }
                        hero.standardAttack(enemy);
                    } else if (action.equals("special")) {
                        if (hero.isNextAttackWeakened()) {
                            System.out.println(hero.getName() + "'s attack is weakened!");
                        }
                        hero.specialMove(enemy);
                    } else {
                        System.out.println("Invalid action. Please enter 'attack' or 'special'");
                        continue; 
                    }
                }
            } else {
                System.out.println("Enemy Attacks");
                if (enemy.getPowerLevel() >= (enemy instanceof DarkOverlord ? 40 : enemy instanceof RegionalWarLord ? 35 : 20) && Math.random() > 0.5) {
                    enemy.specialMove(hero);
                } else {
                    enemy.standardAttack(hero);
                }
            }

            hero.displayStats();
            enemy.displayStats();

            if (hero.getHealthLevel() <= 0) {
                System.out.println("-------- Results --------");
                System.out.println(enemy.getName() + " wins the battle!");
                System.out.println(hero.getName() + " the " + heroType.toLowerCase() + " has been defeated!");
                break;
            } else if (enemy.getHealthLevel() <= 0) {
                System.out.println("-------- Results --------");
                System.out.println(enemy.getName() + " has been defeated!");
                System.out.println(hero.getName() + " wins!");
                break;
            }

            isHeroTurn = !isHeroTurn;
        }

        scanner.close();
    }
}
