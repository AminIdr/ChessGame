package application;

public class Player {
	private final boolean isWhite;
	
	private King king;
	private Queen queen;
	private Knight[] knights;
	
	public Player(boolean isWhite) {
		this.isWhite = isWhite;
		this.king = new King(isWhite, true);
		this.queen = new Queen(isWhite, true);
		
		this.knights = new Knight[2];
		knights[0] = new Knight(isWhite, true);
		knights[1] = new Knight(isWhite, true);
	}
	
	public Knight getKnight(int i) {
		return this.knights[i];
	}

	public Queen getQueen() {
		return this.queen;
	}
	
	public King getKing() {
		return this.king;
	}
}