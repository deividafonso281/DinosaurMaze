import javax.sound.sampled.*;
import java.io.*;

public class TocadorDeMusica {
	File musica;
	Clip clipe;
	AudioInputStream stream;
	
	public TocadorDeMusica() {
		try {
			musica = new File("musica-fundo.wav");
        		clipe = AudioSystem.getClip();
        		stream = AudioSystem.getAudioInputStream(musica);
			clipe.open(stream);
			clipe.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception ex) {
		}
	}

}
