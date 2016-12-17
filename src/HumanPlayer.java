public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	int playerID;
	int rows;
	int cols;
	int lastMoveVal;
	
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.rows = row;
		this.cols = col;
		this.lastMoveVal = -1;
	
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
	    this.lastMoveVal = c;	
	}
	
	//returns column of where to play a token
	public int playToken(){
		int c;
		System.out.print("Enter column where token is to be played: ");
		c = IO.readInt();
		while(c < 0 || c > (this.cols-1)){
			System.out.print("Enter column where token is to be played: ");
			c = IO.readInt();
		}
		return c;
	}
	
	//get this player's id
	public int getPlayerID(){
		return this.playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		this.playerID = 0;
		this.rows = 0;
		this.cols = 0;
		this.lastMoveVal = -1;
	}

	
}