import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop implements ActionListener {

	private Tabuleiro gamePanel;
	
	public GameLoop (Tabuleiro gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.gamePanel.doOneLoop();
	}
}
