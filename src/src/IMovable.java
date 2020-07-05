import java.awt.Graphics;

public interface IMovable {
	public void move();
	public void viraDireita();
	public void viraEsquerda();
	public int[] getDireita();
	public int[] getEsquerda();
	public int[] getAtual();
	public int[] getProx();
	public void desenha(Graphics g);
	public EstadoDoJogo interacao (EstadoDoJogo estado);
}
