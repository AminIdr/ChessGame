package application;

public abstract class Piece {
	protected Position position;
	protected boolean isWhite, isAlive;
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
	public boolean isWhite() {
		return isWhite;
	}
	/**
	 * @param isWhite the isWhite to set
	 */
	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}
	/**
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	protected abstract boolean checkMove(Move move);
}
