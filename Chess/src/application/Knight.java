package application;

public class Knight extends Piece {
	
	public boolean checkMove(Move move) {
		if(move.getDest().getX()<0 || move.getDest().getX()>7 || move.getDest().getY()<0 || move.getDest().getY()>7) {
			// Here, we check if the position is inside the board
			return false;
		}


		int[] tx = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
		int[] ty = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
		boolean result = false;
		
		for(int i=0; i<8; i++) {
			int x = move.getSrc().getX();
			int y = move.getSrc().getY();
			if(x+tx[i]>=0 && x+tx[i]<8 && y+ty[i]>=0 && y+ty[i]<8 && x+tx[i]==move.getDest().getX() && y+ty[i]==move.getDest().getY()) {
				// Here, we check if the move is possible (inside the board)
				result = true;
			}
		}
		
		return result;
	}
}