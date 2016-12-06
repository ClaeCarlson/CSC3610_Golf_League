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

	public String rank;

	public String type;

	public String team;

	

	public Person () {

		this.fName = "";

		this.lName = "";

		this.handicap = "0";

		this.score = "0";

		this.rank = "0";

	}

	

	public Person (String f, String l, String handi, String score, String rank, String team) {

		this.fName = f;

		this.lName = l;

		this.handicap = handi;

		this.score = score;

		rank = "0";

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

	

	@Override

	public String toString() {

		return "Player: " + fName + " " + lName + "\nHandicap:  "

				+ handicap + "/nLast Game's Score: " + score + "\nPlayer Ranking:";

	}



	public String getTeam() {

		// TODO Auto-generated method stub

		return team;

	}

	



}