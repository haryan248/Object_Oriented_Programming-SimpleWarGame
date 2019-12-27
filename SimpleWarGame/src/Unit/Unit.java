package Unit;

import java.util.Scanner;

public class Unit {
	protected int Hp;
	protected int Attack;
	protected int x, y;
	protected int Move_range, Attack_range;
	protected String unit_name;
	Scanner sc = new Scanner(System.in);

	public Unit(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getAttack() {
		return Attack;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getUnitName() {
		return unit_name;
	}

	public boolean MoveRangeCheck(int x, int y) {
		if ((Math.abs(x) <= Move_range && Math.abs(y) <= Move_range))
			return true;
		else {
			System.out.print("Exceed Unit move range\n");
			return false;
		}
	}

	public boolean AttackRangeCheck(int x, int y) {
		if ((Math.abs(x) <= Attack_range && Math.abs(y) <= Attack_range))
			return true;
		else {
			System.out.print("Out of Range");
			return false;
		}
	}

	public void Move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void Heal(int heal, int player) {
		System.out.println(" Heal " + unit_name + player);
		Hp += heal;// Hp increase
		System.out.println(unit_name + player + "'s HitPoint inCrease " + (Hp-heal) + " to " + Hp);
	}

	public void Attack(int damage, int player) {
		System.out.println(" Attack " + unit_name + player);
		Hp -= damage;// Hp decrease
		if (Hp <= 0) {
			if (unit_name.equals("K")) {

				System.out.println(unit_name + player + "'s HitPoint decrease " + Hp + " to 0");
				System.out.println("----------------Player" + player + " Lose!----------------");
				System.out.println("----------------Game Over----------------");
				System.exit(1);// gameover

			} else {
				System.out.println(unit_name + player + "'s HitPoint decrease " + (Hp + damage) + " to 0");
				unit_name = "     ";
			}
		} else
			System.out.println(unit_name + player + "'s HitPoint decrease " + (Hp + damage) + " to " + Hp);
	}
}
