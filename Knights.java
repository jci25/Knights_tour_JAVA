import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
   * read 3 arguments: rows, columns, attempts . The first 2 arguments 
	 * are the size of the board, rows x columns. The last argument is the
	 * number of 
	  * attempts to make.
	   *
		 * @author Joe Ippolite
		  */

public class Knights{
	public static List<int[][]> myArr = new ArrayList<int[][]>();
	public static Random randomGenerator;
	public static boolean full = false;
	public static int board[][];
	public static int x,y,moves,attempt,argx,argy,argAtt;
	public static void main(String[] args){
		if( args.length == 3 ){
			/**
			   * convert arguments to integer then point to variable
				 * first input is number of rows
				 */
			argx = Integer.parseInt(args[0]);
			/**
			   * convert arguments to integer then point to variable
				 * second input is number of columns
				 */
			argy = Integer.parseInt(args[1]);
			/**
			   * convert arguments to integer then point to variable
				 * last input is number of attempts
				  */
			argAtt = Integer.parseInt(args[2]);

			startTour();

		}else{
			System.out.println("Need 3 arguments. Exiting");
			System.exit(0);
		}
	}
	/**
	   *Checks to see if the board is full.
		 * if not full starts a new board and sets the
		  * initial position to 1.
		   * then runs checkMoves to see valid moves and picks one
			 */
	public static void startTour(){
		//System.out.println("Start Tour");
		while(full == false){
			moves = 1;
			board = new int[argx][argy];
			for(int x1 = 0; x1 < argx; x1++){
				for(int y1 = 0; y1 < argy; y1++){
					board[x1][y1] = 0;
				}}
			x = 0;
			y = 0;
			board[x][y] = moves;
			full = checkMoves();
		}
	}
	/**
	   * takes a list of possible moves
		 * chooses one at random
		  * checks moves again(recursive)
		   * if board is full exit
			 */
	public static void makeMove(List<int[][]> movess){
		int size = movess.size();
		//System.out.println("Size = " + size);
		/*Iterator<int[][]> iterator = movess.iterator();
		  while (iterator.hasNext()) {
		  int it[][] = iterator.next();
		  //System.out.println(it[0][0] + " " + it[0][1]);
		  }*/
		randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(size);
		int moved[][] = movess.get(randomInt);
		//System.out.println("Random = " + randomInt);
		//System.out.println(moved[0][0] + " " + moved[0][1]);
		board[moved[0][0]][moved[0][1]] = moves+1;
		x = moved[0][0];
		y = moved[0][1];
		moves++;
		/*for(int x1 = 0; x1 < argx; x1++){
		  for(int y1 = 0; y1 < argy; y1++){
		  System.out.print(board[x1][y1]);
		  }System.out.println();}*/
		full = checkMoves();
		if(full == true){
			System.exit(0);
		}
	}
	/**
	   * checks all 8 possible moves
		 * if move is within board then add to list
		  * send list to makeMove to make a move
		   * if no possible moves left check to see if full board and print
			 * check to see if attempts are left if no print board
			  * @return returns whether or not the board is full
			   */
	public static boolean checkMoves(){
		int yy = 0;
		myArr.clear();
		//check left up
		if((x - 2 >= 0) && (y - 1 >= 0) && (x - 2 < argx) && (y - 1 < argy)){
			if(board[x-2][y-1] == 0){
				int move[][] = new int[1][2];
				move[0][0]= x - 2;
				move[0][1] = y - 1;
				myArr.add(move);
			}
		}
		//check left down
		if((x - 2 >= 0) && (y + 1 >= 0) && (x - 2 < argx) && (y + 1 < argy)){
			if(board[x-2][y+1] == 0){
				int move[][] = new int[1][2];
				move[0][0]= x - 2;
				move[0][1] = y + 1;
				myArr.add(move);
			}
		}
		//check right up
		if((x + 2 >= 0) && (y - 1 >= 0) && (x + 2 < argx) && (y - 1 < argy)){
			if(board[x+2][y-1] == 0){
				int move[][] = new int[1][2];
				move[0][0]= x + 2;
				move[0][1] = y - 1;
				myArr.add(move);
			}
		}
		//check right down
		if((x + 2 >= 0) && (y + 1 >= 0) && (x + 2 < argx) && (y + 1 < argy)){
			if(board[x+2][y+1] == 0){
				int move[][] = new int[1][2];
				move[0][0]= x + 2;
				move[0][1] = y + 1;
				myArr.add(move);
			}
		}
		//check down right
		if((x + 1 >= 0) && (y + 2 >= 0) && (x + 1 < argx) && (y + 2 < argy)){
			if(board[x+1][y+2] == 0){
				int move[][] = new int[1][2];
				move[0][0]= x + 1;
				move[0][1] = y + 2;
				myArr.add(move);
			}
		}
		//check down left
		if((x - 1 >= 0) && (y + 2 >= 0) && (x - 1 < argx) && (y + 2 < argy)){
			if(board[x-1][y+2] == 0){
				int move[][] = new int[1][2];
				move[0][0]= x - 1;
				move[0][1] = y + 2;
				myArr.add(move);
			}
		}
		//check up right
		if((x + 1 >= 0) && (y - 2 >= 0) && (x + 1 < argx) && (y - 2 < argy)){
			if(board[x+1][y-2] == 0){
				int move[][] = new int[1][2];
				move[0][0]= x + 1;
				move[0][1] = y - 2;
				myArr.add(move);
			}
		}
		//check up left
		if((x - 1 >= 0) && (y - 2 >= 0) && (x - 1 < argx) && (y - 2 < argy)){
			if(board[x-1][y-2] == 0){
				int move[][] = new int[1][2];
				move[0][0]= x - 1;
				move[0][1] = y - 2;
				myArr.add(move);
			}
		}
		//System.out.println("test");
		if(myArr.isEmpty()){
			boolean boardFull = false;
			//empty array = no more moves
			//check if all moves are used
			//System.out.println("empty array");
			for(int x1 = 0; x1 < argx; x1++){
				for(int y1 = 0; y1 < argy; y1++){
					if(board[x1][y1] == 0){
						yy = y1;
						//System.out.println("not filled empty1");
						boardFull = false;
						//not filled
						break;
					}else{
						//System.out.println("full true");
						boardFull = true;
					}
				}if(board[x1][yy] == 0){
					//System.out.println("not filled empty2");
					boardFull = false;
					//not filled
					break;
				}else{
					//System.out.println("full true1");
					boardFull = true;
				}}
			if(boardFull == true){
				//System.out.println("full");
				//print board dont do anymore
				System.out.println("Final Correct Answer.");
				full =true;
				for(int x1 = 0; x1 < argx; x1++){
					for(int y1 = 0; y1 < argy; y1++){
						System.out.print(board[x1][y1] + " ");
					}System.out.println();}
				return true;
			}//check if attempts are done
			else if(attempt == argAtt){
				System.out.println("last attempt print");
				//print board
				full =true;
				for(int x1 = 0; x1 < argx; x1++){
					for(int y1 = 0; y1 < argy; y1++){
						System.out.print(board[x1][y1] + " ");
					}System.out.println();}
				return true;
			}else{
				/*System.out.println("attempt: " + attempt);
				  //print board
				  for(int x1 = 0; x1 < argx; x1++){
				  for(int y1 = 0; y1 < argy; y1++){
				  System.out.print(board[x1][y1] + " ");
				  }System.out.println();}*/
				attempt++;
				//return to start:::::
				//startTour();
				return false;
			}
		}else{
			makeMove(myArr);
		}
		if(full == true){
			System.exit(0);
		}
		return false;
	}
}
