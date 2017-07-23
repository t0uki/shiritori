package process;

import state.Rule;

class CheckWord {

	// 既出判定 処理が進む場合はtrue再帰はfalse
	boolean used(String word) {
		Rule rule = new Rule();
		if (rule.getUsedList().isEmpty()) {
			// 空の場合
			rule.setUsedList(word);
			printUsedWord(rule);
			return true;
		} else {
			if (rule.getUsedList().contains(word)) {
				// 既出
				System.out.println("すでに出た単語です: " + word);
				return false;
			} else {
				// 未出
				rule.setUsedList(word);
				printUsedWord(rule);
				return true;
			}
		}
	}

	// 既出単語表示
	private void printUsedWord(Rule rule) {
		// 出力
		System.out.println("------------");
		for (int i = 0; i <= rule.getUsedList().size() - 1; i++) {
			System.out.println(rule.getUsedList().get(i));
		}
		System.out.println("------------");
	}

	// かな文字 ^[\\u3040-\\u309F]+$
	boolean kana(String word) {
		// 単語内に使用不可文字があるか
		if (word.matches("^[\\u3040-\\u309F]+$")) {
			return true;
		}
		System.out.println("入力可能文字：ひらがな");
		return false;
	}
}
