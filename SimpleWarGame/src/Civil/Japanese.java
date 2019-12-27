package Civil;

import Unit.Archer;
import Unit.Cavalry;
import Unit.Healer;
import Unit.Infantryman;
import Unit.King;
import Unit.Unit;

public class Japanese extends Civil {

	public Japanese(int p) {
		myUnit = new Unit[12];
		player = p;
		civil_num = 1;
		int x = 0, y = 0, num = 0;

		if (player == 1)
			myUnit[num++] = new King(5, 0);
		else
			myUnit[num++] = new King(5, 10);

		while (num < 12) {
			switch (player) {
			case 1:
				do {
					x = (int) (Math.random() * 11);
					y = (int) (Math.random() * 4);
				} while (!checkPos(x, y, num));
				break;
			case 2:
				do {
					x = (int) (Math.random() * 11);
					y = (int) (Math.random() * 4 + 7);
				} while (!checkPos(x, y, num));
				break;
			}// K0 A123 I45678 C910 H11
			if (num < 4)
				myUnit[num] = new Archer(x, y);
			else if (num < 9)
				myUnit[num] = new Infantryman(x, y);
			else if (num < 11)
				myUnit[num] = new Cavalry(x, y);
			else
				myUnit[num] = new Healer(x, y);
			num++;
		}
	}
}
