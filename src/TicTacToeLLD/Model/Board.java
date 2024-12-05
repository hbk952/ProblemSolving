package TicTacToeLLD.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	public int size;
	public PlayingPiece[][]board;
	public Board(int size) {
		this.size = size;
		board = new PlayingPiece[size][size];
	}
	
	public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
		if(board[row][column] != null) {
			return false;
		}
		board[row][column] = playingPiece;
		return true;
	}
	
	public List<Pair<Integer,Integer>> getFreeCells(){
		List<Pair<Integer,Integer>> freecells = new ArrayList();
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==null) {
					Pair<Integer,Integer> rowColumn = new Pair<>(i,j);
					freeCells.add(rowColumn);
				}
			}
		}
		return freeCells;
		
	}

}
