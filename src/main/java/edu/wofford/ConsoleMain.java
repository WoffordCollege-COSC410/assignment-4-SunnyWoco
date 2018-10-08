package edu.wofford;

import java.util.Scanner;

public class ConsoleMain {

	public static void main(String[] args) {
		TicTacToeModel model = new TicTacToeModel();
		Scanner keyboard = new Scanner(System.in);
		while(model.getResult() == TicTacToeModel.Result.NONE){
			int i = keyboard.nextInt();
			int j = keyboard.nextInt();
			model.setMarkAt(i,j);
			System.out.println(model.toString());
		}
		if (model.getResult() == TicTacToeModel.Result.XWIN){
			System.out.println("X wins");
		}
		if (model.getResult() == TicTacToeModel.Result.OWIN){
			System.out.println("O wins");
		}
		if (model.getResult() == TicTacToeModel.Result.TIE){
		System.out.println("Tie");
	}
	}
}