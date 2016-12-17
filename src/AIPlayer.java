
public class AIPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	int playerID;
	int rows;
	int cols;
	Board board;
	int lastMoveVal;
	int myLastCol;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.rows = row;
		this.cols = col;
		board = new Board(this.rows, this.cols);
		this.lastMoveVal = -1;
		this.myLastCol = 0;
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		if(this.playerID == 1){
			board.play(2, c);
		}
		if(this.playerID == 2){
			board.play(1, c);
		}
		this.lastMoveVal = c;
	}
	
	//returns column of where to play a token
	public int playToken(){
		 
		if(this.lastMoveVal == -1){
			this.myLastCol = 0;
			board.play(this.playerID, this.myLastCol);
			return this.myLastCol;
		}
		else if(this.lastMoveVal == this.myLastCol){
			this.myLastCol = this.lastMoveVal + 1;
			if(this.myLastCol < this.cols){
				if(board.play(this.playerID, this.myLastCol)){
					return this.myLastCol;
				}
				else{
					this.myLastCol = 0;
					boolean b = false;
					while(b){
						b = board.play(this.playerID, this.myLastCol);		
						this.myLastCol++;
					}   // end while
					return this.myLastCol;
				}  // else of board.play
			} // end if myLastCol < this.col
		} // end of  of lastMoveVal == myLastCol
		
		if(board.play(this.playerID, this.myLastCol)){
			return this.myLastCol;
		}
		else{
			this.myLastCol = 0;
			boolean b = false;
			while(b){
				b = board.play(this.playerID, this.myLastCol);		
				this.myLastCol++;
			}
		}
		return this.myLastCol;
		
		//c = min + (int)(Math.random()*((max-min)+1));
		//c = (int)(Math.random()*(max/2));
	}
	
	//get this player's id
	public int getPlayerID(){
		return this.playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		//this.playerID = 0;
		//this.rows = 0;
		//this.cols = 0;
		//this.lastMoveVal = -1;
		board = new Board(this.rows, this.cols);
	}
	
	
}