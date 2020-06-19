import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;

public class ScoreListWritter {

	private ObjectOutputStream output;
	private File file = new File("leaderboard.ser");
	
	public void openFile() {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ioException) {
			}
		}
		try {
			output = new ObjectOutputStream(
			new FileOutputStream(file));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
		}
	}
	
	public void writeScoreList(ScoreList scoreList) {
		try {
			output.writeObject(scoreList);
		} catch (IOException ioExeception) {
		}
		catch (NoSuchElementException elementException) {
		}
	}
	
	public void closeFile() {
		try {
			if (output!=null) {
				output.close();
			}
		}catch(IOException ioException) {
		}
	}

	public void saveScoreList(ScoreList scoreList) {
		System.out.println("Method called");
		openFile();
		writeScoreList(scoreList);
		closeFile();
	}

}
