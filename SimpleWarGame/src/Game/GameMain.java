package Game;

import java.util.Scanner;

import Civil.Civil;
import Civil.Japanese;
import Civil.Korean;

public class GameMain {
	Scanner sc = new Scanner(System.in);
	public String[][] map;
	public Civil[] civil;

	public GameMain() {
		civil = new Civil[2];
		map = new String[11][11];

		boardInit();
	}

	public void boardInit() {
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 11; j++)
				map[i][j] = "     ";
	}

	public void drawUnit() {
		int x, y, num, player;
		String unit_name;
		boardInit();
		for (int i = 0; i < 2; i++) {
			player = civil[i].getPlayer();
			num = civil[i].getCivilNum();
			switch (num) {
			case 0:
				for (int j = 0; j < 11; j++) {
					x = civil[i].getX(j);
					y = civil[i].getY(j);
					unit_name = civil[i].WhatUnit(j);

					switch (unit_name) {
					case "K":
						map[x][y] = unit_name + Integer.toString(player) + "   ";
						break;
					case "A":
						map[x][y] = unit_name + Integer.toString(player) + "   ";
						break;
					case "I":
						map[x][y] = unit_name + Integer.toString(player) + "   ";
						break;
					case "C":
						map[x][y] = unit_name + Integer.toString(player) + "   ";
						break;
					case "H":
						map[x][y] = unit_name + Integer.toString(player) + "   ";
						break;
					default:
						break;
					}

				}
				break;
			case 1:
				for (int j = 0; j < 12; j++) {
					x = civil[i].getX(j);
					y = civil[i].getY(j);
					unit_name = civil[i].WhatUnit(j);

					switch (unit_name) {
					case "K":
						map[x][y] = unit_name + Integer.toString(player) + "   ";
						break;
					case "A":
						map[x][y] = unit_name + Integer.toString(player) + "   ";
						break;
					case "I":
						map[x][y] = unit_name + Integer.toString(player) + "   ";
						break;
					case "C":
						map[x][y] = unit_name + Integer.toString(player) + "   ";
						break;
					case "H":
						map[x][y] = unit_name + Integer.toString(player) + "   ";
						break;
					default:
						break;
					}

				}
				break;
			}

		}
	}

	public void draw() {
		drawUnit();
		System.out.println("    1     2     3     4     5     6     7     8     9     10    11");
		System.out.println("  旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
		for (int i = 0; i < 11; i++) {
			System.out.printf("%2d", i + 1);
			System.out.print("早");
			for (int j = 0; j < 11; j++) {
				System.out.print(map[i][j] + "早");
			}
			System.out.println();
			if (i == 10)
				System.out.println("  曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
			else
				System.out.print("  曳收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收朽");
			System.out.println("");
		}
	}

	public void Run() {
		int num;
		boolean turn = true; // 1欐 true, 2欐 false

		System.out.println("====Simple War Simulation Game====");
		for (int i = 0; i < 2; i++) {
			System.out.println("Select Player" + (i + 1) + "'s Civilization");
			System.out.println("1. Korea");
			System.out.println("2. Japan");
			System.out.print("==>>");
			num = sc.nextInt();
			switch (num) {
			case 1:
				civil[i] = new Korean(i + 1);
				System.out.println("You choose Korean.");
				break;
			case 2:
				civil[i] = new Japanese(i + 1);
				System.out.println("You choose Japanese.");
				break;
			default:
				System.out.println("Please re-enter.");
				i--;
				break;
			}
		}

		while (true) {
			draw(); // 啪歜 裘擊 爾罹邀
			if (turn == true) {
				System.out.println("Player1's turn.");
			} else
				System.out.println("Player2's turn.");
			System.out.println("1. Move");
			System.out.println("2. Attack");
			System.out.println("3. Heal(Only Healer)");
			System.out.println("4. ChangeTurn");
			num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("Choose Move - Select Unit(Coordinate)");
				if (turn)
					civil[0].moveUnit(civil[1]);
				else
					civil[1].moveUnit(civil[0]);
				turn = !turn;
				break;
			case 2:
				System.out.println("Choose Attack - Select Unit for Attack(Coordinate)");
				if (turn)// player 1
					civil[0].attackUnit(civil[1]);
				else // player 2
					civil[1].attackUnit(civil[0]);
				turn = !turn;// change turn
				break;
			case 3:
				System.out.println("Choose Heal - Select Unit for Heal(Coordinate)");
				if (turn)// player 1
					civil[0].HealUnit();
				else // player 2
					civil[1].HealUnit();
				turn = !turn;//change turn
				break;
			case 4:
				turn = !turn;//change turn
				break;
			default:
				System.out.println("Please re-enter.");
				break;
			}
		}
	}
}