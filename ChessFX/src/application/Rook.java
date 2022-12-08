package application;

public class Rook extends Piece{
	
	
	public Rook(Position pos, boolean isWhite, boolean isAlive){
		super(pos, isWhite, isAlive);
	}
	public Rook(boolean isWhite, boolean isAlive){
		super(isWhite, isAlive);
	}
	
	public boolean checkMove(Move move, ChessBoard b) {
		int oldX = move.getSrc().getX();
		int oldY = move.getSrc().getY();
		int newX = move.getDest().getX();
		int newY = move.getDest().getY();
		
		// Check if the destination has a piece of the same color
		if(b.hasPiece(move.getDest())){
			if(b.getPiece(move.getDest()).getIsWhite() == b.getPiece(move.getSrc()).getIsWhite()){
				return false;
			}
		}
		
		
		if((oldX == newX) && (newX >= 0 && newX <= 7) && (newY >= 0 && newY <= 7)){
			if(newY > oldY){ //checks if there are any pieces in the way if the rook is moving down
				for(int i = 1; i< newY-oldY; i++){ //iterates through board to check for pieces
					if(b.hasPiece(new Position(oldX, oldY + i))){
						return false;
					}
				}
				return true;
			}
			if(newY < oldY){ //checks if there are pieces in the way if the rook moves up
				for(int i= 1; i<oldY - newY; i++){ //iterates through board, checks for pieces
					if(b.hasPiece(new Position(oldX, newY + i))){
						return false;
					}
				}
				return true;
			}
			return false;
		}
		if((oldY == newY) && (newX >= 0 && newX <= 7) && (newY >= 0 && newY <= 7)){
			if(newX > oldX){ //checks if there are pieces in the way if rook moves right
				for(int i = 1; i<newX-oldX; i++){ //iterates through board checking for pieces
					if(b.hasPiece(new Position(oldX + i, oldY))){
						return false;
					}
				}
				return true;
			}
			
			if(newX < oldX){ //checks if there are pieces in teh way if the rook moves left
				for(int i = 1; i<oldX-newX; i++){ //iterates through board
					if(b.hasPiece(new Position(newX + i, oldY))){
						return false;
					}
				}
				return true;
			}
			return false;

		}
		return false;
	}

	
	
	public String getType(){
		return "Rook";
	}
	
}