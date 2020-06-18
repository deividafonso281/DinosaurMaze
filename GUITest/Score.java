import java.io.Serializable;
import java.math.BigInteger;

public class Score implements Serializable, IScore{

	private BigInteger pontuation;
	private String username;
		
	public Score(int points, String username) {
		this.pontuation = BigInteger.valueOf(points);
		this.username = username;
	}
	
	public BigInteger getPontuation() {
		return pontuation;
	}
	
	public String getUsername() {
		return username;
	}

	public void increment() {
		this.pontuation = this.pontuation.add(BigInteger.valueOf(1));
	}
}
