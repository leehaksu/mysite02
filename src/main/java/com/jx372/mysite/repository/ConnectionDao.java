package com.jx372.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class ConnectionDao {
	
	protected Connection getConnection() throws SQLException {
			Connection conn = null;
			try {
				// 1. 드라이버 로딩
				Class.forName("com.mysql.jdbc.Driver");
	
				// 2.Connection 하기
				String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
				conn = DriverManager.getConnection(url, "webdb", "webdb");
				System.out.println("연결 성공!!!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
	
				System.out.println("JDBC Driver를 찾을 수 없습니다.");
			}
			return conn;
	}
	
}

