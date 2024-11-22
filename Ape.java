package RPG;

public class Ape extends Player{
	
	public Ape(String name, int health, int shield) {
		super(name, health, shield, "Ape");
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
		else if (target instanceof Cyborg) {
			baseDamage -= 5;
		}
		return baseDamage;
	}

}
