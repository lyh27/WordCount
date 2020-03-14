package wc.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharLengthUtil {
	
	//实现字符的统计
	
	public static int CharLength(String filename){
		int countChar=0;
		String sentence;
		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader(filename));
			while((sentence = br.readLine())!= null)
				//去除句子中的空格，以免加入到字符的统计
				countChar += sentence.replace(" ","").length();
			
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
		return countChar;
	}
	
}
