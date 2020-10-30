package br.fsa.kernel;

import java.util.Random;

import com.sun.glass.ui.Size;

/**
 * 
 * Definicao do Batalha naval: 1 navio tamanho 5; 2 tamanho 4; 3 tamanho 3; 4
 * tamanho 2. 2 modos: 1) os navios podem se encostar; 2) os navios nao podem se
 * encostar
 *
 */

public class Kernel {

	public static final int SIZE = 10;
	private int[][] board;
	static int quantityShips = 10;
	Random random;

	public Kernel() {
		board = new int[SIZE][SIZE];
		populateBoard();
		random = new Random();
	}

	private  int[][] populateBoard() {
		int[][] newBoard = new int[SIZE][SIZE];
		int remainingNumberShips = quantityShips;
		int x = 0;
		int y = 0;
		Random randomNumber = new Random();
		do {
			x = 0;
			y = 0;
			for (int[] line : newBoard) {
				for (int column : line) {
					if (randomNumber.nextInt(100) <= 10) {
						if (column == 0) {
							newBoard[x][y] = 1;
							remainingNumberShips--;
							break;
						}

						if (remainingNumberShips <= 0) {
							break;
						}

					}
					y++;
				}
				y = 0;
				x++;
				if (remainingNumberShips <= 0) {
					break;
				}
			}

		} while (remainingNumberShips > 0);
		setBoard(newBoard);
		return newBoard;

	}

	public boolean shoot(String position) {

		// TODO Implementar o tiro

		return false;

	}

	public int[][] getPopulatedBoard() {
		
		return populateBoard();
		
	}

	public void setBoard(int[][] board) {

		this.board = board;
	}
	
	public int[][] getBoard() {

		return board;
	}

}
