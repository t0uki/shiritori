package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import state.Word;

public class WordMapping implements RSMapping<Word> {

	@Override
	public Word resultSet(ResultSet rs) throws SQLException {
		Word w = new Word();
		// DBのフィールド名指定し、結果をbeanにセット
		w.setId(rs.getInt("id"));
		w.setWord(rs.getString("word"));
		w.setKana(rs.getString("kana"));
		return w;
	}

}
