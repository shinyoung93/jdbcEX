package com.salesforce.rsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

	private Connection getConnect() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public int insert(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			conn = getConnect();
			String sql = "INSERT INTO BOOK b \r\n" + "VALUES (seq_book_id.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBookTitle());
			pstmt.setString(2, vo.getBookPubs());
			pstmt.setString(3, vo.getBookDate());
			pstmt.setInt(4, vo.getAuthorId());

			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
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

	public List<BookVo> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookVo> list = new ArrayList<BookVo>();

		try {
			conn = getConnect();
			String sql = "SELECT *\r\n" + "FROM BOOK b ";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookVo vo = new BookVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
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
		return list;
	}

	public int delete(int bookId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			conn = getConnect();
			String sql = "DELETE FROM BOOK b \r\n" + "WHERE b.book_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
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

	public int update(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			conn = getConnect();
			String sql = "UPDATE BOOK b\r\n" + "SET b.TITLE = ? \r\n" + "WHERE b.BOOK_ID = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBookTitle());
			pstmt.setInt(2, vo.getBookId());

			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
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

	public List<BookVo> search(String ch) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookVo> list = new ArrayList<BookVo>();

		try {
			conn = getConnect();
			String sql = "SELECT b.BOOK_ID , b.TITLE , b.PUBS , to_char(b.PUB_DATE, 'YYYY-MM-DD') ,a.AUTHOR_NAME \r\n"
					+ "FROM BOOK b , AUTHOR a \r\n" + "WHERE b.AUTHOR_ID  = a.AUTHOR_ID\r\n"
					+ "AND b.PUBS ||  b.TITLE || a.AUTHOR_NAME  LIKE ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + ch + '%');
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BookVo vo = new BookVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
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
		return list;

	}

}
