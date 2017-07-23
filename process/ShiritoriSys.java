package process;

import java.util.List;

import state.Message;
import state.Pass;
import state.Rule;
import state.Word;

public class ShiritoriSys {
	private boolean userFree;
	private int count;
	private int turn;
	private String userWord;
	private String cpuWord;

	InputAction act;
	CheckWord check;
	Pass pass;
	Message mess;
	Rule rule;

	public ShiritoriSys() {
		this.act = new InputAction();
		this.check = new CheckWord();
		this.pass = new Pass();
		this.mess = new Message();
		this.rule = new Rule();
		this.turn = 1;
		play();
	}

	private void play() {
		System.out.println("---------START-----------");
		while (true) {
			// pass回数判定 3回passで終了
			if (1 < turn) if (pass.count()) break;
			System.out.println("---ターン " + turn + " --- ");
			// user入力
			userWord = act.action();
			// 終了判定 "exit"||末尾'ん'
			if (mess.end_if(userWord)) break;
			// userPass
			if (pass.user(userWord)) {
				userPass();
				continue;
			}

			// かな文字のみ可
			if (check.kana(userWord) != true) continue;
			// 先頭文字判定
			if (1 < turn && userWord.charAt(0) != firstChar() && !userFree) {
				System.out.println("先頭文字は \"" + firstChar() + "\" でなければいけません");
				continue;
			}

			// 既出チェック
			if (check.used(userWord) != true) {
				count++;
				// 3回既出||無効単語->userPass
				if (count == 3) {
					count = 0;
					pass.user("pass");
					userPass();
				}
				continue;
			}

			// cpuTurn
			if (turnCpu(userWord) != true) {
				count = 0;
				// cpuPass->userTurn
				pass.cpu();
				userFree = true;
				turn++;
			} else {
				System.out.println("先頭文字: " + firstChar());
				userFree = false;
				turn++;
			}
		} // while
		System.out.println("----------END------------");
	}

	// 先頭文字rule取得
	private char firstChar() {
		return rule.getFirstChar();
	}

	// userTurn
	private void userPass() {
		if (turnCpu("") != true) {
			pass.cpu();
			userFree = true;
			turn++;
		} else {
			// cpuTurn->userTurn
			System.out.println("先頭文字: " + firstChar());
			userFree = false;
			turn++;
		}
	}

	// cpuTURN
	private boolean turnCpu(String userWord) {
		MakeValue make = new MakeValue();
		EditChar edit = new EditChar();
		// userパスの場合
		if ("".equals(userWord)) {
			// ランダムな末尾文字取得
			userWord = String.valueOf(make.randomWord());
		}
		// 末尾が先頭文字の単語リスト作成
		List<Word> wordList = make.wordGroup(userWord);
		List<Integer> indexList = make.randomIndex(wordList.size());
		// CPU出力
		for (int i = 0; i <= wordList.size() - 1; i++) {
			// ランダムなindexの単語取得
			int index = indexList.get(i);
			cpuWord = wordList.get(index).getKana();
			// 既出check
			if (check.used(cpuWord)) {
				System.out.println("CPU > " + wordList.get(index).getWord());
				char c = edit.cutLast(cpuWord);
				rule.setFirstChar(c);
				return true;
			}
		}
		return false;
	}

}
