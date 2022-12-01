package application;

public class Queen extends Piece{
	public Queen(Position pos, boolean isWhite, boolean isAlive){
		super(pos, isWhite, isAlive);
	}
	public Queen(boolean isWhite, boolean isAlive){
		super(isWhite, isAlive);
	}
	@Override
	public boolean checkMove(Move move, ChessBoard b) {
		return true;
	}
}
