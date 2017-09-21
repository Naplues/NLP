package form;

import java.util.List;

/**
 * 形态还原算法
 * @author gzq
 *
 */
public class Main 
{
	
	/**
	 * 获取单词原始形式,暂未实现
	 * @param word
	 * @return
	 */
	public static String getOriginForm(String word)
	{
		String origin = null;
		
		return origin;
	}
	
	
	
	public static void main(String[] args)
	{
		List<Item> dic = Files.readDictionaryFile("resource/dic_ec.txt");  //读取文件内容,存储字典
		//printDictionary(dic);
		List<String> words = Files.readTestFile("resource/test.txt");  //读取测试文件

		Item.printItem(dic, words);
		
	}
}
