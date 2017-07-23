package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

interface RSMapping<T> {
	T resultSet(ResultSet rs) throws SQLException;
}
