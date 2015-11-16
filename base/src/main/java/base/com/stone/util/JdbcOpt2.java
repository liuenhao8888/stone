package com.stone.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JdbcOpt2 {

	public static void main(String[] s) {
		createCityTab();
	}

	private static String userName = "root";
	private static String password = "123456";
	private static String url = "jdbc:mysql://localhost:3306/shequ?useUnicode=true&amp;characterEncoding=utf8";
	
	static void createCityTab() {
		String createSql = "CREATE TABLE `city` ("
				+"`id` int(11) NOT NULL,"
				+"`name` varchar(30) NOT NULL,"
				+"`code` varchar(30) NOT NULL,"
				+"PRIMARY KEY (`id`)"
				+") ENGINE=InnoDB DEFAULT CHARSET=utf8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName,
					password);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(createSql);
			stmt.close();
			con.close();
			System.out.println("database created");
		} catch (SQLException e) {
			System.err.println("SQLException: " + e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	static void insertCity(List<City> cityList) {
		String sql = "INSERT INTO city(id,name,code) VALUES(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, userName,
					password);
			conn.setAutoCommit(false);   
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			for(int i=0;i<cityList.size();i++){
				pstmt.setInt(1, cityList.get(i).getId());
				pstmt.setString(2,cityList.get(i).getName());
				pstmt.setString(3,cityList.get(i).getCode());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			conn.commit();
			pstmt.close();
			conn.close();
			System.out.println("data inserted1");
		} catch (SQLException e) {
			System.err.println("SQLException: " + e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void createCityTab2() {
		String createSql = "CREATE TABLE `city2` ("
				+"`id` int(11) NOT NULL,"
				+"`name` varchar(30) NOT NULL,"
				+"`code` varchar(30) NOT NULL,"
				+"`pid` int(11) NOT NULL,"
				+"PRIMARY KEY (`id`)"
				+") ENGINE=InnoDB DEFAULT CHARSET=utf8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName,
					password);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(createSql);
			stmt.close();
			con.close();
			System.out.println("database created");
		} catch (SQLException e) {
			System.err.println("SQLException: " + e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	static void insertCity2(List<City> cityList) {
		String sql = "INSERT INTO city2(id,name,code,pid) VALUES(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, userName,
					password);
			conn.setAutoCommit(false);   
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			for(int i=0;i<cityList.size();i++){
				pstmt.setInt(1, cityList.get(i).getId());
				pstmt.setString(2,cityList.get(i).getName());
				pstmt.setString(3,cityList.get(i).getCode());
				pstmt.setInt(4, cityList.get(i).getPid());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			conn.commit();
			pstmt.close();
			conn.close();
			System.out.println("data inserted2");
		} catch (SQLException e) {
			System.err.println("SQLException: " + e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	static void createCityTab3() {
		String createSql = "CREATE TABLE `city3` ("
				+"`id` int(11) NOT NULL,"
				+"`name` varchar(30) NOT NULL,"
				+"`code` varchar(30) NOT NULL,"
				+"`pid` int(11) NOT NULL,"
				+"PRIMARY KEY (`id`)"
				+") ENGINE=InnoDB DEFAULT CHARSET=utf8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName,
					password);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(createSql);
			stmt.close();
			con.close();
			System.out.println("database created");
		} catch (SQLException e) {
			System.err.println("SQLException: " + e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	static void insertCity3(List<City> cityList) {
		String sql = "INSERT INTO city3(id,name,code,pid) VALUES(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, userName,
					password);
			conn.setAutoCommit(false);   
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			for(int i=0;i<cityList.size();i++){
				pstmt.setInt(1, cityList.get(i).getId());
				pstmt.setString(2,cityList.get(i).getName());
				pstmt.setString(3,cityList.get(i).getCode());
				pstmt.setInt(4, cityList.get(i).getPid());
				pstmt.addBatch();
			}
			System.out.println(pstmt.getParameterMetaData());
			pstmt.executeBatch();
			conn.commit();
			pstmt.close();
			conn.close();
			System.out.println("data inserted3");
		} catch (SQLException e) {
			System.err.println("SQLException: " + e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
