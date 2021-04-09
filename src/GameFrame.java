import java.awt.Graphics;

import java.awt.Graphics2D;		
import java.awt.event.ActionEvent;      
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;		
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener {
	
	//The entities in the game
	public static Player player;
	private Timer mainTimer;
	public static ArrayList <EvilDVD> dvds = new ArrayList<EvilDVD>();
	public static LevelGate gate;
	
	//The screen's width and height
	static int screenWidth;
	static int screenHeight;
	
	public GameFrame () {
		//I do not know why this line is here, but if it is not here then the game will not work
		setFocusable (true);
		
		//Initializing the screen width and height
		screenWidth = 900;
		screenHeight = 900;
		
		//Changing the size of the DVD image
		try {
			ImageResizer.resize("ORIGINAL IMAGE FILE ADDRESS","NEW FILE ADDRESS FOR RESIZED IMAGE",0.05);
		}catch(IOException e) {
			System.out.println("You gave a wrong image address");
		}
		
		//Initializing all the entities
		gate = new LevelGate ((int)(Math.random()*(screenWidth-299)+150),(int)(Math.random()*(screenHeight-299)+150));
		
		EvilDVD tempDVD = new EvilDVD ((int)(Math.random()*(screenWidth-299)+150),(int)(Math.random()*(screenHeight-299)+150), screenWidth, screenHeight);
		dvds.add(tempDVD);
		
		player = new Player (300,300, screenWidth, screenHeight);
		addKeyListener(new KeyAdapt(player));
		
		//Starting a timer used for the Actionlistener. Make this last to prevent any null pointer exceptions
		mainTimer = new Timer(1 ,this);
		mainTimer.start();
	}
	
	//Goes off every millisecond with the Timer. Updates and redraws all entities specified
	public void actionPerformed (ActionEvent arg0) {
		player.update();
		
		for(int i = 0;i<dvds.size();i++) {
			EvilDVD tempDVD = dvds.get(i);
			tempDVD.update();
		}
		repaint();
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		
        Graphics2D g2d  = (Graphics2D) g;
        
        player.draw(g2d);
        
        for(int i = 0;i<dvds.size();i++) {
        	EvilDVD tempDVD = dvds.get(i);
        	tempDVD.draw(g2d);
        }
        
        gate.draw(g2d);
        
	}
	
	//Adds another DVD and a new level gate
	public static void newLevel () {
		EvilDVD tempDVD = new EvilDVD ((int)(Math.random()*(screenWidth-99)+50),(int)(Math.random()*(screenHeight-99)+50), screenWidth, screenHeight);
		dvds.add(tempDVD);
		
		gate = new LevelGate ((int)(Math.random()*(screenWidth-99)+50),(int)(Math.random()*(screenHeight-99)+50));
	}

}
