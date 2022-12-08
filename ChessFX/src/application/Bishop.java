package application;

public class Bishop extends Piece {

	public Bishop(Position pos, boolean isWhite, boolean isAlive) {
		super(pos, isWhite, isAlive);
	}

	public Bishop(boolean isWhite, boolean isAlive) {
		super(isWhite, isAlive);
	}
	
	
	
	
	
	
	

	@Override
	protected boolean checkMove(Move move, ChessBoard b) {

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

		if(Math.abs(newX - oldX) == Math.abs(newY - oldY) && (newX >= 0 && newX <= 7) && (newY >= 0 && newY <= 7)){ //case that it moved in the correct pattern
			
			if(newX - oldX > 0 && newY - oldY > 0){ //checks if moved to the right and down, iterates through board,
				for(int i= 1; i< newX-oldX; i++){   // finds if there are any pieces in the way
					if(b.hasPiece(new Position(oldX + i,oldY + i))){
						return false;
					}
				}
				return true;
			}
			if(newX - oldX < 0 && newY - oldY < 0){ //checks if it moved left and up
				for(int i = 1; i< oldX - newX; i++){
					if(b.hasPiece(new Position(newX + i, newY + i))){
						return false;
					}
				}
				return true;
			}
			if(((newX - oldX) > 0) && ((newY - oldY) < 0)){ //checked if it moved right and up
				for(int i = 1; i< newX - oldX; i++){
					if(b.hasPiece(new Position(oldX + i, oldY - i))){
						return false;
					}
				}
				System.out.println("Legal move: " + getType()  + " from: (" + oldX + "," + oldY + ") to (" + newX + "," + newY + ")");

				return true;
			}
			if(newX - oldX < 0 && newY - oldY > 0){ //checks if it moved left and down
				for(int i = 1; i< Math.abs(newX - oldX); i++){
					if(b.hasPiece(new Position(oldX -i, oldY + i))){
						return false;
					}
				}
				return true;
			}
			return false; //Cannot stay in your current position.
		}
		return false; //return false if it went in wrong pattern
	}

	@Override
	protected String getType() {
		return "Bishop";
	}

}
