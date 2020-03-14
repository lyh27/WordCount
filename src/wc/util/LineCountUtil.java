package wc.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCountUtil {
	
	//实现行的统计
	
	public static int LineCount(String filename) {
		
		int line=0;
		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader(filename));
			while(br.readLine()!=null)
			    line++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return line;
	}
}
