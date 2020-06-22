import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop implements ActionListener {

	private Tabuleiro painelJogo;
	
	public GameLoop (Tabuleiro painelJogo) {
		this.painelJogo = painelJogo;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.painelJogo.daUmLoop();
	}
}
