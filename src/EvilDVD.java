import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class EvilDVD extends Entity{
	
	//These variables determine how fast the DVDs move
	int velX, velY;
	//The screen's width and height
	int screenWidth, screenHeight;
	
	public EvilDVD (int x, int y, int screenWidth, int screenHeight){
		super (x,y);
		
		
		//Setting up values for the aforementioned variables
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		
		velX = 5;
		velY = 5;
		
	}
	
	//This function will draw the object, needs a g2d parameter from Game Frame
	public void draw(Graphics2D g2d){
        g2d.drawImage(getObjectImg(),x,y,null);	
	}
	
	//Gets the image file as an image icon, converts to image and returns
	private Image getObjectImg(){
		//Put in a file location in the " " area to an image that you want to display for this entity
        ImageIcon ic =new ImageIcon("YOUR IMAGE FILE ADDRESS GOES HERE");
        return ic.getImage();
	}
	
	// Returns a rectangle which is the size of this game object
	public Rectangle getBounds() {
		 return new Rectangle (x,y,getObjectImg().getWidth(null), getObjectImg().getHeight(null));
	}
	
	//Checks collisions and makes the DVD move
	public void update () {
		x+= velX;
		y+= velY;
		
		
		checkCollision();
	}
	
	
	//Called in update(). Makes the DVD bounce when it hits the edges of the screen
	private void checkCollision() {
		if (x+getObjectImg().getWidth(null) < 20){ 	
            velX*=-1;			
		}
		if (x+getObjectImg().getWidth(null) > screenWidth - 20){ 	
            velX*=-1;		
		}
		if (y+getObjectImg().getHeight(null) > screenHeight - 20){ 	
            velY*=-1;		
		}
		if (y+getObjectImg().getHeight(null) < 20){ 	
            velY*=-1;		
		}
	}
	
}
