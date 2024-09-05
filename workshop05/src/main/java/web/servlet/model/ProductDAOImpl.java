package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.cj.Query;

public class ProductDAOImpl implements ProductDAO{
	private DataSource ds;
	//데이터소스 변수 추가
	
	private static ProductDAOImpl dao = new ProductDAOImpl();
	//dao 객체
	private ProductDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			//InitialContext 객체를 통해 jndi 특성을 불러옴
			//Context.xml 파일의 name 부분 앞에 "java:comp/env/"를 반드시 작성해야 함
			System.out.println("DataSource lookup success");
		} catch (Exception e) {
			System.out.println("DataSource lookup fail");
		}
		//Naming Service 작업
	}
	public static ProductDAOImpl getInstance() {
		return dao;
	}
	//싱글톤
	
	@Override
	public Connection getConnect() throws SQLException {
		System.out.println("디비 연결 성공");
		return ds.getConnection();
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
	public void register(Product vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "INSERT INTO product (prod_name, prod_price, prod_desc) VALUES( ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getProdName());
			ps.setInt(2, vo.getProdPrice());
			ps.setString(3, vo.getProdDesc());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public ArrayList<Product> findProducts() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			conn = getConnect();
			String query = "SELECT prod_no, prod_name, prod_price, prod_desc FROM product";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(
							rs.getInt("prod_no"),
							rs.getString("prod_name"),
							rs.getInt("prod_price"),
							rs.getString("prod_desc")
						));
			}
			System.out.println(list);
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return list;
	}

}
