package mul.cam.a.util;

import java.util.Date;

public class PdsUtil {
	
	// 파일명 -> 변경(time)
	
	// myfile.txt -> 214131351.txt
	public static String getNewFileName(String fileName) {
		String newFileName = "";
		String fpost = "";
		
		if (fileName.indexOf('.') >= 0) { // 확장자명이 있음
			fpost = fileName.substring(fileName.indexOf('.')); // .txt
			newFileName = new Date().getTime() + fpost; // 214131351 + .txt 
		} else { // 확장자 없음
			newFileName = new Date().getTime() + ".back"; // 214131351 + .back
		}
		
		return newFileName;
	}
	
}
