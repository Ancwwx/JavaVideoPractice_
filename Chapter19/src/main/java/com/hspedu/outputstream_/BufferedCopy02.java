package com.hspedu.outputstream_;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedCopy02 {
	public static void main(String[] args) {
		String srcFilePath = "../Resource/Nahida.jpg";
		String destFilePath = "../Resource/Nahida2.jpg";

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(srcFilePath));
			bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

			byte[] buff = new byte[1024];
			int readLen = 0;

			while ((readLen = bis.read(buff)) != -1) {
				bos.write(buff, 0, readLen);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();

				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
