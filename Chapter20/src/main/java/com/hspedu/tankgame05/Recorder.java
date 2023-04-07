package com.hspedu.tankgame05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

public class Recorder {
	// 定义变量，记录我方击毁敌方坦克数
	private static int allEnemyTankNum = 0;
	private static BufferedReader br=null;
	private static BufferedWriter bw = null;
	private static String recordFile = "/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter20/src/main/java/com/hspedu/tankgame05/myrecord.txt";
	//定义Node 的Vector，用于保存敌人信息的node
	private static Vector<Node> nodes=new Vector<>();
	//定义Vector，指向MyPanel 对象的敌人坦克Vector
	private static Vector<EnemyTank> enemyTanks=null;
	
	public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
		Recorder.enemyTanks = enemyTanks;
	}
	//增加一个方法，用于读取recordFile，恢复相关信息
	public static Vector<Node> getNodesAndEnemyTankRec(){
		try {
			br = new BufferedReader(new FileReader(recordFile));
			allEnemyTankNum=Integer.parseInt(br.readLine());
			String line="";
			while((line=br.readLine())!=null) {
			String[] xyd= line.split(" ");
			Node node= new Node(Integer.parseInt(xyd[0]),Integer.parseInt (xyd[1]),Integer.parseInt (xyd[2]));
			nodes.add(node);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(br !=null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return nodes;
	}
	
	
	public static void keepRecord() {
    	try {
			bw = new BufferedWriter(new FileWriter(recordFile));
			bw.write(allEnemyTankNum+"\r\n");
			//遍历敌人坦克Vector，然后根据情况保存
			for(int i=0;i<enemyTanks.size();i++) {
				EnemyTank enemyTank=enemyTanks.get(i);
				if(enemyTank.isLive) {
					String record=enemyTank.getX()+" "+enemyTank.getY()+" "+enemyTank.getDirect();
					bw.write(record+"\r\n");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
    }
	public static int getAllEnemyTankNum() {
		return allEnemyTankNum;
	}

	public static void setAllEnemyTankNum(int allEnemyTankNum) {
		Recorder.allEnemyTankNum = allEnemyTankNum;
	}

	public static void addAllEnemyTankNum() {
		Recorder.allEnemyTankNum++;
	}

}
