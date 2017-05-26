package com.jx372.mysite.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.jx372.exception.UserDaoException;
import com.jx372.mysite.vo.UserVo;


@Repository
public class UserDao extends ConnectionDao{

	// ?��?��?��
	public UserVo get(Long no) {

		Connection conn = null;
		int count = 0;
		PreparedStatement pstmt = null;
		UserVo vo = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select no,name,email,gender from user where no =?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			System.out.println(pstmt.toString());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new UserVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setEmail(rs.getString(3));
				vo.setGender(rs.getString(4));
				System.out.println(vo.getNo());
				System.out.println(vo.getName());
				System.out.println(vo.getEmail());
				System.out.println(vo.getGender());
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	// 로그인 처리
	public UserVo get(String email, String password) throws UserDaoException{

		Connection conn = null;
		int count = 0;
		PreparedStatement pstmt = null;
		UserVo vo = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select no,name from user where email=? and psswd=password(?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			System.out.println(pstmt.toString());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new UserVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				System.out.println(vo.getNo());
				System.out.println(vo.getName());
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserDaoException("User Not Found");
		} finally {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;

	}

	public boolean insert(UserVo vo) {
		Connection conn = null;
		int count = 0;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into user values(null,?,?,password(?),?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());

			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return count == 1;
	}

	public boolean update(UserVo vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = getConnection();
			System.out.println(vo.getPassword());
			if ("null".equals(vo.getPassword())) {
				sql = "update  user set name =?, gender =? where no =?;";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getGender());	
				pstmt.setLong(3, vo.getNo());
				
			} else {
				sql = "update  user set name =?, gender =?,psswd=password(?) where no =?;";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getGender());
				pstmt.setString(3, vo.getPassword());
				pstmt.setLong(4, vo.getNo());
			}
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return count == 1;

	}
}
