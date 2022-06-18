
public class Projectile extends GameObject {

	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		int speed = 10;
	}
void update() {
	y -=speed;
}
void draw() {
	
}
}
