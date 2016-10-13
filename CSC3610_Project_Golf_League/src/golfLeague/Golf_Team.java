package golfLeague;

import java.util.Arrays;

public class Golf_Team extends Player {

	public String teamName;
	
	Player[] teamMembers = new Player[4];
	
	int rank;
	//Constructor for assigning variable respectively
	public Golf_Team(String teamName, Player[] teamMembers, int rank) {
		super();
		this.teamName = teamName;
		this.teamMembers = teamMembers;
		this.rank = rank;
	}

	/**
	 *Getter and Setters 
	 **/
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Player[] getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(Player[] teamMembers) {
		this.teamMembers = teamMembers;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	/**
	 * Override object
	 */
	@Override
	public String toString(){
		return "Team Name: " + teamName + "\nPlayer: " + teamMembers[0] + ", "
				+ teamMembers[1] + ", " + teamMembers[2] + ", " + teamMembers[1];
	}
	
	
}