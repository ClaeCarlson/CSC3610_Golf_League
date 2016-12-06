package golfLeague;



import java.util.Arrays;



public class Golf_Team extends Person {



	public String teamName;

	

	Person[] teamMembers = new Person[5];

	

	String rank;

	//Constructor for assigning variable respectively

	public Golf_Team(String teamName, Person[] teamMembers, String rank) {

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



	public Person[] getTeamMembers() {

		return teamMembers;

	}



	public void setTeamMembers(Person[] teamMembers) {

		this.teamMembers = teamMembers;

	}



	public String getRank() {

		return rank.toString();

	}



	public void setRank(String rank) {

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