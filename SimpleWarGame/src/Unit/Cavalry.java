package Unit;

public class Cavalry extends Unit {

	public Cavalry(int x, int y) {
		super(x, y);
		unit_name = "C";
		Hp = 15;
		Attack = 6;
		Move_range = 3;
		Attack_range = 1;
	}
}