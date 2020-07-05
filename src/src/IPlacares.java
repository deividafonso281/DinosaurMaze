import java.awt.CardLayout;

import javax.swing.JPanel;

public interface IPlacares {
	public void setReferencias(JPanel painel, CardLayout cl, Menu menu);
	public void addScore(IScore placar);
	public void atualiza();
	public void salvaPlacar();
}
