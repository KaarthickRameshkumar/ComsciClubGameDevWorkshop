import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class LevelGate extends Entity{

	public LevelGate(int x, int y) {
		super(x, y);
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

}
