package Unit;

public class Infantryman extends Unit {

	public Infantryman(int x, int y) {
		super(x, y);
		unit_name = "I";
		Hp = 24;
		Attack = 4;
		Move_range= 1;
		Attack_range= 1;
		//이동 거리 : 1칸/1턴
		//이동 방향 : 8방향
		//공격 범위 : 1칸
		//공격 방향 : 8방향
	}
}