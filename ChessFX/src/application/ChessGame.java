package application;

public class ChessGame {
	
	
	
	private Player black;
	private Player white;
	private boolean whiteTurn;
	private ChessBoard board;
	private Move[] movesPlayed;
	private String status;
			
	
	
	public ChessGame() {
		this.black = new Player(false);
		this.white = new Player(true);
		this.whiteTurn = true;
		this.board = new ChessBoard(black, white);
	}
	
	
	public void StartGame() {
		
	}
	
	
	//etant en etat echec on doit faire un move de sorte a ce que le 'king' ne soit plus en danger

	
	public boolean isDraw(ChessBoard board, Player thisPlayer, Player otherPlayer) {
		if(!this.isCheck(board, thisPlayer, otherPlayer)) {
			
			King thisKing = thisPlayer.getKing();
			Pawn[] thisPawns = thisPlayer.getPawns();
			Queen[] thisQueens = thisPlayer.getQueens();
			Bishop[] thisBishops = thisPlayer.getBishops();
			Rook[] thisRooks = thisPlayer.getRooks();
			Knight[] thisKnights = thisPlayer.getKnights();
			
			for(int i=-1; i<=1;i++) {
				for(int j=-1; j<=1;j++) {
					int oldX = thisKing.getPosition().getX();
					int oldY = thisKing.getPosition().getY();
					if(thisKing.checkMove(new Move(new Position(oldX, oldY), new Position(oldX + i, oldY + j)), board)) {
						ChessBoard boardCopy = new ChessBoard(board);
						boardCopy.movePiece(new Move(new Position(oldX, oldY), new Position(oldX + i, oldY + j)));
						if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
							return false;
						}
					}
				}
			}
			
			for(int i=0; i<8;i++) {
				for(int j=0; j<8;j++) {
					for(int k = 0; k<thisPawns.length; k++) {
						if(thisPawns[k] != null && thisPawns[k].checkMove(new Move(thisPawns[k].getPosition(), new Position(i,j)), board)) {
							ChessBoard boardCopy = new ChessBoard(board);
							boardCopy.movePiece(new Move(thisPawns[k].getPosition(), new Position(i,j)));
							if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
								return false;
							}
						}
					}
					
				}
			}
			
			for(int i=0; i<8;i++) {
				for(int j=0; j<8;j++) {
					for(int k = 0; k<thisQueens.length; k++) {
						if(thisQueens[k] != null && thisQueens[k].checkMove(new Move(thisQueens[k].getPosition(), new Position(i,j)), board)) {
							ChessBoard boardCopy = new ChessBoard(board);
							boardCopy.movePiece(new Move(thisQueens[k].getPosition(), new Position(i,j)));
							if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
								return false;
							}
						}
					}
					
				}
			}
			for(int i=0; i<8;i++) {
				for(int j=0; j<8;j++) {
					for(int k = 0; k<thisBishops.length; k++) {
						if(thisBishops[k] != null && thisBishops[k].checkMove(new Move(thisBishops[k].getPosition(), new Position(i,j)), board)) {
							ChessBoard boardCopy = new ChessBoard(board);
							boardCopy.movePiece(new Move(thisBishops[k].getPosition(), new Position(i,j)));
							if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
								return false;
							}
						}
					}
					
				}
			}
			for(int i=0; i<8;i++) {
				for(int j=0; j<8;j++) {
					for(int k = 0; k<thisRooks.length; k++) {
						if(thisRooks[k] != null && thisRooks[k].checkMove(new Move(thisRooks[k].getPosition(), new Position(i,j)), board)) {
							ChessBoard boardCopy = new ChessBoard(board);
							boardCopy.movePiece(new Move(thisRooks[k].getPosition(), new Position(i,j)));
							if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
								return false;
							}
						}
					}
					
				}
			}
			for(int i=0; i<8;i++) {
				for(int j=0; j<8;j++) {
					for(int k = 0; k<thisKnights.length; k++) {
						if(thisKnights[k] != null && thisKnights[k].checkMove(new Move(thisKnights[k].getPosition(), new Position(i,j)), board)) {
							ChessBoard boardCopy = new ChessBoard(board);
							boardCopy.movePiece(new Move(thisKnights[k].getPosition(), new Position(i,j)));
							if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
								return false;
							}
						}
					}
					
				}
			}
			
			return true;
			
			
		}
		
		return true;
	}

	public boolean isCheckMate(ChessBoard board, Player thisPlayer, Player otherPlayer) {
		if(this.isCheck(board, thisPlayer, otherPlayer)) {
			
			King thisKing = thisPlayer.getKing();
			Pawn[] thisPawns = thisPlayer.getPawns();
			Queen[] thisQueens = thisPlayer.getQueens();
			Bishop[] thisBishops = thisPlayer.getBishops();
			Rook[] thisRooks = thisPlayer.getRooks();
			Knight[] thisKnights = thisPlayer.getKnights();
			
			for(int i=-1; i<=1;i++) {
				for(int j=-1; j<=1;j++) {
					int oldX = thisKing.getPosition().getX();
					int oldY = thisKing.getPosition().getY();
					if(thisKing.checkMove(new Move(new Position(oldX, oldY), new Position(oldX + i, oldY + j)), board)) {
						ChessBoard boardCopy = new ChessBoard(board);
						boardCopy.movePiece(new Move(new Position(oldX, oldY), new Position(oldX + i, oldY + j)));
						if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
							return false;
						}
					}
				}
			}
			
			for(int i=0; i<8;i++) {
				for(int j=0; j<8;j++) {
					for(int k = 0; k<thisPawns.length; k++) {
						if(thisPawns[k].checkMove(new Move(thisPawns[k].getPosition(), new Position(i,j)), board)) {
							ChessBoard boardCopy = new ChessBoard(board);
							boardCopy.movePiece(new Move(thisPawns[k].getPosition(), new Position(i,j)));
							if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
								return false;
							}
						}
					}
					
				}
			}
			
			for(int i=0; i<8;i++) {
				for(int j=0; j<8;j++) {
					for(int k = 0; k<thisQueens.length; k++) {
						if(thisQueens[k].checkMove(new Move(thisQueens[k].getPosition(), new Position(i,j)), board)) {
							ChessBoard boardCopy = new ChessBoard(board);
							boardCopy.movePiece(new Move(thisQueens[k].getPosition(), new Position(i,j)));
							if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
								return false;
							}
						}
					}
					
				}
			}
			for(int i=0; i<8;i++) {
				for(int j=0; j<8;j++) {
					for(int k = 0; k<thisBishops.length; k++) {
						if(thisBishops[k].checkMove(new Move(thisBishops[k].getPosition(), new Position(i,j)), board)) {
							ChessBoard boardCopy = new ChessBoard(board);
							boardCopy.movePiece(new Move(thisBishops[k].getPosition(), new Position(i,j)));
							if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
								return false;
							}
						}
					}
					
				}
			}
			for(int i=0; i<8;i++) {
				for(int j=0; j<8;j++) {
					for(int k = 0; k<thisRooks.length; k++) {
						if(thisRooks[k].checkMove(new Move(thisRooks[k].getPosition(), new Position(i,j)), board)) {
							ChessBoard boardCopy = new ChessBoard(board);
							boardCopy.movePiece(new Move(thisRooks[k].getPosition(), new Position(i,j)));
							if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
								return false;
							}
						}
					}
					
				}
			}
			for(int i=0; i<8;i++) {
				for(int j=0; j<8;j++) {
					for(int k = 0; k<thisKnights.length; k++) {
						if(thisKnights[k].checkMove(new Move(thisKnights[k].getPosition(), new Position(i,j)), board)) {
							ChessBoard boardCopy = new ChessBoard(board);
							boardCopy.movePiece(new Move(thisKnights[k].getPosition(), new Position(i,j)));
							if(!this.isCheck(boardCopy, thisPlayer, otherPlayer)) {
								return false;
							}
						}
					}
					
				}
			}
			
			return true;
			
			
		}
		
		return false;
	}

	public boolean isCheck(ChessBoard board, Player thisPlayer, Player otherPlayer) {
		King otherKing = otherPlayer.getKing();
		Pawn[] otherPawns = otherPlayer.getPawns();
		Queen[] otherQueens = otherPlayer.getQueens();
		Bishop[] otherBishops = otherPlayer.getBishops();
		Rook[] otherRooks = otherPlayer.getRooks();
		Knight[] otherKnights = otherPlayer.getKnights();
		King thisKing = thisPlayer.getKing();
		
		if(otherKing.checkMove(new Move(otherKing.getPosition(), thisKing.getPosition()), board)) {
			return true;
		}
		
		for(int i = 0; i<otherPawns.length; i++) {
			if( otherPawns[i] != null) {
				if(otherPawns[i].checkMove(new Move(otherPawns[i].getPosition(), thisKing.getPosition()), board)) {
					return true;
				}
			}
		}
		for(int i = 0; i<otherQueens.length; i++) {
			if( otherQueens[i] != null) {
				if(otherQueens[i].checkMove(new Move(otherQueens[i].getPosition(), thisKing.getPosition()), board)) {
					return true;
				}
			}
		}
		for(int i = 0; i<otherBishops.length; i++) {
			if( otherBishops[i] != null) {
				if(otherBishops[i].checkMove(new Move(otherBishops[i].getPosition(), thisKing.getPosition()), board)) {
					return true;
				}
			}
		}
		for(int i = 0; i<otherRooks.length; i++) {
			if( otherRooks[i] != null) {
				if(otherRooks[i].checkMove(new Move(otherRooks[i].getPosition(), thisKing.getPosition()), board)) {
					return true;
				}
			}
		}
		for(int i = 0; i<otherKnights.length; i++) {
			if( otherKnights[i] != null) {
				if(otherKnights[i].checkMove(new Move(otherKnights[i].getPosition(), thisKing.getPosition()), board)) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	

}
