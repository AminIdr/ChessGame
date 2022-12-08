package application;

public class King extends Piece{
	
	private boolean hasMoved = false;
	
	public King(Position pos, boolean isWhite, boolean isAlive){
		super(pos, isWhite, isAlive);
	}
	public King(boolean isWhite, boolean isAlive){
		super(isWhite, isAlive);
	}
	@Override
	
	
	
	public boolean checkMove(Move move, ChessBoard b){
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

		/*
		 * Checks if the difference between the new x and old x and new y and old y is less then 1 (it only moved one square
		 * and that the piece is still on the board
		 */
		if(Math.abs(newX - oldX) <= 1 && Math.abs(newY - oldY) <=1 && (newX >= 0 && newX <= 7) && (newY >= 0 && newY <= 7)){
			return true;
		}
		/*
		 * Allow for castling
		 */							
		if(this.isWhite == true){ //case that piece is white
			if(b.hasPiece(new Position(7, 7))){
				if(b.getPiece(new Position(7, 7)).getType().equals("Rook") && !b.getPiece(new Position(7, 7)).getHasMoved()){ //checks if there is rook in correct position
					if(oldX == 4 && oldY == 7 && newX == 6 && newY ==7){
						if(!b.hasPiece(new Position(5, 7)) && !b.hasPiece(new Position(6,7))){ //checks if proper castling rules followed
							return true;
						}
					}
				}
			}
			
			if(b.hasPiece(new Position(0, 7))){
				if(b.getPiece(new Position(0, 7)).getType().equals("Rook") && !b.getPiece(new Position(0, 7)).getHasMoved()){ //checks if there is rook in correct position
					if(!this.hasMoved && newX == 2 && newY ==7){
						if(!b.hasPiece(new Position(1, 7)) && !b.hasPiece(new Position(2,7)) && !b.hasPiece(new Position(3, 7))){ //checks if proper castling rules followed
							return true;
						}
					}
				}
			}
			
			
			//applies same reasoning to a black king, hardcoded positions for rook and king used
		}else if(this.isWhite == false){ //case that piece is black
			if(b.hasPiece(new Position(7, 0))){
				if(b.getPiece(new Position(7, 0)).getType().equals("Rook") && !b.getPiece(new Position(7, 0)).getHasMoved()){
					if(oldX == 4 && oldY == 0 && newX == 6 && newY ==0){
						if(!b.hasPiece(new Position(5, 0)) && !b.hasPiece(new Position(6,0))){
							return true;
						}
					}
				}
			}
			
			if(b.hasPiece(new Position(0, 0))){
				if(b.getPiece(new Position(0, 0)).getType().equals("Rook") && !b.getPiece(new Position(0, 0)).getHasMoved()){ //checks if there is rook in correct position
					if(!this.hasMoved && newX == 2 && newY ==0){
						if(!b.hasPiece(new Position(1, 0)) && !b.hasPiece(new Position(2,0)) && !b.hasPiece(new Position(3, 0))){ //checks if proper castling rules followed
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	
	public String getType(){
		return "King";
	}
}
