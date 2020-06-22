import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;

public class ScoreListWritter {

	private ObjectOutputStream saida;
	private File arquivo = new File("leaderboard.ser");
	
	public void abrirArquivo() {
		if (!arquivo.exists()) {
			try {
				arquivo.createNewFile();
			} catch (IOException ioException) {
			}
		}
		try {
			saida = new ObjectOutputStream(
			new FileOutputStream(arquivo));
		} catch (IOException ioException) {
			System.err.println("Erro ao abrir o arquivo.");
		}
	}
	
	public void escreveListaPlacar (ScoreList listaPontos) {
		try {
			saida.writeObject(listaPontos);
		} catch (IOException ioExeception) {
		}
		catch (NoSuchElementException elementException) {
		}
	}
	
	public void fechaArquivo() {
		try {
			if (saida != null) {
				saida.close();
			}
		}catch(IOException ioException) {
		}
	}

	public void salvaListaPlacar (ScoreList listaPlacar) {
		System.out.println("Metodo chamado");
		abrirArquivo();
		escreveListaPlacar(listaPlacar);
		fechaArquivo();
	}

}
