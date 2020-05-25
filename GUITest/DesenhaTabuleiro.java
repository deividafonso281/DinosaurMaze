import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class DesenhaTabuleiro {

	public static void main (String[] args) {
		CardLayout cl = new CardLayout();
		JPanel panelCont = new JPanel();
		Tabuleiro panel = new Tabuleiro();
		Menu menu = new Menu();
		JFrame application = new JFrame("Dinosaur Maze");

		panelCont.setLayout(cl);
		menu.setReferences(panelCont, cl, panel);
		panelCont.add(menu, "1");
		panelCont.add(panel, "2");
		cl.show(panelCont, "1");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panelCont);
		//application.add(panel);
		application.setSize(720,850);
		application.setVisible(true);
	}
}
