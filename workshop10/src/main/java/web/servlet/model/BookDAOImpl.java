package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.xdevapi.Result;

public class BookDAOImpl implements BookDAO{
	private DataSource ds;
	private BookDAOImpl(){
		try {
		InitialContext ic = new InitialContext();
	 	ds= (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		}catch (NamingException e) {
			System.out.println(e);
		}
	}
	private static BookDAOImpl dao = new BookDAOImpl();
	public static BookDAOImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) {ps.close();}
		if(conn != null) {conn.close();}
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) { rs.close(); }
		closeAll(ps, conn);
	}

	@Override
	public void registerBook(Book vo) throws SQLException {
		String query="INSERT INTO book(isbn,title,catalogue,nation,publish_date,publisher,author,price,currency,description) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		try(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
				){
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
			
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public ArrayList<Book> showAllBook(String type,String keyward){
		String query="SELECT isbn,title,catalogue,nation,publish_date,publisher,author,price,description FROM book ";
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try(
			Connection conn = getConnection();
				){
			
			if(type.equals("도서명")) {
				query+= " WHERE title Like ?";
				String q = "%"+keyward+"%";
				ps=conn.prepareStatement(query);
				ps.setString(1,q );
				
			}else if(type.equals("출판사")) {
				query+= " WHERE publisher= ?";
				ps=conn.prepareStatement(query);
				ps.setString(1, keyward);
				
			}else {
				ps=conn.prepareStatement(query);
			}
			
			rs=ps.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(book);
			}
			ps.close();
			rs.close();
		}catch (SQLException e) {
			return null;
		}
		return list;
	}
	public Book findTitle(String title) {
		String query="SELECT title,publisher, author FROM book WHERE title = ? ";
		ResultSet rs = null;
		Book book= null;
		try(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
				){
			ps.setString(1, title);
			rs=ps.executeQuery();
			if(rs.next()) {
				book = new Book(null, title, null, null, null, rs.getString(2), rs.getString(3), 0, null);
			}
			
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return book;
	}

}
