package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class DBManager {

	// コネクション確立
	private static Connection getConnection() {
		try {
			// DBDriver読み込み
			Class.forName("com.mysql.jdbc.Driver");
			// コネクション確立/(jdbc:mysql://(サーバー名)/(DB名),user名,password);
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shiritori", "root", "root");
			return con;
		} catch (Exception e) {
		}
		return null;
	}

	// DB検索メソッド List<T>をreturn
	<T> List<T> findList(String sql, RSMapping<T> mapping) throws SQLException {

		Connection con = null;
		Statement smt = null;
		List<T> wordList = new ArrayList<T>();
		try {
			con = getConnection();
			// ステートメント発行
			smt = con.createStatement();
			// 静的なSQL文実行、ResultSetオブジェクトを返す
			ResultSet rs = smt.executeQuery(sql);

			// WordMappingによってResultSetオブジェクトがビーンに詰められArrayListになる
			// 1つのリザルトが1WordObject(id,word,kana)
			while (rs.next()) {
				T bean = mapping.resultSet(rs);
				wordList.add(bean);
			}
			return wordList;

		} finally {
			// ステートメントとコネクション切断
			if (smt != null) smt.close();
			if (con != null) con.close();
		}
	}
}
