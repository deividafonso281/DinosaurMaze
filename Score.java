import java.io.Serializable;

public class Score implements Serializable {

	private int points;
	private String name;
	
	public Score (int points, String name) {
		setPoints(points);
		setName(name);
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getName () {
		return this.name;
	}

	public int getPoints () {
		return this.points;
	}
}
