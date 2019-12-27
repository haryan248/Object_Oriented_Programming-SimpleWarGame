package Unit;

public class Cavalry extends Unit {

	public Cavalry(int x, int y) {
		super(x, y);
		unit_name = "C";
		Hp = 15;
		Attack = 6;
		Move_range = 3;
		Attack_range = 1;
		// 이동 거리 : 3칸/1턴
		// 이동 방향 : 8방향
		// 공격 범위 : 1칸
		// 공격 방향 : 8방향
	}
}