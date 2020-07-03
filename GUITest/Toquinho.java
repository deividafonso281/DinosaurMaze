import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Toquinho extends Cenario {

        private int contador;

        public Toquinho (int i, int j) {
                super(i,j,true);
                contador = 0;
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
}    
