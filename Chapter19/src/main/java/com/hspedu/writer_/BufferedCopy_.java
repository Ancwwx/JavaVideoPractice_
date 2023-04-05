package com.hspedu.writer_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedCopy_ {
	public static void main(String[] args) {
		
		String srcFilePath ="../Resource/story1.txt";
		String destFilePath ="../Resource/story2.txt";
		BufferedReader br=null;
		BufferedWriter  bw=null;
		String line;
		
		try {
			br = new BufferedReader(new FileReader(srcFilePath));
			bw =new BufferedWriter(new FileWriter(destFilePath));
			while((line=br.readLine())!=null) {
				bw.write(line);
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
				} 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}

}
