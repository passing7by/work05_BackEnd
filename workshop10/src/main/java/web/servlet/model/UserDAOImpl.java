package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO {

	private DataSource ds;
	private UserDAOImpl(){
		try {
		InitialContext ic = new InitialContext();
	 	ds= (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		}catch (NamingException e) {
			System.out.println(e);
		}
	}
	private static UserDAOImpl dao = new UserDAOImpl();
	public static UserDAOImpl getInstance() {
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
	public User login(String userId, String password) throws SQLException {
			String querry = "SELECT userId,password,name,email FROM userinfo WHERE userId=? AND password=?";
			ResultSet rs = null;
			User user=null;
			try(
				Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(querry);
					){
				ps.setString(1, userId);
				ps.setString(2, password);
				
				rs=ps.executeQuery();
				
				if(rs.next()) {
					user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				}
			}
			
			
		return user;
	}

}
