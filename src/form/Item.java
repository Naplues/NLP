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
	
}
