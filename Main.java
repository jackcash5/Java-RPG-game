package RPG;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//welcome messages
		System.out.println("Welcome to my RPG traveller!");
		System.out.println("The first step in your journey is creating your hero");
		
		// Get character name
        System.out.print("Enter your character's name: ");
        String name = scan.nextLine();
        
		//get character details
		System.out.println("Choose your race");
		System.out.println("1. Human");
        System.out.println("2. Zombie");
        System.out.println("3. Cyborg");
        System.out.println("4. Ape");
        
        int raceChoice = 0;
        String race = "";
        while (raceChoice < 1 || raceChoice > 4) {
            System.out.print("Enter a number (1-4): ");
            raceChoice = scan.nextInt();
            switch (raceChoice) {
                case 1 -> race = "Human";
                case 2 -> race = "Zombie";
                case 3 -> race = "Cyborg";
                case 4 -> race = "Ape";
                default -> System.out.println("Invalid choice. Please choose a valid race.");
            }
        }
        
        // Set initial health and shield
        System.out.print("Enter your character's starting health (e.g., 100): ");
        int health = scan.nextInt();

        System.out.print("Enter your character's starting shield (e.g., 50): ");
        int shield = scan.nextInt();

        // Create player object
        Player player;
        switch (race) {
            case "Human" -> player = new Human(name, health, shield);
            case "Zombie" -> player = new Zombie(name, health, shield);
            case "Cyborg" -> player = new Cyborg(name, health, shield);
            case "Ape" -> player = new Ape(name, health, shield);
            default -> throw new IllegalStateException("Unexpected value: " + race);
        }
        
        // Example enemy
        Player enemy = new Ape("ZingBot", 52, 24);

        // Game loop
        System.out.println("\nA new enemy has appeared: " + enemy.getName());
        enemy.displayStats();

        while (enemy.getHealth() > 0) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Attack the enemy");
            System.out.println("2. Run away");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            if (choice == 1) {
                player.attack(enemy); // Player attacks the enemy
                if (enemy.getHealth() <= 0) {
                    System.out.println("You have defeated " + enemy.getName() + "!");
                    break;
                }
            } else if (choice == 2) {
                System.out.println("You ran away from the fight!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("\nGame Over. Thank you for playing!");
        scan.close();
        

        // Display created character stats
        System.out.println("\nCharacter created successfully!");
        player.displayStats();
		

	}
	

}
