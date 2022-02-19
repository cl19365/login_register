package com.csist.mapper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.csist.po.Applicant;
import com.csist.mapper.ApplicantMapper;
import com.csist.util.JDBCUtil;

public class ApplicantMapperImpl implements ApplicantMapper {
	private static Connection con;
	static {
		con = JDBCUtil.getConnection();
	}

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public Applicant login(String phone, String password) {
		String sql="select * from applicant where phone=? and password=? and status=1";
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1,phone);
		ps.setString(2,password);
		rs = ps.executeQuery();
		if (rs.next()) {
			Applicant applicant  = new Applicant();
			
				applicant.setId(rs.getInt(1));
				applicant.setName(rs.getString(2));
				applicant.setPassword(rs.getString(3));
				applicant.setPhone(rs.getString(4));
				return applicant;
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
	}
	@Override
	public boolean insert(Applicant a) {
		String sql = "insert into applicant(username,password,phone,status,create_time) values (?,?,?,?,?)";
		
		boolean bl = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, a.getName());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getPhone());
			ps.setInt(4, 1);
			ps.setString(5, formatter.format(LocalDateTime.now()));
			int num = ps.executeUpdate();
			if (num > 0) {
				bl = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bl;
		
	}
	@Override
	public int resetpass(String resetpass,String phone) {
		String sql="update applicant set password=? where phone=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, resetpass);
			ps.setString(2, phone);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	

}
