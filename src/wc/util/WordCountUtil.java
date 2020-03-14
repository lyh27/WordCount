package wc.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountUtil {
	
	//实现单词的统计
	
	public static int WordCount(String filename) {
		
		int wordCount=0;
		String sentence;
		BufferedReader br=null;
        try {
        	br = new BufferedReader(new FileReader(filename));
			while((sentence=br.readLine())!=null) {
				//将句子中的逗号，句号，问号，感叹号等替换成空格，方便统计单词个数
				 sentence =sentence.replace(",", " ");
				 sentence =sentence.replace("."," ");
				 sentence =sentence.replace("?"," ");
				 sentence =sentence.replace("!"," ");
				 wordCount += sentence.split(" ").length;
			}
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
        return wordCount;
		
	}

}
