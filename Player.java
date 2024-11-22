package RPG;
import java.util.Random;


public class Player {

	//variables
    private String name;
    private int health;
    private int shield;
    private String race;

    // Constructor
    public Player(String name, int health, int shield, String race) {
        this.name = name;
        this.health = health;
        this.shield = shield;
        this.race = race;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getShield() {
        return shield;
    }

    public String getRace() {
        return race;
    }

    // Display stats
    public void displayStats() {
        System.out.println("Player Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Shield: " + shield);
        System.out.println("Race: " + race);
    }
    public void attack(Player target) {
    	Random random = new Random();
    	//random number created to tell if player makes successful attack
    	int hitChance = random.nextInt(100)+ 1;
    	
    	System.out.println(this.name + " attacks " + target.getName() + "!");
        System.out.println("Hit chance roll: " + hitChance);
        
        //Assume 50% success rate for attack (may vary in future depending on difficulty
        if (hitChance <= 50) {
            int damage = calculateDamage(target);

            // Apply damage to shield first, then health
            if (target.shield > 0) {
                int damageToShield = Math.min(damage, target.shield);
                target.shield -= damageToShield;
                damage -= damageToShield;
            }

            if (damage > 0) {
                target.health -= damage;
            }

            System.out.println("Attack successful! " + target.getName() + " takes damage.");
            System.out.println("Remaining Health: " + target.getHealth());
            System.out.println("Remaining Shield: " + target.getShield());
        } else {
            System.out.println("Attack missed!");
        }
    	
    }

    // Default method for calculating damage (can be overridden by subclasses)
    public int calculateDamage(Player target) {
        return 10; // Default damage
    }
}
