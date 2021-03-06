import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
			final int MENU = 0;
		    final int GAME = 1;
		    final int END = 2;
		    int currentState = MENU;
		    Timer frameDraw;
		    
		    Rocketship rocketship = new Rocketship(250,700,50,50);
		    ObjectManager ObjectManager = new ObjectManager(rocketship);
		    GamePanel(){
		 frameDraw = new Timer(1000/60,this);
		 frameDraw.start();}
		    
	
		   void updateMenuState() {
			   
		   }
		   void updateGameState() {
			   ObjectManager.update();
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
			   g.setColor(Color.BLACK);
			   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			   ObjectManager.draw(g);
		   }
		   void drawEndState(Graphics g)  {
			   g.setColor(Color.RED);
			   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			   g.setFont(titleFont);
			   g.setColor(Color.YELLOW);
			   g.drawString("GAME OVER", 150, 200);
			   g.setFont(other);
			   g.drawString("You Killed Enemies", 150, 400);
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
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		if(currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP && rocketship.y >0) {
			    System.out.println("UP");
			   rocketship.up();
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN && rocketship.y < 750) {
			    System.out.println("DOWN");
			    rocketship.down();
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT && rocketship.x < 450) {
			    System.out.println("RIGHT");
			    rocketship.right();
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT && rocketship.x > 0) {
			    System.out.println("LEFT");
			    rocketship.left();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
