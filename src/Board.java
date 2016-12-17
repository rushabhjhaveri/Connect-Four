public class Board{
	private char[][]grid;
	private int p1 = 1;
	private int p2 = 2;
	private char pl1 = '1';
	private char pl2 = '2';
	private int rows;
	private int cols;
	
	Board(){
				
		this.rows = 6;
		this.cols = 7;
		grid = new char [this.rows][this.cols];
		for(int i = 0; i < this.rows; i++){
			for(int j = 0; j < this.cols; j++){
				grid[i][j] = ' ';
			}
		}
		//creates a default board of size 7 columns x 6 rows 
	}
	 
	public Board(int row, int col){
		
		this.rows = row;
		this.cols = col;
		grid = new char[row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				grid[i][j] = ' ';
			}
		}
		//creates a board of size row x col
	}

	//Both constructors above should initialize all positions to ' '
	public int getNumRows(){
		return this.rows;
		//returns the number of rows in board 
	}
	
	public int getNumCols(){
		return this.cols;
		//returns the number of cols in board 
	}

	public char getPlayerOne(){
		return pl1;
		//returns char representing player 1 
	}
	
	public char getPlayerTwo(){
		return pl2;
		//returns char representing player 2 
	}

	public void setPlayerOne(char o){
		pl1 = o;
		//sets char representing player 1 
	}
	
	public void setPlayerTwo(char t){
		pl2 = t;
		//sets char representing player 2 
	}

	public char getToken(int row, int col){
		if (row < 0 || col < 0) return '\0';
		
		if(row <= (this.rows -1)  && col <= (this.cols -1) ){
			return grid[row][col];
		}
		return '\0';
		//returns the char representing token at location row,col returns '\0' if indices are invalid 
	}

	public boolean canPlay(){
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				if(grid[i][j] == ' '){
					return true;
				}
			}	
		}
		return false;
		//returns true if a token is still able to placed onto the board, false otherwise 
	}

	
	public boolean play(int p, int c){
		if ( c < 0 ||  (c > (this.cols -1)) ) return false;
		if (p != p1 &&   p != p2) return false;
		
		for(int i = (this.rows -1); i >= 0; i--){
			if(grid[i][c] == ' '){
				if(p == p1){
					grid[i][c] = pl1;
					return true;
				}
				else if(p == p2){
					grid[i][c] = pl2;
					return true;
				}
			}
		}   // end for
		return false;
		//places the appropriate token for player p in column c. returns true if successful, false otherwise. 
	}
	
	public int returnRow(int row){
		return row;
	}

	public int isFinished(){
		if(checkHorizontal(pl1) || checkVertical(pl1) || checkForwardDiagonal(pl1) || checkBackwardDiagonal(pl1)){
			return p1;
		}
		else if(checkHorizontal(pl2) || checkVertical(pl2) || checkForwardDiagonal(pl2) || checkBackwardDiagonal(pl2)){
			return p2;
		}
		else if(checkDraw()){
			return 0;
		}
		return -1;
		//returns either the ID of the player who has won (1 or 2) OR 0 if the game has ended in a tie OR -1 if nobody has won yet
	}
	public boolean checkHorizontal(char c){
		int count = 0;
		for(int i = 0; i < this.rows; i++){
			count = 0;
			for(int j = 0; j < this.cols; j++){
				if(grid[i][j] == c){
					count++;
					if(count == 4){
						return true;
					}
				}
				else{
					count = 0;
				}
			}
		}
		return false;
	}
	public boolean checkVertical(char c){
		int count = 0;
		for(int i = 0; i < this.cols; i++){
			count = 0;
			for(int j = 0; j < this.rows; j++){
				if(grid[j][i] == c){
					count++;
					if(count == 4){
						return true;
					}
				}
				else{
					count = 0;
				}
			}
		}
		return false;
	}
	public boolean checkForwardDiagonal(char ch){
		int r,c,count,rowcnt,colcnt;
		for(r = 0; r < this.rows; r++){
			for(c = 0; c < this.cols; c++){
				count = 0; rowcnt = 0; colcnt = 0;
				while((r + rowcnt) <= (this.rows-1) && (c + colcnt)<= (this.cols-1)){
					if(grid[(r + rowcnt)][(c + colcnt)] == ch){
						count++;
						// debug stmt to understand the values in the array
						//System.out.println("[" + (r + rowcnt) + "][" + (c + colcnt) + "]"  + "=" + grid[(r + rowcnt)][c + colcnt] + "  count=" + count);
						if (count >=4) {
							   return true;
						} 
					} else {
						count = 0;
					}  // end if
					rowcnt++;
					colcnt++;
				}  // end while
			} // end for c
		} // end for r
		return false;
	}
	public boolean checkBackwardDiagonal(char ch){
		int r,c,count,rowcnt,colcnt;
		for(r = (this.rows -1); r >= 1; r--){
			for(c = 0; c < this.cols ; c++){
				count = 0; rowcnt = 0; colcnt = 0;
				while((r - rowcnt) >=0  && (c + colcnt) <= (this.cols -1)){
					if(grid[(r - rowcnt)][c + colcnt] == ch){
						count++;
						// debug stmt to understand the values in the array
						// System.out.println("[" + (r - rowcnt) + "][" + (c + colcnt) + "]"  + "=" + grid[(r - rowcnt)][c + colcnt] + "  count=" + count);
						if (count >=4) {
							   return true;
						} 
					} 
				    else {
					   count = 0;
				    }
					rowcnt++;
					 colcnt++;
				}  // end while
			} // end for c
		} // end for r 

		return false;
	}
	 
	public boolean checkDraw(){
		
		for(int i = 0; i < this.rows; i++){
			for(int j = 0; j < this.cols; j++){
				
				if(grid[i][j] == ' '){
					return false;
				}
			}
		}
		return true;
	}
}