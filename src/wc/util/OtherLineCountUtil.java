package wc.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OtherLineCountUtil {

	//实现空行，代码行，注释行的统计
	
	public static String OtherLineCount(String filename) {
		// TODO Auto-generated method stub
		int codeLine=0;
		int emptyLine=0;
		int noteLine=0;
		String sentence;
		BufferedReader br=null;
		String result;
		boolean inNoteLine=false;
		try {
			br = new BufferedReader(new FileReader(filename));
			while((sentence=br.readLine())!=null){
				//统计/*的注释行
				if(inNoteLine==true) {
					noteLine++;
					if(sentence.endsWith("*/")||sentence.endsWith("*/}"))
						inNoteLine=false;
					continue;
					
				}
				if(sentence.startsWith("/*")||sentence.startsWith("{/*")) {
					noteLine++;
					if(!sentence.endsWith("*/")||!sentence.endsWith("*/}"))
						inNoteLine=true;
					continue;
				}
				//统计//的注释行
				if(sentence.startsWith("//")||sentence.startsWith("{//")) {
					noteLine++;
					continue;
				}
				//空行的统计
				if(sentence.equals("")||sentence.equals("{")||sentence.equals("}")||sentence.equals(" ")) {
					emptyLine++;
					continue;
				}
				//都不是的情况下统计代码行
				codeLine++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result=Integer.toString(codeLine)+"/"+Integer.toString(emptyLine)+"/"+Integer.toString(noteLine);
		return result;
	}

}
