package dao;

import java.sql.SQLException;
import java.util.List;

import state.Word;

public class WordDao {

	public List<Word> getWords(char c) throws SQLException {
		DBManager db = new DBManager();
		WordMapping mapping = new WordMapping();

		// SQL文作成 末尾が先頭文字の単語リスト取得しreturn;
		String sql = "SELECT * FROM SHIRITOLIST WHERE KANA like'" + c + "%'";
		// System.out.println(sql);
		// 単語リスト
		try {
			return db.findList(sql, mapping);
		} catch (SQLException e) { // DBManagerのSQLExceptionをcatch
			throw new IllegalStateException(e);
		}
	}

}
