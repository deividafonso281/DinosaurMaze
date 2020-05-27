import java.io.Serializable;
import java.math.BigInteger;

public class Score implements Serializable{

	private BigInteger pontuation;
	private String username;
		
	public Score(BigInteger pontuation, String username) {
		this.pontuation = pontuation;
		this.username = username;
	}
	
	public BigInteger getPontuation() {
		return pontuation;
	}
	
	public String getUsername() {
		return username;
	}
}
