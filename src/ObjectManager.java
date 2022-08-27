import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager implements ActionListener {
Random random = new Random();
	Rocketship rocket;
	
	int score = 0;
	
	 ArrayList<Projectile>projectiles = new ArrayList<Projectile>();
	 ArrayList<Alien>aliens = new ArrayList<Alien>();
	ObjectManager(Rocketship rocket){
		this.rocket = rocket;
	}
	int getScore() {
		return score;
	}
	
	
	void checkCollision(){
		for (int i = 0; i < aliens.size(); i++) {
			if(rocket.CollisionBox.intersects(aliens.get(i).CollisionBox)) {
				aliens.get(i).isActive = false;
				rocket.isActive = false;
			}
			for (int j = 0; j < projectiles.size(); j++) {
				if(projectiles.get(j).CollisionBox.intersects(aliens.get(i).CollisionBox)) {
					aliens.get(i).isActive = false;
					projectiles.get(j).isActive = false;
					score ++;
				}
			}
		}
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
		}checkCollision();
				purgeObjects();
				
				rocket.update();
				
				
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
