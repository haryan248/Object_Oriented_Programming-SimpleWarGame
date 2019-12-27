package Civil;

import Unit.Archer;
import Unit.Cavalry;
import Unit.Infantryman;
import Unit.King;
import Unit.Unit;
import Unit.Healer;

public class Korean extends Civil {
	public Korean(int p) {
		myUnit = new Unit[11];
		player = p;
		civil_num = 0;
		int x = 0, y = 0, num = 0;

		if (player == 1)
			myUnit[num++] = new King(5, 0);
		else
			myUnit[num++] = new King(5, 10);

		while (num < 11) {
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
			}// K 0 A12345 I67 C89 H10
			if (num < 6)
				myUnit[num] = new Archer(x, y);
			else if (num < 8)
				myUnit[num] = new Infantryman(x, y);
			else if (num < 10)
				myUnit[num] = new Cavalry(x, y);
			else
				myUnit[num] = new Healer(x, y);
			num++;
		}
	}
}