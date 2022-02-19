package com.csist.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类
 * 
 * 提供一些公共方法，以便减少每次JDBC编码的重复度 1、注册驱动 2、获取连接对象 3、释放资源
 * 
 * @author csist-jf-student
 *
 */
public class JDBCUtil {
	private static Properties prop=new Properties();
	private JDBCUtil() {
	}
	
	//静态代码块（在类加载时就执行，且只执行一次）
	static {
		try {
			
			prop.load(new FileReader(JDBCUtil.class.getResource("/").getPath() + "prop.Properties"));
			Class.forName(prop.getProperty("driver"));
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 获取数据库连接对象
	 * 
	 * @return 数据库连接对象（null表示连接失败）
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("linked"), prop.getProperty("user"), prop.getProperty("password"));
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	/**
	 * 释放JDBC对象
	 * @param conn  数据库连接对象
	 * @param ps    数据库操作对象（预编译SQL语句）
	 */
	public static void close(Connection conn,PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 释放JDBC对象
	 * @param conn  数据库连接对象
	 * @param ps    数据库操作对象（预编译SQL语句）
	 * @param rs    数据库查询结果集
	 */
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn,ps);
	}
}
