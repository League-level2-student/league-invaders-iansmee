import java.awt.Rectangle;

public class GameObject {

	int x;
	int y;
	int width;
	int height;
	int speed = 10;
	boolean isActive = true;
	Rectangle CollisionBox;
	
	GameObject(int x, int y, int width, int height){
		CollisionBox = new Rectangle( x,  y,  width,  height);
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}

	void update() {
		 CollisionBox.setBounds(x, y, width, height);
		
	}

	
	
}
