import java.awt.Graphics;

public interface ICenario {
	public void desenha(Graphics g);
	public void setVisivel(boolean vis);
	public boolean getVisivel();
	public char qualObjeto();
}
