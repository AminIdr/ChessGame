package application;

public class Player {
	
	private King king;
	private Queen[] queens;
	private Bishop[] bishops;
	private Pawn[] pawns;
	private Rook[] rooks;
	private Knight[] knights;
	private boolean isWhite;


	public Player(boolean isWhite) {
		this.setIsWhite(isWhite);
		
		this.king = new King(isWhite, true);
		
		this.queens = new Queen[9];
		this.queens[0] = new Queen(isWhite, true);
		
		this.knights = new Knight[10];
		knights[0] = new Knight(isWhite, true);
		knights[1] = new Knight(isWhite, true);
		
		this.bishops = new Bishop[10];
		this.bishops[0] = new Bishop(isWhite, true);
		this.bishops[1] = new Bishop(isWhite, true);
		
		this.pawns = new Pawn[8];
		for(int i = 0; i < 8; i++) {
			this.pawns[i] = new Pawn(isWhite, true);
		}

		this.rooks = new Rook[10];
		this.rooks[0] = new Rook(isWhite, true);
		this.rooks[1] = new Rook(isWhite, true);
	}
	
	
	public void setKnights(Knight[] knights) {
		this.knights = knights;
	}
	public Knight[] getKnights() {
		return this.knights;
	}
	
	
	
	public void setQueens(Queen[] queens) {
		this.queens = queens;
	}
	public Queen[] getQueens() {
		return this.queens;
	}
	
	
	public void setKing(King king) {
		this.king = king;
	}
	public King getKing() {
		return this.king;
	}

	
	public Bishop[] getBishops() {
		return bishops;
	}
	public void setBishops(Bishop[] bishops) {
		this.bishops = bishops;
	}
	

	public Pawn[] getPawns() {
		return pawns;
	}
	public void setPawns(Pawn[] pawns) {
		this.pawns = pawns;
	}

	
	public Rook[] getRooks() {
		return rooks;
	}
	public void setRooks(Rook[] rooks) {
		this.rooks = rooks;
	}
	
	
	
	public Move takeMove() {
		return new Move(new Position(0,0), new  Position(0,0));
	}

	
	
	public boolean getIsWhite() {
		return isWhite;
	}
	public void setIsWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	


}