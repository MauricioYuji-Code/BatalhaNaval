package br.fsa.main;

import java.util.Scanner;

import br.fsa.cli.BattleShipCLI;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// Inicialização do game
		BattleShipCLI player1 = new BattleShipCLI();
		BattleShipCLI player2 = new BattleShipCLI();
		System.out.print("Show ship's? (y/n):");
		String showShips = sc.next();
		if(showShips.equals("y")) {
			player1.setPlayer("You");
		}else if (showShips.equals("n")) {
			player1.setPlayer("Cpu");
		}else {
			System.exit(0);
		}
		
		//player1.setPlayer("You");
		//player2.setPlayer("Cpu");
		player1.newGame();
		//player2.newGame();
		

		do {	
			player1.shoot();
				// TODO VALIDACAO DO FIM DO JOGO. ACAO DA CPU . VALIDACAO DO FIM DO JOGO
			
		} while (true);

	}

}
