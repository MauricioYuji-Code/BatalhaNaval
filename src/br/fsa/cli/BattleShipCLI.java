package br.fsa.cli;

import java.util.Scanner;

import br.fsa.interfac.BattleShipGame;
import br.fsa.kernel.Kernel;

public class BattleShipCLI implements BattleShipGame {

	Kernel game;
	public static final boolean Debug = true;
	private String player = "";
	boolean yourBoard = true;
	Scanner sc = new Scanner(System.in);
	private int numberShips = 10;

	@Override
	public void newGame() {
		game = new Kernel();
		atualizaBoard();
	}

	public void setPlayer(String player) {
		if (player == "Cpu") {

			yourBoard = false;

		}

		this.player = player;
	}

	private void atualizaBoard() {

		System.out.println("|------BATTLE SHIP GAME------|");
		System.out.println("***Syntax***");
		System.out.println("*type the letter first and then the number (Example: A1)");
		System.out.println("*to exit the game type 'q'");
		System.out.println("Player:   " + player);
		char columnLetter = 65; // Caracter da letra A
		String lettersBoard = "   ";
		for (int i = 0; i < 10; i++) {

			lettersBoard += (columnLetter++) + " ";

		}
		System.out.println(lettersBoard);
		System.out.println("  +-------------------+");
		String lineBoard = "";
		// boolean yourBoard = true;
		int numberLine = 1;
		for (int[] line : game.getBoard()) {
			lineBoard = (numberLine++) + "|";

			for (int column : line) {

				switch (column) {
				case 0: // vazio
					lineBoard += " |";
					break;
				case 1: // navio

					if (yourBoard) {// mostrar onde estao os navios
						lineBoard += "S|";
						break;

					} else {
						lineBoard += " |";
						break;
					}

				case 2: // erro
					lineBoard += "X|";
					break;

				case 3: // acertou
					lineBoard += "D|";
					break;
				}
			}
			System.out.println(lineBoard);

		}
		System.out.println();

		if (Debug) {
			// mostrar tudo que tem nas células
		} else {
			// ocultar seundo matriz de visitação
		}
	}

	@Override
	public boolean shoot() {
		System.out.print("Digite a posição do tiro: \n");
		String shoot = sc.next();
		String regularExpression = "^[A-Ja-j]{1}([1-9]|10){1}$";

		if (shoot.matches(regularExpression)) {
			String aux = shoot.toLowerCase();
			int positionX = shoot.charAt(0) - 97;
			int positionY = Integer.parseInt(shoot.substring(1)) - 1;
			// System.out.print("OK");
			int[] shootPosition = shootPositionForBoard(positionX, positionY, shoot);
			// verification
			if (positionX > 9 && positionY > 9) {
				System.out.print("Wrong position!");
			}

			if (game.getBoard()[shootPosition[0]][shootPosition[1]] == 1) {
				int[][] auxBoard = game.getBoard();
				auxBoard[shootPosition[0]][shootPosition[1]] = 3;
				game.setBoard(auxBoard);
				;
				atualizaBoard();
				System.out.println("You hit a ship!");
				numberShips --;
				if(numberShips == 0) {
					System.out.println("Game Over");
					System.exit(0);	
				}
				
			} else {
				game.getBoard()[shootPosition[0]][shootPosition[1]] = 2;
				atualizaBoard();
				System.out.println("You missed!");
			}

			return true;
		} else if (shoot.equals("q")) {
			System.out.print("Bye bye =)");
			System.exit(0);	
		} else {
			System.out.print("SYNTAX ERROR");
			System.exit(0);
		}
		return false;
	}

	public static int[] shootPositionForBoard(int positionX, int positionY, String aux) {
		int[] ret = new int[2];

		ret[0] = Integer.parseInt(aux.substring(1)) - 1;
		ret[1] = aux.charAt(0) - 97;
		return ret;

	}

}
