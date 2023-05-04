package com.hspedu.regexp;

public class StringReg {
	public static void main(String[] args) {
		String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其" + "获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发"
				+ "布。" + "2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升";
		content = content.replaceAll("JDK1\\.3|JDK1.4", "JDK");
		System.out.println(content);
		content = "13988889999";
		if (content.matches("1(38|39)\\d{8}")) {
			System.out.println("验证成功");
		} else {
			System.out.println("验证失败");
		}
		content = "hello#abc-jack12smith~北京";
		String[] split = content.split("#|-|~|\\d+");
		for (String s : split) {
			System.out.println(s);
		}

	}

}
