public class ConnectFour{


	public static void main(String[] args){

		//Create new board object
		Board board = new Board();
		CFGUI gui;
		int rows;
		int cols;
		char o;
		char t;
		int c;
		//Set player tokens for player 1 and player 2
		System.out.print("Enter token for player one: ");
		o = IO.readChar();
		ChipColor c1 = ChipColor.BLACK;
		board.setPlayerOne(o);
		
		System.out.print("Enter token for player two: ");
		ChipColor c2 = ChipColor.RED;
		t = IO.readChar();
		board.setPlayerTwo(t);
		//Create Player objects
		Player P1;
		Player P2;
		
		gui = new CFGUI(board, c1, c2);
		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against

		Player p1 = new HumanPlayer(1,6,7);
		//Player p2 = new HumanPlayer(2,6,7); //comment this line when testing AIPlayer

		Player p2 = new AIPlayer(2,6,7); //uncomment this line when testing AIPlayer


		//Print your empty board
		printEmptyBoard(board);

		//WHILE the board is still playable
		//get a column to play from player 1
		//play that token on the board
		// print the board
		//has anyone won yet?
		// do the above for player 2
		// Get the status code from the board (isFinished())
		// Print out the results of the game
		while(board.canPlay()){
			c = p1.playToken();
			board.play(p1.getPlayerID(), c);
			p2.lastMove(c);
			gui.redraw();
			printBoard(board);
			if(board.isFinished() == 0 || board.isFinished() == 1 || board.isFinished() == 2){
				if(board.isFinished() == 0){
					gui.gameOver(0);
					IO.outputStringAnswer("Draw.");
					System.exit(0);
				}
				else if(board.isFinished() == 1){
					gui.gameOver(1);
					IO.outputIntAnswer(p1.getPlayerID());
					System.exit(0);
				}
				else if( board.isFinished() == 2){
					gui.gameOver(2);
					IO.outputIntAnswer(p2.getPlayerID());
					System.exit(0);
				}
			}
			/* MY COMMENT = NEED TO CHECK HERE IF ANYONE HASS WON YET */
			c = p2.playToken();
			board.play(p2.getPlayerID(), c);
			p1.lastMove(c);
			gui.redraw();
			printBoard(board);
			if(board.isFinished() == 0 || board.isFinished() == 1 || board.isFinished() == 2){
				if(board.isFinished() == 0){
					gui.gameOver(0);
					IO.outputStringAnswer("Draw.");
					System.exit(0);
				}
				else if(board.isFinished() == 1){
					gui.gameOver(1);
					IO.outputIntAnswer(p1.getPlayerID());
					System.exit(0);
				}
				else if( board.isFinished() == 2){
					gui.gameOver(2);
					IO.outputIntAnswer(p2.getPlayerID());
					System.exit(0);
				}
			}
		}
	}
	public static void printEmptyBoard(Board board){
		for(int i = 0; i < board.getNumRows(); i++){
			for(int j = 0; j < board.getNumCols(); j++){
				System.out.print(board.getToken(i, j) + "\t");
			}
			System.out.println();
		}
	}
	
	public static void printBoard(Board board){
		for(int i = 0; i < board.getNumRows(); i++){
			for(int j = 0; j < board.getNumCols(); j++){
				System.out.print(board.getToken(i, j) + "\t");
			}
			System.out.println();
		}
	}
}