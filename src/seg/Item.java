package seg;

import java.util.List;

/**
 * 字典条目
 * @author gzq
 *
 */
public class Item
{
	//单词属性
	public static int PROP_OTHER = 0;  //其他类别

	public static int PROP_ABBR = 1;    //略语
	public static int PROP_ADJ = 2;     //形容词
	public static int PROP_ADV = 3;     //副词
	public static int PROP_ART = 4;    //冠词
	public static int PROP_AUX = 5;    //助动词
	
	public static int PROP_CONJ = 6;    //连词
	
	public static int PROP_INT = 7;     //感叹词
	
	public static int PROP_NONE = 8;    //
	public static int PROP_NOUN = 9;    //名词
	public static int PROP_NUM = 10;    //数词
	
	public static int PROP_PL = 11;     //名词复数
	public static int PROP_PREP = 12;   //介词
	public static int PROP_PRON = 13;   //代词
	
	public static int PROP_VBL = 14;     //动词变体
	public static int PROP_VERB = 15;    //动词
	public static int PROP_VI = 16;     //不及物动词
	public static int PROP_VP = 17;     //
	public static int PROP_VT = 18;      //及物动词

	private String word;   //单词
	private List<Integer> property;  //属性
	
	
	public Item(String word, List<Integer> property) {
		super();
		this.word = word;
		this.property = property;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public List<Integer> getProperty() {
		return property;
	}
	public void setProperty(List<Integer> property) {
		this.property = property;
	}
	
	
	/**
	 * 返回对应属性
	 * @param prop
	 * @return
	 */
	public static int getProp(String prop)
	{
		int property = Item.PROP_NONE;
		
		switch (prop)
		{
			case "abbr.": property = Item.PROP_ABBR; break;
			case "adj.":  property = Item.PROP_ADJ; break;
			case "adv.":  property = Item.PROP_ADV; break;
			case "art.": property = Item.PROP_ART; break;
			case "aux.": property = Item.PROP_AUX; break;
			
			case "conj.": property = Item.PROP_CONJ; break;
			
			case "int.": property = Item.PROP_INT; break;
			
			case "none.": property = Item.PROP_NONE; break;
			case "n.":    property = Item.PROP_NOUN; break;
			case "num.": property = Item.PROP_NUM; break;
			
			case "pl.": property = Item.PROP_PL; break;
			case "prep.": property = Item.PROP_PREP; break;
			case "pron.": property = Item.PROP_PRON; break;
			
			case "vbl.": property = Item.PROP_VBL; break;
			case "v.":     property = Item.PROP_VERB; break;
			case "vi.": property = Item.PROP_VI; break;
			case "vp.": property = Item.PROP_VP; break;
			case "vt.": property = Item.PROP_VT; break;
			
			default:      property = Item.PROP_OTHER; break;
		}
		return property;
	}
	/**
	 * 输出属性
	 * @param type
	 * @return
	 */
	public static String printProp(int type)
	{
		String property = null;
		switch (type)
		{
			case 1 : property = "abbr."; break;
			case 2 : property = "adj."; break;
			case 3 : property = "adv."; break;
			case 4 : property = "art."; break;
			case 5 : property = "aux."; break;
			
			case 6 : property = "conj."; break;
			
			case 7 : property = "int."; break;
			
			case 8 : property = "none."; break;
			case 9 : property = "n."; break;
			case 10: property = "num."; break;
			
			case 11: property = "pl.";break;
			case 12: property = "prep."; break;
			case 13: property = "pron."; break;
			
			case 14: property = "vbl."; break;
			case 15: property = "v."; break;
			case 16: property = "vi."; break;
			case 17: property = "vp."; break;
			case 18: property = "vt."; break;
			
			default: property = "other"; break;
		}
		return property;
	}
	/**
	 * 重写toString方法
	 */
	public String toString()
	{
		String string = null;
		string = "单词：" + this.getWord() + " , 属性为 : ";
		for(Integer i : this.getProperty() )
		{
			string += Item.printProp(i) + " ";
		}
		return string;
	}
	

	/**
	 * 打印字典
	 * @param dic
	 */
	public static void printDictionary(List<Item> dic)
	{
		for( Item item : dic )
			System.out.println(item);
	}
	/**
	 * 匹配-ed形式的单词
	 * @param word
	 */
	public static String match(String word)
	{
		String origin = null;
		if(word.endsWith("ed"))
			origin = word.substring(0, word.length()-2);
		if(word.endsWith("ing"))
			origin = word.substring(0, word.length()-3);
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
			if( item.getWord().equals(word) )  //单词在字典中存在
				return item;
		}
		return null; //不存在
	}
	
	/**
	 * 获取单词原始形式,暂未实现
	 * @param word
	 * @return
	 */
	public static Item getOriginForm(List<Item> dictionary, String word)
	{
		Item item = null;
		if( null != (item = isExists(dictionary, word)) )  //单词本身是原型
		{
			return item;
		}
		if( null != (item = isExists(dictionary, match(word))) )  //单词-ed还原
		{
			return item;
		}
		return item;
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
			if( null != ( temp = getOriginForm(dictionary, word) ) )
			{
				System.out.println(temp);
			}
			else
			{
				System.out.println("暂未收录该单词--" + word + "...");
			}
		}
	}
}
