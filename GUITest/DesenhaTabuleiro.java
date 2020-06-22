import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DesenhaTabuleiro {

	public static void main (String[] args) {
		CardLayout cl = new CardLayout();
		JPanel painel = new JPanel();
		Login login = new Login();
		Menu menu = new Menu();
		LeaderBoard l = new LeaderBoard();
		Tabuleiro tab  = new Tabuleiro(painel, cl, login, l, menu);
		JFrame aplicacao = new JFrame("Dinosaur Maze");

		painel.setLayout(cl);
		menu.setReferencias(painel, cl, tab);
		login.setReferencias(painel, cl);
		l.setReferencias(painel, cl, menu);
		painel.add(menu, "1");
		painel.add(tab, "2");
		painel.add(login,"login");
		painel.add(l, "3");
		cl.show(painel, "login");
		aplicacao.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					l.salvaPlacar();
					System.exit(0);
				}
			});
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacao.add(painel);
		aplicacao.setSize(720,850);
		aplicacao.setVisible(true);
	}
}