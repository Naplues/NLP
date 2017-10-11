package auto.div.word;

import java.util.List;

import helper.Files;

/**
 * 一个基于词典与规则的汉语自动分词系统
 * UTF-8
 * @author gzq
 *
 */
public class Main {
	public static void main(String[] args) {
		//读入词典
		List<String> dic = Files.readChineseDictionary("resource/ce（ms-word）.txt");
		//读取句子
		List<String> sentence = Files.readTestFile("resource/sentence.txt");
		
		Divider.toWords(dic, sentence);
	}
}
