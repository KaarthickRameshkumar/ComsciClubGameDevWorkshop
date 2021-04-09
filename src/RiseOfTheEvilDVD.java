import javax.swing.JFrame;

public class RiseOfTheEvilDVD {

	public static void main(String[] args) {
		
		//Creates a window and adds a Game Frame Object to it
		JFrame frame = new JFrame("The Rise of The Evil DVDs");
		frame.setSize(900,900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(new GameFrame());
		frame.setVisible(true);

	}

}
