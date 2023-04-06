package com.hspedu.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Properties01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new FileReader("/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter19/src/main/java/mysql.properties"));
		String line="";
		while((line=br.readLine())!=null){
			String[] split=line.split("=");
			System.out.println(split[0]+"值是: "+split[1]);
		}
		br.close();
	}

}
