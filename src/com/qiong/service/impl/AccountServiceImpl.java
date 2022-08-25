package com.qiong.service.impl;

import com.qiong.mapper.AccountMapper;
import com.qiong.pojo.Account;
import com.qiong.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountMapper accountMapper;

    public AccountMapper getAccountMapper() {
        return accountMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public Account accountOutInfoService(String outId, String outPwd) {
        return accountMapper.accountOutInfoMapper(outId,outPwd);
    }

    @Override
    public Account accountMoneyInfoService(String outId, String pwd, Double money) {
        return accountMapper.accountMoneyInfoMapper(outId, pwd, money);
    }

    @Override
    public Account accountInInfoService(String inId, String inName) {
        return accountMapper.accountInfoMapper(inId,inName);
    }

    @Override
    public int transferService(String outId, String inId, Double money) {
        int i=accountMapper.transferOutMapper(outId,money);
        i+=accountMapper.transferInMapper(inId, money);
        return i;
    }
}
