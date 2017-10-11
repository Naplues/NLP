package form;

import java.util.List;

import helper.Files;

/**
 * 形态还原算法
 * @author gzq
 *
 */
public class Main 
{
	
	
	public static void main(String[] args)
	{
		List<Item> dic = Files.readDictionaryFile("resource/dic_ec.txt");  //读取文件内容,存储字典
		//printDictionary(dic);
		List<String> words = Files.readTestFile("resource/test.txt");  //读取测试文件

		Item.printItem(dic, words);
		
	}
}
