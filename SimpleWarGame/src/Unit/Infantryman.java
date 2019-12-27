package Unit;

public class Infantryman extends Unit {

	public Infantryman(int x, int y) {
		super(x, y);
		unit_name = "I";
		Hp = 24;
		Attack = 4;
		Move_range= 1;
		Attack_range= 1;
	}
}