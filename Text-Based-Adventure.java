import java.util.Scanner;

public class SimpleTextRPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int monsterHealth = 50;

        System.out.println("You encounter a monster!");

        while (health > 0 && monsterHealth > 0) {
            System.out.println("Your Health: " + health + " | Monster's Health: " + monsterHealth);
            System.out.println("Choose an action: 1) Attack  2) Heal");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Attack the monster
                int damage = (int) (Math.random() * 20) + 1;
                System.out.println("You dealt " + damage + " damage to the monster.");
                monsterHealth -= damage;
            } else if (choice == 2) {
                // Heal yourself
                int heal = (int) (Math.random() * 15) + 1;
                System.out.println("You healed yourself for " + heal + " health.");
                health += heal;
            }

            // Monster attacks back
            if (monsterHealth > 0) {
                int monsterDamage = (int) (Math.random() * 15) + 1;
                System.out.println("The monster dealt " + monsterDamage + " damage to you.");
                health -= monsterDamage;
            }
        }

        if (health > 0) {
            System.out.println("You defeated the monster!");
        } else {
            System.out.println("You were defeated by the monster.");
        }

        scanner.close();
    }
}
