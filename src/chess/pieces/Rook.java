package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position auxPosition = new Position(0,0);
		
		rookMovesUp(auxPosition, mat);
		rookMovesLeft(auxPosition, mat);
		rookMovesRight(auxPosition, mat);
		rookMovesDown(auxPosition, mat);
		
		return mat;
	}
	
	public void rookMovesUp(Position auxPosition, boolean[][] mat) {
		auxPosition.setValues(position.getRow()-1, position.getColumn());
		while(getBoard().positionExists(auxPosition) && !getBoard().thereisAPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setRow(auxPosition.getRow() - 1);
		}
		if(getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
	}
	
	public void rookMovesLeft(Position auxPosition, boolean[][] mat) {
		auxPosition.setValues(position.getRow(), position.getColumn() -1);
		while(getBoard().positionExists(auxPosition) && !getBoard().thereisAPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setColumn(auxPosition.getColumn() - 1);
		}
		if(getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
	}
	
	public void rookMovesRight(Position auxPosition, boolean[][] mat) {
		auxPosition.setValues(position.getRow(), position.getColumn() + 1);
		while(getBoard().positionExists(auxPosition) && !getBoard().thereisAPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setColumn(auxPosition.getColumn() + 1);
		}
		if(getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
	}
	
	public void rookMovesDown (Position auxPosition, boolean[][] mat) {
		auxPosition.setValues(position.getRow() + 1, position.getColumn());
		while(getBoard().positionExists(auxPosition) && !getBoard().thereisAPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setRow(auxPosition.getRow() + 1);
		}
		if(getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
	}
}
