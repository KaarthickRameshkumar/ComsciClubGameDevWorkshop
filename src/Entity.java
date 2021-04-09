import java.awt.Graphics2D;
//This is the class that all game objects in our game will extend from; basically a barebones skeleton of a game object
public class Entity {
int y, x;
	
	public Entity (int x, int y) {
		//Constructor gives the object coordinates on our screen
		this.x = x;
		this.y = y;
	}
	
	public void update () {
		//This method is called every frame and can be used to change things on our screen
	}
	public void draw (Graphics2D g2d) {
		//This method will be used to draw an image onto our screen
	}
}