import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
			final int MENU = 0;
		    final int GAME = 1;
		    final int END = 2;
		    int currentState = MENU;
		    Timer frameDraw;
		    Timer alienSpawn;
		    public static BufferedImage image;
		    public static boolean needImage = true;
		    public static boolean gotImage = false;	
		    
		    Rocketship rocketship = new Rocketship(250,700,50,50);
		    ObjectManager ObjectManager = new ObjectManager(rocketship);
		    GamePanel(){
		    	
		 frameDraw = new Timer(1000/60,this);
		 frameDraw.start();
		 if (needImage) {
			    loadImage ("space.png");
			}
		    }
		    void startGame(){
		    	alienSpawn = new Timer(1000 , ObjectManager);
		        alienSpawn.start();
		        
		    } 
		    
		    
		    void loadImage(String imageFile) {
		        if (needImage) {
		            try {
		                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    	    gotImage = true;
		            } catch (Exception e) {
		                
		            }
		            needImage = false;
		        }
		    }
		   void updateMenuState() {
			   
		   }
		   void updateGameState() {
			   ObjectManager.update();
			   if(ObjectManager.rocket.isActive == false) {
				   currentState = END;
			   }
		   }
		   void updateEndState()  {
			   
		   }
		   void drawMenuState(Graphics g) {
			   g.setColor(Color.BLUE);
			   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			   g.setFont(titleFont);
			   g.setColor(Color.YELLOW);
			   g.drawString("League Invaders", 100, 200);
			   g.setFont(other);
			   g.drawString("press ENTER to start", 100, 400);
			   g.drawString("Press SPACE to restart", 100, 600);
		   }
		   void drawGameState(Graphics g) {
			   if (gotImage) {
					g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
				} else {
					g.setColor(Color.BLACK);
			   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
					
				}
			   
			   ObjectManager.draw(g);
		   }
		   void drawEndState(Graphics g)  {
			   g.setColor(Color.RED);
			   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			   g.setFont(titleFont);
			   g.setColor(Color.YELLOW);
			   g.drawString("GAME OVER", 150, 200);
			   g.setFont(other);
			   g.drawString("You Killed " +ObjectManager.getScore()+" Enemies", 150, 400);
			   g.drawString("Press ENTER to restart", 150, 600);
			   
		   }
	
		   
		   
		   Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font other = new Font("Arial", Font.PLAIN, 30);
	
	
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			ObjectManager.addProjectile(rocketship.getProjectile());
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    
		    if (currentState == END) {
		    	rocketship = new Rocketship(250,700,50,50);
		    	ObjectManager = new ObjectManager(rocketship);
		        currentState = MENU;
		    } else {
		        currentState++;
		        if(currentState == GAME) {
		        	startGame(); 
		        }
		    }
		    
		}   
		if(currentState == GAME) {
	        	
	        
			if (e.getKeyCode()==KeyEvent.VK_UP && rocketship.y >0) {
			    
			   rocketship.up();
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN && rocketship.y < 750) {
			   
			    rocketship.down();
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT && rocketship.x < 450) {
			    
			    rocketship.right();
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT && rocketship.x > 0) {
			    
			    rocketship.left();
			}
		}
		if(currentState == 2) {
			alienSpawn.stop();
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
