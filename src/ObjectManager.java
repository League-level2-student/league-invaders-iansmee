import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Random random = new Random();
	Rocketship rocket;
	 ArrayList<Projectile>projectiles = new ArrayList<Projectile>();
	 ArrayList<Alien>aliens = new ArrayList<Alien>();
	ObjectManager(Rocketship rocket){
		this.rocket = rocket;
	}
	
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if(aliens.get(i).y>LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}	
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if(projectiles.get(i).y<0) {
				projectiles.get(i).isActive = false;
			}
		}
	}
	void draw(Graphics g) {
		rocket.draw(g);
		 for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		 for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
