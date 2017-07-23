package process;

public class EditChar {

	// 文字編集||末尾判定クラス
	char cutFirst(String word) {
		// 先頭文字切り出し
		char first = word.charAt(0);
		return first;
	}

	char cutLast(String word) {
		// 末尾文字切り出し
		char last = word.charAt(word.length() - 1);
		return last;
	}
}
