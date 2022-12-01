package application;

public class Move {
	private Position src, dest;
	public Move(Position src, Position dest) {
		this.src = src;
		this.dest = dest;
	}
	/**
	 * @return the src
	 */
	public Position getSrc() {
		return src;
	}
	/**
	 * @param src the src to set
	 */
	public void setSrc(Position src) {
		this.src = src;
	}
	/**
	 * @return the dest
	 */
	public Position getDest() {
		return dest;
	}
	/**
	 * @param dest the dest to set
	 */
	public void setDest(Position dest) {
		this.dest = dest;
	}
}
