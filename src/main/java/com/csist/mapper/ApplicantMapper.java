package com.csist.mapper;

import com.csist.po.Applicant;

public interface ApplicantMapper {

	public Applicant login(String phone,String password);
	
	public boolean insert(Applicant a);
	
	public int resetpass(String resetpass,String phone);
	
}
