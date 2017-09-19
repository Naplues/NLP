package form;
/**
 * 字典条目
 * @author gzq
 *
 */
public class Item 
{
	//单词属性
	public static int PROP_OTHER = -1;
	public static int PROP_NONE = 0;
	public static int PROP_ABBR = 1;
	public static int PROP_NOUN = 2;
	public static int PROP_VERB = 3;
	public static int PROP_ADJ = 4;
	public static int PROP_ADV = 5;
	public static int PROP_CONJ = 6;
	
	private String word;   //单词
	private int property;  //属性
	
	
	public Item(String word, int property) {
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
	public int getProperty() {
		return property;
	}
	public void setProperty(int property) {
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
			case "none.": property = Item.PROP_NONE; break;
			case "abbr.": property = Item.PROP_ABBR; break;
			case "n.":    property = Item.PROP_NOUN; break;
			case "v.":     property = Item.PROP_VERB; break;
			case "adj.":  property = Item.PROP_ADJ; break;
			case "adv.":  property = Item.PROP_ADV; break;
			case "conj.": property = Item.PROP_CONJ; break;
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
			case 0 : property = "none."; break;
			case 1 : property = "abbr."; break;
			case 2 : property = "n."; break;
			case 3 : property = "v."; break;
			case 4 : property = "adj."; break;
			case 5 : property = "adv."; break;
			case 6 : property = "conj."; break;
			default: property = "other"; break;
		}
		return property;
	}
}
