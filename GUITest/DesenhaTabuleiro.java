import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DesenhaTabuleiro {

	public static void main (String[] args) {
		CardLayout cl = new CardLayout();
		JPanel panelCont = new JPanel();
		Tabuleiro panel = new Tabuleiro();
		Login login = new Login();
		Menu menu = new Menu();
		LeaderBoard leaderBoard = new LeaderBoard();
		JFrame application = new JFrame("Dinosaur Maze");

		panelCont.setLayout(cl);
		menu.setReferences(panelCont, cl, panel);
		login.setReferences(panelCont,cl);
		panel.setReferences(panelCont,cl,login,leaderBoard,menu);
		leaderBoard.setReferences(panelCont,cl,menu);
		panelCont.add(menu, "1");
		panelCont.add(panel, "2");
		panelCont.add(login,"login");
		panelCont.add(leaderBoard,"3");
		cl.show(panelCont, "login");
		application.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					leaderBoard.saveScores();
					System.exit(0);
				}
			});
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panelCont);
		application.setSize(720,850);
		application.setVisible(true);
	}
}
