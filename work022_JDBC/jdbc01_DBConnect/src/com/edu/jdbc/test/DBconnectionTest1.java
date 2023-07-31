package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * DB Connection
 * 1. 서버의 정보를 가지고 있는 Driver를 메모리에 로딩
 * 2. 
 */

public class DBconnectionTest1 {
	
	public DBconnectionTest1() {
		
		try {
			// jdbc 4단계 작업...
			//1. Driver Loading
			//FQCN (Full Qualified Class Name)으로 경로를 넣어야함 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success");
			
			// 2. DB Connection
			// "ip(url)", "id", "password"
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user = "mykb";
			String password = "1234";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB Connection Success");
			
			// 3. PrepareStatement 객체 생성
			// custom 테이블에 하나의 행을 추가하는 쿼리문
			// Insert 쿼리문을 짤때 채울 인자를 선언해주면서 채우자!
			String query = "INSERT INTO custom (id, name) VALUES(?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("Creating PreparedStatement");
			
			// ?의 값을 Binding (?에 값을 집어넣는다.)
			
			// (넣을 위치, 넣을 값)
			ps.setInt(1, 1);
			ps.setString(2,"HaBaRee");
//			ps.setString(3, "LA");
			
			// 4. 쿼리문 실행, Data Binding
			// 얘 근데 int가 반환됨
			// manipulate 된 행의 개수
			// 프로그램을 통해 진행을 하면 auto commit이 됨 
			int result = ps.executeUpdate();
			System.out.println(result);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading Fail");
		} catch (SQLException e) {
			System.out.println("DB Connection Fail");
		}	
		
	}
	
	public static void main(String[] args) {
		new DBconnectionTest1();
		
	}

}
