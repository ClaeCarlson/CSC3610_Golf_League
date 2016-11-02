package golfLeague;

public class Player {
	/* A Player class containing first name, last name, handicap,
	 *  score for last game and rank on team. 
	 */
	
	public String fName;
	public String lName;
	public int handicap;
	public int score;
	public int rank;
	
	public Player () {
		this.fName = "";
		this.lName = "";
		this.handicap = 0;
		this.score = 0;
		this.rank = 0;
	}
	
	public Player (String f, String l, int handi, int score, int rank) {
		this.fName = f;
		this.lName = l;
		this.handicap = handi;
		this.score = score;
		this.rank = rank;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Player: " + fName + " " + lName + "\nHandicap:  "
				+ handicap + "/nLast Game's Score: " + score + "\nPlayer Ranking:";
	}
	

}