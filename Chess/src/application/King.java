package application;

public class King extends Piece{
	public King(Position pos, boolean isWhite, boolean isAlive){
		super(pos, isWhite, isAlive);
	}
	public King(boolean isWhite, boolean isAlive){
		super(isWhite, isAlive);
	}
	@Override
	public boolean checkMove(Move move, ChessBoard b) {
		return true;
	}
}
