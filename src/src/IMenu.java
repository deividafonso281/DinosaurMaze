import java.awt.CardLayout;

import javax.swing.JPanel;

public interface IMenu {
	public void setReferencias(JPanel p, CardLayout c, Tabuleiro tabuleiro);
	public void startTimer();
	public void resetTimer();
}
