import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;



public class Player extends Entity{
	
	//This array will store the keys that are currently pressed
	static boolean [] keys;
	//Variable for how fast the player moves given key input
	private int speed;
	
	//The window's width and height
	int screenWidth, screenHeight;
	
	//Constructor initializes all variables
	public Player (int x, int y, int screenWidth, int screenHeight) {
		super (x,y);
		
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		
		keys = new boolean [120];
		speed = 10;
	}
	
	//This function will draw the object, needs a g2d parameter from Game Frame
	public void draw(Graphics2D g2d){
        g2d.drawImage(getObjectImg(),x,y,null);
	}
	
	//Gets the image file as an image icon, converts to image and returns
	private Image getObjectImg(){
		//Put in a file location in the " " area to an image that you want to display for this entity
        ImageIcon ic =new ImageIcon("YOUR IMAGE ADDRESS GOES HERE");
        return ic.getImage();
	}
	
	// Returns a rectangle which is the size of this game object
	public Rectangle getBounds() {
		 return new Rectangle (x,y,getObjectImg().getWidth(null), getObjectImg().getHeight(null));
	}
	
	//Checks collisions and makes the player move given keyboard input
	public void update () {
		checkCollisions();
		if (keys[KeyEvent.VK_W]||keys[KeyEvent.VK_UP]) {
            y -= speed;
        } 
        else if (keys[KeyEvent.VK_S]||keys[KeyEvent.VK_DOWN]) {
        	y += speed;
        } 
        else if (keys[KeyEvent.VK_D]||keys[KeyEvent.VK_RIGHT]) {
        	x+= speed;
        } 
        else if (keys[KeyEvent.VK_A]||keys[KeyEvent.VK_LEFT]) {
        	x -= speed;
        }
	}
	
	//Stops the player from moving past screen edges. Ends game if player collides with DVD
	private void checkCollisions() {
		if (x+getObjectImg().getWidth(null) < 20){ 	
            x+=30;			
		}
		if (x+getObjectImg().getWidth(null) > screenWidth - 20){ 	
            x-=30;			
		}
		if (y+getObjectImg().getHeight(null) > screenHeight - 20){ 	
            y-=30;			
		}
		if (y+getObjectImg().getHeight(null) < 20){ 	
            y+=30;			
		}
		
		for(int i = 0;i<GameFrame.dvds.size();i++) {
			EvilDVD tempDVD = GameFrame.dvds.get(i);
			if(getBounds().intersects(tempDVD.getBounds())) {
				System.exit(0);
			}
		}
		
		if(getBounds().intersects(GameFrame.gate.getBounds())) {
			GameFrame.newLevel();
		}
	}
	
	//Following two methods detect key presses and releases and make the index corresponding to their key code true in the keys bool array
	public void keyPressed(KeyEvent e) {	
		keys[e.getKeyCode()] = true;	        
	}
	
	public void keyReleased(KeyEvent e) {
	    keys[e.getKeyCode()] = false;
	}
	
}
