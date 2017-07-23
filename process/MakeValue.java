package process;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import dao.WordDao;
import state.Word;

public class MakeValue {
	private final String KANA = "あいうえお" + "かきくけこ" + "さしすせそ" + "たちつてと" + "なにぬねの" + "はひふへほ" + "まみむめも" + "やゆよ" + "わ";

	// userInの末尾文字が先頭の単語リスト作成
	List<Word> wordGroup(String userIn) {
		WordDao dao = new WordDao();
		EditChar edit = new EditChar();
		try {
			List<Word> group = dao.getWords(edit.cutLast(userIn));
			return group;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Sorry system stop");
			System.exit(0);
			return null;
		}
	}

	// ランダムな末尾文字作成
	char randomWord() {
		Random r = new Random();
		int i = r.nextInt(KANA.length());
		return KANA.charAt(i);
	}

	// 単語リストのmax値までのランダムな値生成
	List<Integer> randomIndex(int max) {
		List<Integer> L = new ArrayList<Integer>();
		for (int i = 0; i <= max - 1; i++) {
			L.add(i);
		}
		Collections.shuffle(L);
		return L;
	}
}
