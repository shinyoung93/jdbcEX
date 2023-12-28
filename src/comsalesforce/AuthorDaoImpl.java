package comsalesforce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDaoImpl implements AuthorDao {

	@Override
	public int insert(AuthorVO vo) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");

			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문
			String sql = "INSERT INTO AUTHOR \r\n" + "VALUES (seq_author_id.nextval,?,?)";
			// 바인딩
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAuthor_name());
			pstmt.setString(2, vo.getAuthor_desc());

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.print(count + "건이 반영완료 ");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

		return count;
	}

	@Override
	public void getList() {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");

			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문
			String sql = "SELECT a.AUTHOR_ID , a.AUTHOR_NAME ,a.AUTHOR_DESC \r\n" + "FROM AUTHOR a";
			// 바인딩
			pstmt = conn.prepareStatement(sql);
			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				System.out.print(rs.getInt("author_id") + ", ");
				System.out.print(rs.getString(2) + ", ");
				System.out.print(rs.getString(3) + "\n");

			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

	}

	
	public int delete(int authorId) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");

			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문
			String sql = "DELETE FROM AUTHOR a \r\n" + "WHERE author_id = ?";
			// 바인딩
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, authorId);
			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.print(count + "건이 반영완료 ");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return count;
	}

	@Override
	public int update(AuthorVO vo) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");

			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문
			String sql = "UPDATE AUTHOR A\r\n" + "SET a.AUTHOR_DESC  = ?\r\n" + "WHERE a.AUTHOR_ID = ?";
			// 바인딩
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAuthor_desc());
			pstmt.setInt(2, vo.getAuthor_id());

			// 실행
			int count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.print(count + "건이 반영완료 ");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return 0;
	}

}
