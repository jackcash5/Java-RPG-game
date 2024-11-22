package RPG;

public class Human extends Player{
	
	  public Human(String name, int health, int shield) {
	        super(name, health, shield, "Human");
	    }
	  
	  //override human damage against certain players
	  
	  @Override
	    public int calculateDamage(Player target) {
	        int baseDamage = 10;  // Default damage
	        if (target instanceof Zombie) {
	            baseDamage += 5;  // Humans deal extra damage to Zombies
	        } else if (target instanceof Ape) {
	            baseDamage += 5;  // Humans deal extra damage to Apes
	        } else if (target instanceof Cyborg) {
	            baseDamage -= 3;  // Humans deal less damage to Cyborgs
	        }
	        return baseDamage;

}
}
