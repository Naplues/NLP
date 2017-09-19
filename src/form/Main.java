package form;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 形态还原算法
 * @author gzq
 *
 */
public class Main 
{
	/**
	 * 读取字典文件内容
	 * @param filePath 文件路径
	 * @return 返回字典数组
	 */
	public static List<Item> readDictionaryFile(String filePath)
	{
		List<Item> dictionary = new ArrayList<>();
		File file = new File(filePath);
		if(!file.exists())
		{
			System.out.println("文件不存在，请检查文件路径是否正确");
			System.exit(1);
		}
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			String s = null;
			String[] temp = null;
			Item item = null;
			while( ( s = reader.readLine() ) != null )
			{
				temp = s.split("");
				if(temp.length < 2)  //此行有错
					continue;
				item = new Item(temp[0], Item.getProp(temp[1]));
				dictionary.add(item);
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("字典读取完毕, 共有" + dictionary.size() + "条词汇");
		return dictionary;
		
	}
	
	/**
	 * 读取测试文件
	 * @param filePath
	 * @return
	 */
	public static List<String> readTestFile(String filePath)
	{
		List<String> list = new ArrayList<>();
		File file = new File(filePath);
		if(!file.exists())
		{
			System.out.println("文件不存在，请检查文件路径是否正确");
			System.exit(1);
		}
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			String s = null;
			
			while( ( s = reader.readLine() ) != null )
			{
				list.add(s.trim());
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("测试文件读取完毕，共有" + list.size() + "个单词...");
		return list;
	}
	
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

	
	/**
	 * 判断单词是否存在
	 * @param dictionary
	 * @param word
	 * @return
	 */
	public static Item isExists(List<Item> dictionary, String word)
	{
		for(Item item : dictionary)
		{
			if( item.getWord().equals(word) )
				return item;
		}
		return null; //不存在
	}
	
	/**
	 * 输出查到的单词
	 * @param dictionary
	 * @param words
	 */
	public static void printItem(List<Item> dictionary, List<String> words)
	{
		Item temp = null;
		for( String word : words )
		{
			if( null != ( temp = isExists(dictionary, word) ) )
			{
				System.out.println("单词：" + temp.getWord() + " , 属性为 : " + Item.printProp(temp.getProperty()) );
			}
			else
			{
				System.out.println("暂未收录该单词--" + word + "...");
			}
		}
	}
	/**
	 * 打印字典
	 * @param dic
	 */
	public static void printDictionary(List<Item> dic)
	{
		for( Item item : dic )
		{
			System.out.println(item.getWord() + " " + item.getProperty() );
		}
	}
	
	public static void main(String[] args)
	{
		List<Item> dic = readDictionaryFile("resource/dic_ec.txt");  //读取文件内容,存储字典
		//printDictionary(dic);
		List<String> words = readTestFile("resource/test.txt");  //读取测试文件
		System.out.println();
		System.out.println();
		printItem(dic, words);
		
	}
}
