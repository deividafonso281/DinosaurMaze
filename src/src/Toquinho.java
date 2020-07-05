import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Toquinho extends Cenario {

        private int contador;
	private boolean cresceu;

        public Toquinho (int i, int j) {
                super(i,j,true);
                contador = 0;
		cresceu = false;
                setSrc("toquinho.png");
        }

        public void desenha (Graphics g) {
                super.desenha(g);
        }

        public void setVisivel(boolean vis) {
                super.setVisivel(vis);
        }

        public boolean getVisivel() {
                return super.getVisivel();
        }

        public void setSrc(String src) {
                super.setSrc(src);
        }

        public char qualObjeto() { 
                return 't'; //toda toquinho tem tipo t
        }

	public EstadoDoJogo confere(EstadoDoJogo estado) {
                if (cresceu == false) {
                        if (contador < 19) {
                                contador++;
                        }
                        else {
                                estado.setPeca(posx-1,posy-1,new Tree(posx,posy));
                        }
                }
		return estado;
        }
}    
