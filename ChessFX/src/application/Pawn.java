package application;

public class Pawn extends Piece {
	public Pawn(Position pos, boolean isWhite, boolean isAlive){
		super(pos, isWhite, isAlive);
	}
	public Pawn( boolean isWhite, boolean isAlive){
		super(isWhite, isAlive);
	}

	@Override
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
		
		if(b.getPiece(move.getDest()).getIsWhite() == true){
			if(oldY == 6){
				if(Math.abs(newX - oldX) == 1 && newY == oldY - 1 && b.hasPiece(move.getDest())){
					return true;
				}
				else if(newX == oldX && newY == oldY - 1 && !b.hasPiece(move.getDest())){
					return true;
				}
				else if(newX == oldX && newY == oldY - 2 && !b.hasPiece(move.getDest()) && !b.hasPiece(new Position(newX, newY - 1))){
					return true;
				}
				return false;
			}
			else{
				if(Math.abs(newX - oldX) == 1 && newY == oldY - 1 && b.hasPiece(move.getDest())){ 
					return true;
				}
				else if(newX == oldX && newY == oldY - 1 && !b.hasPiece(move.getDest())){
					return true;
				}
				return false;
			}
		}
		else{
			if(oldY == 1){
				if(Math.abs(newX - oldX) == 1 && newY == oldY + 1 && b.hasPiece(move.getDest())){
					return true;
				}
				else if(newX == oldX && newY == oldY + 1 && !b.hasPiece(move.getDest())){
					return true;
				}
				else if(newX == oldX && newY == oldY + 2 && !b.hasPiece(move.getDest()) && !b.hasPiece(new Position(newX, newY + 1))){
					return true;
				}
				return false;
			}
			else{
				if(Math.abs(newX - oldX) == 1 && newY == oldY + 1 && b.hasPiece(move.getDest())){ 
					return true;
				}
				else if(newX == oldX && newY == oldY + 1 && !b.hasPiece(move.getDest())){
					return true;
				}
				return false;
			}
		}
	}
	
	
	public boolean isTransformPawn() {
		if (this.getIsWhite() && this.getPosition().getY() == 0) {
			return true;
		}
		if (!this.getIsWhite() && this.getPosition().getY() == 7) {
			return true;
		}
		return false;
	}
	
	
	public String getType(){
		return "Pawn";
	}
}