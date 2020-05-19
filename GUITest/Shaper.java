import javax.swing.JFrame;

public class Shaper {

	public static void main (String[] args) {
		Shapes panel = new Shapes();
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(500,500);
		application.setVisible(true);
	}
}
