package com.hspedu.tankgame06;

public class Shot implements Runnable {
	int x;// 子弹x坐标
	int y;// 子弹y坐标
	int direct = 0; // 子弹方向
	int speed = 2;// 子弹速度
	boolean isLive = true;// 子弹是否存活

	public Shot(int x, int y, int direct) {
		super();
		this.x = x;
		this.y = y;
		this.direct = direct;
	}

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			switch (direct) {
			case 0: // 上
				y -= speed;
				break;
			case 1:// 右
				x += speed;
				break;
			case 2:// 下
				y += speed;
				break;
			case 3:// 左
				x -= speed;
				break;

			}
			// 启动的子弹销毁
			if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
				isLive = false;
				break;
			}
		}

	}

}
