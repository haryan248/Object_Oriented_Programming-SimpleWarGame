package Unit;

public class Archer extends Unit {
	public Archer(int x, int y) {
		super(x, y);
		unit_name = "A";
		Hp = 12;
		Attack = 3;
		Move_range = 2;
		Attack_range = 4;

	}

	@Override // Diagonal shift impossible
	public boolean MoveRangeCheck(int x, int y) {
		if (Math.abs(x) <= Move_range && Math.abs(y) <= Move_range) {
			if (x == 0 || y == 0)
				return true;
			else {
				System.out.print("This unit can't move diagonal direction\n");
				return false;
			}
		} else {
			System.out.print("Exceed Unit move range\n");
			return false;
		}
	}

	@Override
	public boolean AttackRangeCheck(int x, int y) {
		if (Math.abs(x) <= Attack_range && Math.abs(y) <= Attack_range) {
			if (x == 0 || y == 0)
				return true;
			else {
				System.out.print("This unit can't attack diagonal direction\n");
				return false;
			}
		} else {
			System.out.println("Out of Range");
			return false;
		}
	}
}