package com.hspedu.tankgame03;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener, Runnable {
	Hero hero = null;

	Vector<EnemyTank> enemyTanks = new Vector<>();
	int enemyTankSize = 3;

	public MyPanel() {
		hero = new Hero(100, 100);
		hero.setSpeed(3);
		for (int i = 0; i < enemyTankSize; i++) {
			EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
			enemyTank.setDirect(2);
			enemyTanks.add(enemyTank);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 1000, 750);

		drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

		if (hero.shot != null && hero.shot.isLive == true) {
			g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
		}

		for (int i = 0; i < enemyTanks.size(); i++) {
			EnemyTank enemyTank = enemyTanks.get(i);
			drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
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
			hero.moveUp();

		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			hero.setDirect(1);
			hero.moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			hero.setDirect(2);
			hero.moveDown();
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			hero.setDirect(3);
			hero.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_J) {
			hero.shoyEnemyTank();
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
			this.repaint();
		}
	}
}
