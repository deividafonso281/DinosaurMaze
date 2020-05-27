import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.CardLayout;

public class Menu extends JPanel {

	private JPanel panelCont;
	private Tabuleiro tabuleiro;
	private JButton buttonJogar;
	private JButton buttonOptions;
	private JButton buttonScoreBoard;
	private JButton buttonLoja;
	private CardLayout cl;
	
	public Menu() {
		setLayout(null);
		buttonJogar = new JButton("Play");
		buttonJogar.setSize(200,50);
		buttonJogar.setLocation(260,300);
		add(buttonJogar);
		buttonJogar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					cl.show(panelCont, "2");
					tabuleiro.requestFocus();
					tabuleiro.startTimer();
				}
			}
		);
		buttonScoreBoard = new JButton("ScoreBoard");
		buttonScoreBoard.setSize(200,50);
		buttonScoreBoard.setLocation(260,400);
		add(buttonScoreBoard);
		buttonScoreBoard.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					cl.show(panelCont, "3");
				}
			}
		);
		buttonLoja = new JButton("Store");
		buttonLoja.setSize(200,50);
		buttonLoja.setLocation(260,500);
		add(buttonLoja);
		buttonLoja.addActionListener (
			new ActionListener() {
				public void actionPerformed (ActionEvent event) {
					;
				}
			}
		);
		buttonOptions = new JButton("Options");
		buttonOptions.setSize(200,50);
		buttonOptions.setLocation(260,600);
		add(buttonOptions);
		buttonOptions.addActionListener(
			new ActionListener() {
				public void actionPerformed (ActionEvent event) {
					;
				}
			}
		);
	}
	
	public void setReferences(JPanel panelCont, CardLayout cardLayout, Tabuleiro tabuleiro) {
		this.panelCont = panelCont;
		this.cl = cardLayout;
		this.tabuleiro = tabuleiro;
		System.out.println("References setadas");
	}
}
