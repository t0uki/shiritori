package state;

import java.util.ArrayList;

//beanClass
public class Rule {
	private char firstChar;
	private static ArrayList<String> usedList = new ArrayList<String>();
	private static ArrayList<String> printList = new ArrayList<String>();
	
	//user先頭文字
	public char getFirstChar() {
		return firstChar;
	}

	public void setFirstChar(char firstChar) {
		this.firstChar = firstChar;
	}

	// 判定用ひらがな単語リスト
	public ArrayList<String> getUsedList() {
		return usedList;
	}

	public void setUsedList(String word) {
		Rule.usedList.add(word);
	}

	// 出力用単語リスト
	public ArrayList<String> getPrintList() {
		return printList;
	}

	public void setPrintList(String word) {
		Rule.printList.add(word);
	}

}
