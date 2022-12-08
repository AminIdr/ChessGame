package application;


public class ChessBoard {
	private Piece[][] board;
	
	public ChessBoard(Player black, Player white) {
		this.board = new Piece[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				this.board[i][j] = null;
			}
		}
		
		this.board[0][7] = white.getRooks()[0];
		white.getRooks()[0].setPosition(new Position(0, 7));
		this.board[7][7] = white.getRooks()[1];
		white.getRooks()[1].setPosition(new Position(7, 7));
		
		this.board[1][7] = white.getKnights()[0];
		white.getKnights()[0].setPosition(new Position(1, 7));
		this.board[6][7] = white.getKnights()[1];
		white.getKnights()[1].setPosition(new Position(6, 7));
		
		this.board[2][7] = white.getBishops()[0];
		white.getBishops()[0].setPosition(new Position(2, 7));
		this.board[5][7] = white.getBishops()[1];
		white.getBishops()[1].setPosition(new Position(5, 7));
				
		this.board[3][7] = white.getQueens()[0];
		white.getQueens()[0].setPosition(new Position(3, 7));
		this.board[4][7] = white.getKing();
		white.getKing().setPosition(new Position(4, 7));
		
		
		
		
		for(int i = 0; i < 8; i++) {
			this.board[i][1] = black.getPawns()[i];
			black.getPawns()[i].setPosition(new Position(i, 1));

			this.board[i][6] = white.getPawns()[i];
			white.getPawns()[i].setPosition(new Position(i, 6));

		}
		
		
		
		
		this.board[0][0] = black.getRooks()[0];
		black.getRooks()[0].setPosition(new Position(0, 0));
		this.board[7][0] = black.getRooks()[1];
		black.getRooks()[1].setPosition(new Position(7, 0));
		
		this.board[1][0] = black.getKnights()[0];
		black.getKnights()[0].setPosition(new Position(1, 0));
		this.board[6][0] = black.getKnights()[1];
		black.getKnights()[1].setPosition(new Position(6, 0));
		
		this.board[2][0] = black.getBishops()[0];
		black.getBishops()[0].setPosition(new Position(2, 0));
		this.board[5][0] = black.getBishops()[1];
		black.getBishops()[1].setPosition(new Position(5, 0));
				
		this.board[3][0] = black.getQueens()[0];
		black.getQueens()[0].setPosition(new Position(3, 0));
		this.board[4][0] = black.getKing();
		black.getKing().setPosition(new Position(4, 0));
	}
	
	
	
	// this constructor is for making a cloned chessBoard to check if the king will be 
	//in danger after a move.
	
	public ChessBoard(ChessBoard b){
		this.board = new Piece[8][8]; //initializes board
		//this for loop interates through board and fills it with null objects
		for(int i = 0; i<8; i++){
			for(int j = 0; j<8; j++){
				this.board[i][j] = null;
			}
		}
		/*
		 * This loop iterates through the board passed as a parameter,
		 * and for each piece found in the board, a piece of the same color
		 * and type is added to the new board object.
		 */
		for(int i = 0; i<8; i++){
			for(int j=0; j<8; j++){
				if(b.hasPiece(new Position(i, j))){
					if(b.getPiece(new Position(i, j)).getIsWhite() == false){ //case that piece is white
						if(b.getPiece(new Position(i, j)).getType() == "King"){
							this.board[i][j] = new King(new Position(i, j),false, true);
						}else if(b.getPiece(new Position(i, j)).getType() == "Queen"){
							this.board[i][j] = new Queen(new Position(i, j),false, true);
						}else if(b.getPiece(new Position(i, j)).getType() == "Rook"){
							this.board[i][j] = new Rook(new Position(i, j),false, true);
						}else if(b.getPiece(new Position(i, j)).getType() == "Bishop"){
							this.board[i][j] = new Bishop(new Position(i, j),false, true);
						}else if(b.getPiece(new Position(i, j)).getType() == "Knight"){
							this.board[i][j] = new Knight(new Position(i, j),false, true);
						}else if(b.getPiece(new Position(i, j)).getType() == "Pawn"){
							this.board[i][j] = new Pawn(new Position(i, j),false, true);
						}
					}else{ //case that piece is black
						if(b.getPiece(new Position(i, j)).getType() == "King"){
							this.board[i][j] = new King(new Position(i, j),true, true);
						}else if(b.getPiece(new Position(i, j)).getType() == "Queen"){
							this.board[i][j] = new Queen(new Position(i, j),true, true);
						}else if(b.getPiece(new Position(i, j)).getType() == "Rook"){
							this.board[i][j] = new Rook(new Position(i, j),true, true);
						}else if(b.getPiece(new Position(i, j)).getType() == "Bishop"){
							this.board[i][j] = new Bishop(new Position(i, j),true, true);
						}else if(b.getPiece(new Position(i, j)).getType() == "Knight"){
							this.board[i][j] = new Knight(new Position(i, j),true, true);
						}else if(b.getPiece(new Position(i, j)).getType() == "Pawn"){
							this.board[i][j] = new Pawn(new Position(i, j),true, true);
						}
					}
				}
			}
		}
	}
	
	
	public Piece getPiece(Position pos) {
		return this.board[pos.getX()][pos.getY()];
	}
	
	public void setPiece(Piece piece, Position pos) {
		this.board[pos.getX()][pos.getY()] = piece;
	}
	
	public boolean hasPiece(Position pos){
		if(getPiece(pos) != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void movePiece(Move move) {
		//this function assumes that there is a piece in the source and the move is legal.
		this.setPiece( this.getPiece(move.getSrc()), move.getDest());
		this.setPiece(null, move.getSrc());
	}
	
	
}