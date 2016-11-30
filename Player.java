package golfLeague;

public class Player {
	/* A Player class containing first name, last name, handicap,
	 *  score for last game and rank on team. 
	 */
	
	public String fName;
	public String lName;
	public String handicap;
	public String score;
	public String rank;
	public String team;
	public Player () {
		this.fName = " ";
		this.lName = " ";
		this.handicap = " ";
		this.score = "  ";
		this.rank = " ";
	}
	
	public Player (String f, String l, String handi, String score, String rank, String team) {
		this.fName = f;
		this.lName = l;
		this.handicap = handi;
		this.score = score;
		this.rank = rank;
		this.team = team;
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

	public String getHandicap() {
		return handicap;
	}

	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player: " + fName + " " + lName + "\nHandicap:  "
				+ handicap + "/nLast Game's Score: " + score + "\nPlayer Ranking:";
	}
	

}