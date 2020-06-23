import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;

public class ScoreListReader {

	private ObjectInputStream entrada;
	private File arquivo = new File("leaderboard.ser");
	
	public void abreArquivo() {
			try {
				entrada = new ObjectInputStream (
					new FileInputStream(arquivo));
			} catch (IOException ioException) {
			}
	}
	
	public ScoreList leListaPlacar() {
		ScoreList listaPlacar = new ScoreList();
		try {
			listaPlacar = (ScoreList) entrada.readObject();
		} catch (IOException ioException) {
			System.err.println("IO");
		} catch (NullPointerException pointerException) {
			System.err.println("Ponteiro nulo");
			listaPlacar = new ScoreList();
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Classe nao encontrada");
		}
		return listaPlacar;
	}
	
	public void fechaArquivo() {
		try {
			if (entrada != null) {
				entrada.close();
			}
		} catch (IOException ioException) {
		}
	}

	public ScoreList getListaPlacar() {
		ScoreList listaPlacar;
		abreArquivo();
		listaPlacar = leListaPlacar();
		fechaArquivo();
		return listaPlacar;
	}
	
	
}
