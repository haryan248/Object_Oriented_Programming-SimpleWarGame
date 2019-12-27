package Unit;

public class Healer extends Unit {

	public Healer(int x, int y) {
		super(x, y);
		unit_name = "H";
		Hp = 15;
		Attack = 3;
		Move_range = 1;
		Attack_range = 2;
	}
}
