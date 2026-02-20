package com.luv2code.demo.dao;

import com.luv2code.demo.Account;

public interface AccountDao {
    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);
    void addAccount(Account theAccount,boolean vipFlag);
    boolean doWork();
}
