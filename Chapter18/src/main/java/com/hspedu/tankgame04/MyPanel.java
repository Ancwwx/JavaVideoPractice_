package com.hspedu.tankgame04;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener, Runnable {
	Hero hero = null;
	// 定义敌人坦克，放入Vector
	Vector<EnemyTank> enemyTanks = new Vector<>();

	// 定义一个Vector,用于存放炸弹
	Vector<Bomb> bombs = new Vector<>();
	int enemyTankSize = 3;
	// 定义三张爆炸图片，用于显示爆炸效果
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;

	public MyPanel() {
		hero = new Hero(100, 100);
		hero.setSpeed(7);

		// 初始化敌人坦克
		for (int i = 0; i < enemyTankSize; i++) {
			// 创建一个敌人坦克
			EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
			enemyTank.setSpeed(2);
			// 设置方向
			enemyTank.setDirect(2);
			// 启动敌人坦克线程
			new Thread(enemyTank).start();
			// 给enemyTank 加入一颗子弹
			Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
			enemyTank.shots.add(shot);
			new Thread(shot).start();
			enemyTanks.add(enemyTank);
		}
		// 初始化爆炸图片对象

		image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb1.png"));
		image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb2.png"));
		image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb3.png"));

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 1000, 750);

		drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

//		if (hero.shot != null && hero.shot.isLive == true) {
//			g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
//		}
		for (int i = 0; i < hero.shots.size(); i++) {
			Shot shot = hero.shots.get(i);
			if (shot != null && shot.isLive == true) {
				g.draw3DRect(shot.x, shot.y, 1, 1, false);
			} else {
				hero.shots.remove(shot);
			}
		}

		for (int i = 0; i < bombs.size(); i++) {
			Bomb bomb = bombs.get(i);
			if (bomb.life > 8) {
				g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
			} else if (bomb.life > 4) {
				g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
			} else {
				g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
			}
			bomb.lifeDown();
			if (bomb.life == 0) {
				bombs.remove(bomb);
			}

		}

		// 画出敌人坦克，遍历Vector
		for (int i = 0; i < enemyTanks.size(); i++) {
			EnemyTank enemyTank = enemyTanks.get(i);
			if (enemyTank.isLive) {
				drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
				// 画出 enemyTank所有子弹
				for (int j = 0; j < enemyTank.shots.size(); j++) {
					// 取出子弹
					Shot shot = enemyTank.shots.get(j);
					if (shot.isLive) {
						g.draw3DRect(shot.x, shot.y, 1, 1, false);
					} else {
						enemyTank.shots.remove(shot);
					}
				}
			}
		}

	}

	public void drawTank(int x, int y, Graphics g, int direct, int type) {

		switch (type) {
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		switch (direct) {
		case 0: // up

			g.fill3DRect(x, y, 10, 60, false);
			g.fill3DRect(x + 30, y, 10, 60, false);
			g.fill3DRect(x + 10, y + 10, 20, 40, false);
			g.fillOval(x + 10, y + 20, 20, 20);
			g.drawLine(x + 20, y + 30, x + 20, y);

			break;
		case 1: // right
			g.fill3DRect(x, y, 60, 10, false);
			g.fill3DRect(x, y + 30, 60, 10, false);
			g.fill3DRect(x + 10, y + 10, 40, 20, false);
			g.fillOval(x + 20, y + 10, 20, 20);
			g.drawLine(x + 30, y + 20, x + 60, y + 20);

			break;
		case 2: // down
			g.fill3DRect(x, y, 10, 60, false);
			g.fill3DRect(x + 30, y, 10, 60, false);
			g.fill3DRect(x + 10, y + 10, 20, 40, false);
			g.fillOval(x + 10, y + 20, 20, 20);
			g.drawLine(x + 20, y + 30, x + 20, y + 60);

			break;
		case 3: // left
			g.fill3DRect(x, y, 60, 10, false);
			g.fill3DRect(x, y + 30, 60, 10, false);
			g.fill3DRect(x + 10, y + 10, 40, 20, false);
			g.fillOval(x + 20, y + 10, 20, 20);
			g.drawLine(x + 30, y + 20, x, y + 20);

			break;
		default:
			System.out.println("暂时未处理");
		}

	}
	public void hitEnemyTank() {
		for(int j=0;j<hero.shots.size();j++ ) {
			Shot shot=hero.shots.get(j);
			// 判断是否击中敌人坦克
			if (shot != null && shot.isLive) {
				for (int i = 0; i < enemyTanks.size(); i++) {
					EnemyTank enemyTank = enemyTanks.get(i);
					hitTank(shot, enemyTank);
				}
			}
		}
		
	}

	// 编写方法，判断我方子弹是否击中敌人
	public void hitTank(Shot s, EnemyTank enemyTank) {
		switch (enemyTank.getDirect()) {
		case 0:
		case 2:
			if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40 && s.y > enemyTank.getY()
					&& s.y < enemyTank.getY() + 60) {
				s.isLive = false;
				enemyTank.isLive = false;
				enemyTanks.remove(enemyTank);
				Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
				bombs.add(bomb);

			}
			break;
		case 1:
		case 3:
			if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60 && s.y > enemyTank.getY()
					&& s.y < enemyTank.getY() + 40) {
				s.isLive = false;
				enemyTank.isLive = false;
				enemyTanks.remove(enemyTank);
				Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
				bombs.add(bomb);

			}
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_W) {
			hero.setDirect(0);
			if (hero.getY() > 0) {
				hero.moveUp();
			}

		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			hero.setDirect(1);
			if (hero.getX() + 60 < 1000) {
				hero.moveRight();
			}

		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			hero.setDirect(2);
			if (hero.getY() + 60 < 750) {
				hero.moveDown();
			}

		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			hero.setDirect(3);
			if (hero.getX() > 0) {
				hero.moveLeft();
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_J) {
//				if (hero.shot == null || !hero.shot.isLive) {
//					hero.shotEnemyTank();
//				
//				}
			hero.shotEnemyTank();
		}

		this.repaint();
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
             hitEnemyTank();
			this.repaint();
		}
	}
}
