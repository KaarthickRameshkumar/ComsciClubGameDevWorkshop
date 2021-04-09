import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class KeyAdapt extends KeyAdapter {
	Player player;
	
	//This class basically just tells the player when a button is pressed and when it is released
	
	public KeyAdapt (Player player) {
		this.player = player;
	}
	
	public void keyPressed (KeyEvent e) {
		player.keyPressed(e);
	}
	
	public void keyReleased (KeyEvent e) {
		player.keyReleased(e);
	}
	
}

     