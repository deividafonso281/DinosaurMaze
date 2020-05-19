import javax.swing.JFrame;

public class DesenhaTabuleiro {

	public static void main (String[] args) {
		Tabuleiro panel = new Tabuleiro();

		JFrame application = new JFrame();

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(600,600);
		application.setVisible(true);
	}
}
