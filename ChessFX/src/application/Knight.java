package application;

public class Knight extends Piece {
	public Knight(Position pos, boolean isWhite, boolean isAlive){
		super(pos, isWhite, isAlive);
	}
	public Knight(boolean isWhite, boolean isAlive){
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
		
		if(Math.abs(newX - oldX) == 2 && Math.abs(newY - oldY) == 1 && (newX >= 0 && newX <= 7) && (newY >= 0 && newY <= 7)){
			return true;
		}
		else if(Math.abs(newX - oldX) == 1 && Math.abs(newY - oldY) == 2 && (newX >= 0 && newX <= 7) && (newY >= 0 && newY <= 7)){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	protected String getType() {
		return "Knight";
	}
}