package application;

public abstract class Piece {
	protected Position position;
	protected boolean isWhite, isAlive, hasMoved = false;
	
	
	public Piece(Position pos, boolean isWhite, boolean isAlive) {
		this.position = pos;
		this.isWhite = isWhite;
		this.isAlive = isAlive;
	}
	public Piece(boolean isWhite, boolean isAlive) {
		this.isWhite = isWhite;
		this.isAlive = isAlive;
	}
	
	
	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	/**
	 * @return the isWhite
	 */
	public boolean getIsWhite() {
		return isWhite;
	}
	/**
	 * @param isWhite the isWhite to set
	 */
	public void setIsWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	/**
	 * @return the isAlive
	 */
	public boolean getIsAlive() {
		return isAlive;
	}
	/**
	 * @param isAlive the isAlive to set
	 */
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public boolean getHasMoved() {
		return this.hasMoved;
	}
	
	public void setHasMoved() {
		this.hasMoved = true;
	}
	
	protected abstract boolean checkMove(Move move, ChessBoard b);
	protected abstract String getType();

}
