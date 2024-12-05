package TicTacToeLLD.Model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
	Deque<Player> players;
	Board gameBoard;
	public TicTacToeGame() { //constructor calling method to start the game
		initializeGame();
	}
	public void initializeGame() {
		//creating 2 players
		players = new LinkedList<>();
		PlayingPieceX crossPiece = new PlayingPieceX();
		Player player1 = new Player("player1",crossPiece);
		
		PlayingPieceO noughtsPiece = new PlayingPieceO();
		Player player2 = new Player("player2",noughtsPiece);
		
		players.add(player1);
		players.add(player2);
		
		//initialize Board
		gameBoard = new Board(3);
		
		
	}
	
	public String startGame() {
		boolean noWinner = true;
		while(noWinner) {
			//take out the player whose turn is and also put the player in the list back
			Player playerTurn = players.removeFirst();
			
			//get free sapce from board
			gameBoard.printBoard();
			List<Pair<Integer,Integer>> freeSpaces = gameBoard.getFreeCells();
			if(freeSpaces.isEmpty()) {
				noWinner=false;
				continue;
				
			}
			
			//read user input
			System.out.println("Player: "+playerTurn.name+" Enter row,column: ");
			Scanner inputScanner = new Scanner(System.in);
			String s = inputScanner.nextLine();
			String[] values = s.split(",");
			int inputRow = Integer.valueOf(values[0]);
			int inputColumn = Integer.valueOf(values[1]);
			
			//place the piece
			boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
			if(!pieceAddedSuccessfully) {
				//player cannot insert the piece into this cell, player has to choose another cell
				System.out.println("Incorrect position choosen , try again");
				players.addFirst(playerTurn); //so that same player try again
				continue;
			}
			players.addLast(playerTurn); //the player turn utilised,new player has to put his turn
			boolean winner = isThereWinner(inputRow,inputColumn,playerTurn.playingPiece.pieceType);
			if(winner) {
				return playerTurn.name;
			}
		}
		return "tie";
	}
	private boolean isThereWinner(int row, int column, PieceType pieceType) {
		boolean rowMatch =true;
		boolean columnMatch = true;
		boolean diagonalMatch = true;
		boolean antiDiagonalMatch = true;
		//checking in row
		for(int i=0;i<gameBoard.size;i++) {
			if(gameBoard.board[row][i]==null || gameBoard.board[row][i].pieceType!=pieceType) {
				rowMatch=false;
			}
		}
		
		//checking in column
		for(int i=0;i<gameBoard.size;i++) {
			if(gameBoard.board[row][i]==null || gameBoard.board[row][i].pieceType!=pieceType) {
						columnMatch=false;
			}
		}
		
		//checking diagonals
		for(int i=0,j=0;i<gameBoard.size;i++,j++) {
			if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType) {
				diagonalMatch=false;
			}
		}
		
		//checking anti-diagonals
		for(int i=0,j=gameBoard.size-1;i<gameBoard.size;i++,j--) {
			if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType) {
				antiDiagonalMatch=false;
			}
		}
		return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
	}
	
	
}
