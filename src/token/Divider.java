package token;
/**
 * 分词类
 * @author gzq
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Divider {
	
	/**
	 * 句子到单词
	 * @param sentence
	 * @return
	 */
	public static List<String> toWords(List<String> dic, String sentence)
	{
		//打印原句
		System.out.println(sentence);
		System.out.print("分词后: ");
		
		List<String> list = new ArrayList<>();
		String sub = sentence.charAt(0) + "";
		String temp = "";
		for(int i = 0,j = 1;j <= sentence.length();)
		{
			sub = sentence.substring(i, j );
			if(isExists(dic, sub))   //字典中存在子串
			{
				temp = sub;
				if(j == sentence.length())
					System.out.print(sub + " ");
				j ++;
			}
			else 
			{
				if(sub.length() == 1)  //某个字不在词典中
				{
					j ++;
					System.out.print(sub + "/");
				}
				else
				{
					sub = temp;
					System.out.print(sub + "/");
					i = j - 1;
				}	
			}	
		}
		System.out.println();
		return list;
	}
	
	/**
	 * 多个句子到单词
	 * @param dic
	 * @param sentence
	 * @return
	 */
	public static List<String> toWords(List<String> dic, List<String> sentence)
	{
		for(String s : sentence)
		{
			toWords(dic, s);
		}
		return null;
	}
	
	/**
	 * 单词在词典中存在
	 * @param dic
	 * @param word
	 * @return
	 */
	public static boolean isExists(List<String> dic, String word)
	{
		for(String item : dic)
		{
			if( item.contains(word) )
				return true;
		}
		return false;
	}
}
