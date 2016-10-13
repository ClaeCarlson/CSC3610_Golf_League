package golfLeague;

public class Person {
	/* A Player class containing first name, last name, handicap,
	 *  score for last game and rank on team. 
	 */
	
	public String userName;
	public String password;
	public String fName;
	public String lName;
	public String handicap;
	public String score;
	public int rank;
	public String type;
	
	
	public Person () {
		this.fName = "";
		this.lName = "";
		this.handicap = "0";
		this.score = "0";
		this.rank = 0;
	}
	
	public Person (String user, String pass, String f, String l, String type, String handi, String score) {
		this.userName = user;
		this.password = pass;
		this.fName = f;
		this.lName = l;
		this.type = type;
		this.handicap = handi;
		this.score = score;
		rank = 0;
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
