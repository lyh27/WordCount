package wc.main;

import java.util.ArrayList;
import java.util.List;

import wc.util.CharLengthUtil;
import wc.util.LineCountUtil;
import wc.util.OtherLineCountUtil;
import wc.util.WordCountUtil;

public class WCmain {
	
	//基于main函数中的args的指令输入
	public static void main(String[] args) {
		
		List<String> filenames =new ArrayList<>();	//利用集合存储文件
		List<String> commands =new ArrayList<>();	//存储指令
		for(int i=0;i<args.length;i++) {
			if(args[i].startsWith("-"))
				commands.add(args[i]);
			else {
				filenames.add(args[i]);
			}	
		}
		for(int j=0;j<commands.size();) {
			switch(commands.get(j)) {
				case "-c" :
					System.out.println("字符数为:" + CharLengthUtil.CharLength(filenames.get(filenames.size()-1)));
					break;
				case "-w" :
					System.out.println("单词数为:" + WordCountUtil.WordCount(filenames.get(filenames.size()-1)));
					break;
				case "-l" :
					System.out.println("行数为:" + LineCountUtil.LineCount(filenames.get(filenames.size()-1)));
					break;
				case "-a" :
					System.out.println("代码行/空行/注释行:" + OtherLineCountUtil.OtherLineCount(filenames.get(filenames.size()-1)));
					break;
				case "-s" :
					for(int i=0;i<filenames.size();i++) {
						System.out.println(filenames.get(i));
						System.out.println("字符数为:" + CharLengthUtil.CharLength(filenames.get(i)));
						System.out.println("单词数为:" + WordCountUtil.WordCount(filenames.get(i)));
						System.out.println("行数为:" + LineCountUtil.LineCount(filenames.get(i)));
						System.out.println("代码行/空行/注释行:" + OtherLineCountUtil.OtherLineCount(filenames.get(i)));
					}
				default:
					System.out.println("您的输入有误,请重新输入");
			}
					break;	
					
			
		}
			
	}
	
}
	
