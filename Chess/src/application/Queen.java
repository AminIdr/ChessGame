package application;

public class Queen extends Piece{
	public Queen(Position pos, boolean isWhite, boolean isAlive){
		super(pos, isWhite, isAlive);
	}
	public Queen(boolean isWhite, boolean isAlive){
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
		 * combines rules for rook and bishop, allows for either scenario to occur (move in change in x/change in y = 1 pattern)
		 * or horizontal/vertical pattern.
		 * 
		 * 
		 * also checks if piece is still on the board, and makes checks to see if there are any other pieces in the way 
		 */
		if((oldX == newX) && (newX >= 0 && newX <= 7) && (newY >= 0 && newY <= 7)){
			/*
			 * For all possible patterns of movement, the Queen iterates through the board to check
			 * if there are any pieces in the way in that direction
			 */
			if(newY > oldY){
				for(int i = 1; i< newY-oldY; i++){ 
					if(b.hasPiece(new Position(oldX, oldY + i))){ 
						return false;
					}
				}
				return true;
			}
			if(newY < oldY){
				for(int i= 1; i<oldY - newY; i++){
					if(b.hasPiece(new Position(oldX, newY + i))){
						return false;
					}
				}
				return true;
			}
		}
		if((oldY == newY) && (newX >= 0 && newX <= 7) && (newY >= 0 && newY <= 7)){
			if(newX > oldX){
				for(int i = 1; i<newX-oldX; i++){
					if(b.hasPiece(new Position(oldX + i, oldY))){
						return false;
					}
				}
				return true;
			}
			
			if(newX < oldX){
				for(int i = 1; i<oldX-newX; i++){
					if(b.hasPiece(new Position(newX + i, oldY))){
						return false;
					}
				}
				return true;
			}
		}
		
		if(Math.abs(newX - oldX) == Math.abs(newY - oldY) && (newX >= 0 && newX <= 7) && (newY >= 0 && newY <= 7)){
			if(newX - oldX > 0 && newY - oldY > 0){
				for(int i= 1; i< newX-oldX; i++){
					if(b.hasPiece(new Position(oldX + i,oldY + i))){
						return false;
					}
				}
				return true;
			}
			if(newX - oldX < 0 && newY - oldY < 0){
				for(int i = 1; i< oldX - newX; i++){
					if(b.hasPiece(new Position(newX + i, newY + i))){
						return false;
					}
				}
				return true;
			}
			if(((newX - oldX) > 0) && ((newY - oldY) < 0)){
				for(int i = 1; i< newX - oldX; i++){
					if(b.hasPiece(new Position(oldX + i, oldY - i))){
						return false;
					}
				}
				return true;
			}
			if(newX - oldX < 0 && newY - oldY > 0){
				for(int i = 1; i< Math.abs(newX - oldX); i++){
					if(b.hasPiece(new Position(oldX -i, oldY + i))){
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	
	public String getType() {
		return "Queen";
	}
}
