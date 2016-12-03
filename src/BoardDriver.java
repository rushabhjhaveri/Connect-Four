import java.util.*;
public class BoardDriver{
	public static void main(String[] args){
		Board board = new Board();
		Scanner sc = new Scanner(System.in);
		int rows = 0, cols = 0, choice;
		System.out.println("1. Default board.");
		System.out.println("2. Custom board.");
		System.out.print("Enter choice: ");
		choice = sc.nextInt();
		if(choice == 1){
			createDefaultBoard(board);
		}
		else if(choice == 2){
			System.out.print("Enter number of rows: ");
			rows = sc.nextInt();
			System.out.print("Enter number of columns: ");
			cols = sc.nextInt();
			if(rows < 6 || cols < 7){
				createDefaultBoard(board);
			}
			else{
				createCustomBoard(board, rows, cols);
			}
		}
		else{
			while(choice != 1 || choice != 2){
				System.out.println("1. Default board.");
				System.out.println("2. Custom board.");
				System.out.print("Enter choice: ");
				choice = sc.nextInt();
				if(choice == 1){
					createDefaultBoard(board);
					break;
				}
				else if(choice == 2){
					System.out.print("Enter number of rows: ");
					rows = sc.nextInt();
					System.out.print("Enter number of columns: ");
					cols = sc.nextInt();
					if(rows < 6 || cols < 7){
						createDefaultBoard(board);
					}
					else{
						createCustomBoard(board, rows, cols);
					}
					break;
				}
			}
		}
		
	}
	public static void createDefaultBoard(Board board){
		board = new Board();
		System.out.println("Created board with " + board.getNumRows() + " rows and " + board.getNumCols() +" columns.");
	}
	public static void createCustomBoard(Board board, int rows, int cols){
		board = new Board(rows, cols);
		System.out.println("Created board with " + board.getNumRows() + " rows and " + board.getNumCols() +" columns.");
	}
}