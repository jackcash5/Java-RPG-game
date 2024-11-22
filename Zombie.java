package RPG;

public class Zombie extends Player {
	
	public Zombie(String name, int health, int shield) {
		super(name, health, shield, "zombie");
	}
	
	@Override
	public int calculateDamage(Player target) {
		int baseDamage = 10;
		if (target instanceof Human) {
			baseDamage += 5; //zombies deal more damage to humans
		}
		else if (target instanceof Cyborg) {
			baseDamage -= 5;
		}
		else if (target instanceof Ape) {
			baseDamage += 3;
		}
		return baseDamage;
		
		
			
		
	}
	
	
}
	


