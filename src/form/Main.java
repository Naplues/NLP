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
				item = new Item(temp[0], getProp(temp[1]));
				dictionary.add(item);
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("字典读取完毕...");
		return dictionary;
		
	}
	
	/**
	 * 返回对应属性
	 * @param prop
	 * @return
	 */
	public static int getProp(String prop)
	{
		int property = Item.PROP_NONE;
		
		switch (prop) {
		case "none.":
			property = Item.PROP_NONE;
			break;
		case "abbr.":
			property = Item.PROP_ABBR;
			break;
		case "n.":
			property = Item.PROP_NOUN;
			break;
		case "v":
			property = Item.PROP_VERB;
			break;
		case "adj.":
			property = Item.PROP_ADJ;
			break;
		case "adv":
			property = Item.PROP_ADV;
			break;
		default:
			property = Item.PROP_OTHER;
			break;
		}
		return property;
	}
	
	/**
	 * 判断单词是否存在
	 * @param dictionary
	 * @param word
	 */
	public static void isExists(Item[] dictionary, String word)
	{
		
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
		List<Item> dic = readDictionaryFile("resource/dic_ec.txt");  //读取文件内容
		printDictionary(dic);
	}
}
