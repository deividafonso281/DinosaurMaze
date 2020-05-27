import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;

public class ScoreListReader {

	private ObjectInputStream input;
	private File file = new File("leaderboard.ser");
	
	public void openFile() {
			try {
				input = new ObjectInputStream (
					new FileInputStream(file));
			} catch (IOException ioException) {
			}
	}
	
	public ScoreList readScoreList() {
		ScoreList scoreList = new ScoreList();
		try {
			scoreList = (ScoreList) input.readObject();
		} catch (IOException ioException) {
			System.err.println("IO");
		}  catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Clas Not Found");
		} catch (NullPointerException pointerException) {
			System.err.println("Null Pointer");
		}
		return scoreList;
	}
	
	public void closeFile() {
		try {
			if (input!=null) {
				input.close();
			}
		} catch (IOException ioException) {
		}
	}

	public ScoreList getScoreList() {
		ScoreList scoreList;
		openFile();
		scoreList = readScoreList();
		closeFile();
		return scoreList;
	}
	
	
}
