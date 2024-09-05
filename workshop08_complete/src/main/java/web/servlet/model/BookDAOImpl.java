package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAOImpl implements BookDAO{
	//추가...
	private DataSource ds;
	
	//싱글톤
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {
		//Naming Service 작업을 진행...
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource lookup success");
		}catch(NamingException e) {
			System.out.println("DataSource lookup fail");
		}
	}
	public static BookDAOImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비 연결 성공");
		return ds.getConnection(); //Pool에서 하나씩 꺼내 옴
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null)ps.close();
		if(conn!=null)conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null)rs.close();
		closeAll(ps, conn);
		
	}

	@Override
	public void registerBook(Book vo) throws SQLException {
		//추가
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO book (isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps=conn.prepareStatement(query);
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getCatalogue());
			ps.setString(4, vo.getNation());
			ps.setString(5, vo.getPublish_date());
			ps.setString(6, vo.getPublisher());
			ps.setString(7, vo.getAuthor());
			ps.setInt(8, vo.getPrice());
			ps.setString(9, vo.getCurrency());
			ps.setString(10, vo.getDescription());
			ps.executeUpdate();
			System.out.println("registerBook 성공");

		} catch (SQLException e) {
			System.out.println("registerBook 실패");

			System.out.println(e);	
		}finally {
			closeAll(ps, conn);
			System.out.println("registerBook 호출");
		}
	}

	@Override
	public ArrayList<Book> showAllBook() throws SQLException {
		//추
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			conn = getConnection();
			String query = "SELECT isbn, title, catalogue, nation, publish_date, publisher, "
					+ "author, price, currency, description FROM book";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Book(
							rs.getString("isbn"),
							rs.getString("title"),
							rs.getString("catalogue"),
							rs.getString("nation"),
							rs.getString("publish_date"),
							rs.getString("publisher"),
							rs.getString("author"),
							rs.getInt("price"),
							rs.getString("currency"),
							rs.getString("description")
						));
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return list;
	}
	@Override
	public Book findBook(String isbn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		try {
			conn = getConnection();
			String query = "SELECT isbn, title, catalogue, nation, publish_date, publisher, "
					+ "author, price, currency, description FROM book WHERE isbn=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, isbn);
			rs = ps.executeQuery();
			if(rs.next()) {
				book = new Book(isbn,
								rs.getString("title"),
								rs.getString("catalogue"),
								rs.getString("nation"),
								rs.getString("publish_date"),
								rs.getString("publisher"),
								rs.getString("author"),
								rs.getInt("price"),
								rs.getString("currency"),
								rs.getString("description")
								);
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return book;
	}
	

}
