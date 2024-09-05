package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/*
 * Connection 반환하는 방식이
 * DreverManager 방식이 아닌 DataSource 방식으로 진행...
 * Naming(JNDI) Service 가 사용됨
 * ::
 * 1. DataSource를 먼저 받아온 다음에
 * 2. 1.번 안에 있는 미리 만들어져있는 Connection을 하나 Rent해 와서 사용할 것임
 */
public class MemberDAOImpl implements MemberDAO{
	//추가...
	private DataSource ds;
	
	//싱글톤
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		//Naming Service 작업을 진행...
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource lookup success");
		}catch(NamingException e) {
			System.out.println("DataSource lookup fail");
		}
	}
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	
	//공통적인 로직	
	@Override
	public Connection getConnect() throws SQLException {
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
	public void registerMenber(Member vo) throws SQLException {
		//추가
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "INSERT INTO member (id, password, name, address) VALUES(?, ?, ?, ?)";
			ps=conn.prepareStatement(query);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			ps.executeUpdate();
		}finally {
			closeAll(ps, conn);
		}
		
	}//member
	
	@Override
	public ArrayList<Member> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			conn = getConnect();
			String query = "SELECT id, password, name, address FROM member";
			ps=conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Member(rs.getString("id"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("address"))); 	
			}
			System.out.println(list);
			
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public Member findByIdMemer(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member vo = null;
		try {
			conn = getConnect();
			String query = "SELECT id, password, name, address FROM member WHERE id=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new Member(id,
								rs.getString("password"),
								rs.getString("name"),
								rs.getString("address"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	/*
	public static void main(String[] args) throws Exception{
		Member rvo = MemberDAOImpl.getInstance().findByIdMemer("kosta");
		System.out.println(rvo);
		//단위테스트 안 됨... 서버에서 가동되지 않았기 때문에 서버의 데이터소스를 받아오지 못함
	}//main
	*/
	@Override
	public Member login(String id, String pass) throws SQLException {
		//추가
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member vo = null;
		try {
			conn = getConnect();
			String query = "SELECT id, password, name, address FROM member WHERE id=? AND password=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new Member(id,
								pass,
								rs.getString("name"),
								rs.getString("address"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	@Override
	public boolean idCheck(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isExistedId = false;
		try {
			conn = getConnect();
			String query = "SELECT id FROM member WHERE id=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				isExistedId = true;
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		System.out.println(isExistedId);
		return isExistedId;
	}
	
}//class
