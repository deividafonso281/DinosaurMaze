import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeaderBoard {

	private Score[] positions = new Score[15];
	private capacity = 15;
	private length = 0;
	
	private ObjectInputStream input;

	public void openFile () {
		try {
			input = new ObjectInputStream(new FileInputStream("leaderboard.ser"));
		}catch (IOException ioException){
			System.err.println("Error opening file.");
		}
	}

	public void getLeaderBoard () {
		try {
			while (true) {
				Score[this.length] = (Score) input.readObject();
				this.length++;
			}
		} catch (EOFException endOfFileException) {
			return;
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Unable to create object.");
		} catch (IOException ioException) {
			System.err.println("Error during read from file.");
		}
	}

	public void closeFile() {
		try {
			if (input!=null) {
				input.close();
			}
		}
	}
}
