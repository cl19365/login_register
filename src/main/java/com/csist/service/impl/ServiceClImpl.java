package com.csist.service.impl;

import com.csist.mapper.ApplicantMapper;
import com.csist.mapper.impl.ApplicantMapperImpl;
import com.csist.po.Applicant;
import com.csist.service.ServiceCl;

public class ServiceClImpl implements ServiceCl {
    ApplicantMapper applicantmapper = new ApplicantMapperImpl();
    Applicant applicant;
    @Override
    public Applicant login(String phone, String password) {

        return  applicantmapper.login(phone, password);
    }

    @Override
    public boolean insert(String name, String password, String phone){
        applicant = new Applicant(name, password, phone);
        return applicantmapper.insert(applicant);
    }

    @Override
    public  int resetpass(String resetpass,String phone){
        return applicantmapper.resetpass(resetpass, phone);
    }
}
