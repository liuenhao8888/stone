package com.stone.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

public class JdbcOpt {

	protected static final Logger log = Logger.getLogger(JdbcOpt.class);
	
	public static void main(String[] s) {
		createAreaTab();
	}

	private static String userName = "root";
	private static String password = "123456";
	private static String url = "jdbc:mysql://localhost:3306/58?useUnicode=true&amp;characterEncoding=utf8";

	static void createAreaTab() {
		Connection conn = null;
		Statement  stmt = null;
		String createSql = "CREATE TABLE `AREA` (" + "`ID` char(22) NOT NULL,"
				+ "`PRENAME` varchar(20) DEFAULT NULL,"
				+ "`CNAME` varchar(20) DEFAULT NULL,"
				+ "`AREACODE` varchar(30) DEFAULT NULL,"
				+ "`VERSION` int(11) DEFAULT NULL,"
				+ "`GRADE` tinyint(4) DEFAULT NULL,"
				+ "`ORDERNUM` int(11) DEFAULT NULL,"
				+ "`ISLEAF` tinyint(4) DEFAULT NULL,"
				+ "`PARENTID` char(22) DEFAULT NULL,"
				+ "`SHOP_ID` int(10) DEFAULT NULL," + "PRIMARY KEY (`ID`)"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8";
		;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName,
					password);
			stmt = conn.createStatement();
			stmt.executeUpdate(createSql);
			log.info("database created");
		} catch (Exception e) {
			log.info(e);
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				log.info(e);
			}
			
		}
	}

	static void insertArea(List<Area> areaList) {
		String sql = "INSERT INTO AREA(ID,PRENAME,CNAME,AREACODE,VERSION,GRADE,ORDERNUM,ISLEAF,PARENTID,SHOP_ID) VALUES(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName,
					password);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < areaList.size(); i++) {
				pstmt.setLong(1, areaList.get(i).getId());
				pstmt.setString(2, areaList.get(i).getPreName());
				pstmt.setString(3, areaList.get(i).getcName());
				pstmt.setString(4, areaList.get(i).getAreaCode());
				pstmt.setInt(5, areaList.get(i).getVersion());
				pstmt.setInt(6, areaList.get(i).getGrade());
				pstmt.setInt(7, areaList.get(i).getOrderNum());
				pstmt.setInt(8, areaList.get(i).getIsLeaf());
				pstmt.setLong(9, areaList.get(i).getParentId());
				pstmt.setInt(10, areaList.get(i).getShopId());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			conn.commit();
			log.info("data inserted");
		} catch (Exception e) {
			log.info(e);
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				log.info(e);
			}
			
		}
	}
	
	
	static String selectAreaCode(String preName,int grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String code = "";
		String sql = "select AREACODE from T_AREA where GRADE = "+grade+" and PRENAME like '%"+preName+"%'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName,
					password);
			pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();  
            while(rs.next()){  
                code = rs.getString("AREACODE");  
            }  
            if("".equals(code)){
            	log.info("*************  preName: "+preName+" grade: "+grade+"  NOT FOUND areaCode ************ ");
            }else{
            	log.info("preName: "+preName+" grade: "+grade+" areaCode: "+ code);
            }
		}catch (Exception e) {
			log.info(e);
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (final SQLException e) {
				log.info(e);
			}
		}
		return code;
	}


}
