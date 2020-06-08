import java.io.Serializable;

public class ScoreList implements Serializable {

	public Score[] positions = new Score[15];
	public Score aux;
	public int capacity = 15;
	public int length = 0;

	public void addScore(Score score_new) {
		int pos = findPos(score_new);
		if (length==15){
			if (pos!=-1) {
				for (int i=pos;i<length;i++) {
					aux = positions[i];
					positions[i] = score_new;
					score_new = aux;
				}
			}
		}
		else {
			if (pos==-1) {
				positions[length] = score_new;
				length++;
			}
			else {
				length++;
				for (int i=pos;i<length;i++) {
                                	aux = positions[i];
                                	positions[i] = score_new;
                                	score_new = aux;
                        	}
			}
		}
	}
	
	public int findPos(Score score_new) {
		for (int i=0;i<length;i++) {
                                if (score_new.getPontuation().compareTo(positions[i].getPontuation())==1) {
					return i;
				}
		}
		return -1;
	}
}
