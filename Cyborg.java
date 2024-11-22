package RPG;

public class Cyborg extends Player {
	
	public Cyborg(String name, int health, int shield) {
		super(name, health, shield, "Cyborg");
	}
	
	@Override
	public int calculateDamage(Player target) {
		int baseDamage = 10;
		if (target instanceof Human) {
			baseDamage += 5;
		}
		else if (target instanceof Zombie) {
			baseDamage += 4;
		}
		else if (target instanceof Ape) {
			baseDamage -= 5;
		}
		return baseDamage;
		
	}

}
