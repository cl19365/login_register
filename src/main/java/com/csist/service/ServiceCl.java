package com.csist.service;

import com.csist.po.Applicant;

public interface ServiceCl {

    public Applicant login(String phone, String password);

    public boolean insert(String name, String password, String phone);

    public  int resetpass(String resetpass,String phone);
}
