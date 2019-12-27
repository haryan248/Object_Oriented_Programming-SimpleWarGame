package Civil;

import Unit.Unit;
import java.util.Scanner;

public class Civil {
	protected Unit[] myUnit;
	protected int civil_num; // 0이면 korean, 1이면 japanese
	protected int player; // player 가 1 또는 2
	Scanner sc = new Scanner(System.in);

	public Civil() {

	}

	public int getX(int i) {
		return myUnit[i].getX();
	}

	public int getY(int i) {
		return myUnit[i].getY();
	}

	public int getCivilNum() {
		return civil_num;
	}

	public int getPlayer() {
		return player;
	}

	public String WhatUnit(int i) {
		return myUnit[i].getUnitName();
	}

	public boolean checkPos(int x, int y, int num) {
		for (int i = 0; i < num; i++) {
			if (myUnit[i].getX() == x && myUnit[i].getY() == y)
				return false;
		}
		return true;
	}

	public void moveUnit(Civil enemy) {
		int index, x, y;
		while (true) {
			y = sc.nextInt() - 1;
			x = sc.nextInt() - 1;
			index = findUnit(x, y);
			if (index == -1)
				System.out.println("It's not player" + player + "'s Unit");
			else
				break;
		}
		System.out.println(
				"You choose " + myUnit[index].getUnitName() + player + " in " + "(" + (y + 1) + ", " + (x + 1) + ")");
		int xx, yy;
		xx = myUnit[index].getX();
		yy = myUnit[index].getY();
		while (true) {
			System.out.println("Input Move Direction [(x,y) => (current x + x, current y + y)]");
			y = sc.nextInt();
			x = sc.nextInt();
			if ((myUnit[index].MoveRangeCheck(y, x) == false)) {
			} // 이동범위 검사
			else if ((enemy.findUnit(xx + x, yy + y) != -1) || (findUnit(xx + x, yy + y) != -1))
				System.out.println("Other Unit already here.");
			else {
				System.out.print(myUnit[index].getUnitName() + player + " move (" + (myUnit[index].getY() + 1) + ","
						+ (myUnit[index].getX() + 1) + ")");
				myUnit[index].Move(x, y);
				System.out.println(" to (" + (myUnit[index].getY() + 1) + "," + (myUnit[index].getX() + 1) + ")");
				break;
			}
		}
	}

	public int findUnit(int x, int y) {
		int num;
		if (civil_num == 0) {
			num = 11;
		} else {
			num = 12;
		}
		for (int i = 0; i < num; i++) {
			if (myUnit[i].getX() == x && myUnit[i].getY() == y) {
				return i;
			}
		}
		return -1;
	}
	public void attackUnit(Civil enemy) {
		int index, index2, x, y, damage;
		while (true) {
			y = sc.nextInt();
			x = sc.nextInt();
			index = findUnit(x - 1, y - 1);
			if (index == 0)
				System.out.println("King can't attack");
			else if (index == -1)
				System.out.println("It's not player" + player + "'s Unit");
			else {
				System.out.println(
						"You choose " + myUnit[index].getUnitName() + player + " in (" + y + "," + x + ") for Attack");
				damage = myUnit[index].getAttack();
				break;
			}

		}

		System.out.println("Select Target(Coordinate)");
		while (true) {
			y = sc.nextInt();
			x = sc.nextInt();
			index2 = enemy.findUnit(x - 1, y - 1);
			if (myUnit[index].AttackRangeCheck(Math.abs(myUnit[index].getY() - (y - 1)),
					Math.abs(myUnit[index].getX() - (x - 1))) == false) {
			} // 공격범위 검사
			else if (index2 == -1)
				System.out.println("It's not player" + enemy.getPlayer() + "'s Unit");
			else {
				System.out.println(
						"You choose " + myUnit[index].getUnitName() + player + " in (" + y + "," + x + ") for Target");
				System.out.print(myUnit[index].getUnitName() + player);
				enemy.damaged(damage, index2);
				
				break;
			}

		}

	}
	public void HealUnit() {
		int index, index2, x, y, heal;
		while (true) {
			y = sc.nextInt();
			x = sc.nextInt();
			index = findUnit(x - 1, y - 1);
			if (index == 10 || index == 11) {
				System.out.println(
						"You choose " + myUnit[index].getUnitName() + player + " in (" + y + "," + x + ") for Heal");
				heal = myUnit[index].getAttack();
				break;
			}
			else if (index == -1)
				System.out.println("It's not player" + player + "'s Unit");
			else {				
				System.out.println("This Unit can't Heal");
			}

		}

		System.out.println("Select Target(Coordinate)");
		while (true) {
			y = sc.nextInt();
			x = sc.nextInt();
			index2 = findUnit(x - 1, y - 1);
			if (myUnit[index].AttackRangeCheck(Math.abs(myUnit[index].getY() - (y - 1)),
					Math.abs(myUnit[index].getX() - (x - 1))) == false) {
			} // 공격범위 검사
			else if (index2 == -1)
				System.out.println("It's not player" + player + "'s Unit");
			else {
				System.out.println(
						"You choose " + myUnit[index].getUnitName() + player + " in (" + y + "," + x + ") for Healing");
				System.out.print(myUnit[index].getUnitName() + player);
				Healed(heal, index2);
				break;
			}

		}

	}
	public void Healed(int heal, int index) {
		myUnit[index].Heal(heal, player);
	}
	
	public void damaged(int damage, int index) {
		myUnit[index].Attack(damage, player);
	}
}
