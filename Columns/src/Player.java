
public class Player {
	Object playerName = null;
	Object playerSurname = null;
	Object playerScore = null;
	
	public Player(Object name,Object surname, Object score)
	{
	    playerName = name;
	    playerScore = score;
	    playerSurname = surname;
	}
	public Object getPlayerSurname() {
		return playerSurname;
	}
	public void setPlayerSurname(Object playerSurname) {
		this.playerSurname = playerSurname;
	}
	public Object getPlayerName() {
		return playerName;
	}
	public void setPlayerName(Object playerName) {
		this.playerName = playerName;
	}
	public Object getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(Object playerScore) {
		this.playerScore = playerScore;
	}
	 public String toString()
	    {
	        return playerName + " " + playerSurname+" "+playerScore;  
	    }
}
