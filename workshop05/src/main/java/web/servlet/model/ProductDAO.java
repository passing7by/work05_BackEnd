package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
	//공통적인 로직 템플릿
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;

	
	//비지니스 로직 템플릿
	void register(Product vo) throws SQLException;
	ArrayList<Product> findProducts() throws SQLException;
}
