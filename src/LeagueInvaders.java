import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
public static final int WIDTH = 500;
public static final int HEIGHT = 800;
void setup(){
	GamePanel panel = new GamePanel();
	frame.add(panel);
	frame.setVisible(true);
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
}
