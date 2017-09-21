package form;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Files 
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
				if(temp.length < 3)  //此行有错
					continue;
				List<Integer> propList = new ArrayList<>();
				for(int i = 1; i< temp.length; i+=2)
					propList.add(new Integer( Item.getProp(temp[i]) ));
				item = new Item(temp[0], propList);  //增加多重属性
				dictionary.add(item);
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("字典读取完毕, 共有" + dictionary.size() + "条词汇\n");
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
		System.out.println("测试文件读取完毕，共有" + list.size() + "个单词...\n");
		return list;
	}
}
