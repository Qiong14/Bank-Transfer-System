package com.qiong.service;

import com.qiong.pojo.Account;

public interface AccountService {
    Account accountOutInfoService(String outId, String outPwd);

    Account accountMoneyInfoService(String outId, String pwd, Double money);

    Account accountInInfoService(String inId, String inName);

    int transferService(String outId,String inId,Double money);


}
