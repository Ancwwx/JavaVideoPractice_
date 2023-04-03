package com.hspedu.tankgame04;

public class Bomb {
	int x, y;// 炸弹坐标
	int life = 16;// 炸弹生命周期
	boolean isLive = true; // 炸弹是否存活

	public Bomb(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void lifeDown() {
		if (life > 0) {
			life--;

		} else {
			isLive = false;
		}
	}

}
