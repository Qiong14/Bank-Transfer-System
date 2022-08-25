package com.qiong.mapper;

import com.qiong.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {
    @Select("select * from t_account where aid=#{outId} and apwd=#{outPwd}")
    Account accountOutInfoMapper(@Param("outId") String outId,@Param("outPwd") String outPwd);

    @Select("select * from t_account where aid=#{outId} and apwd=#{outPwd} and money>=#{money}")
    Account accountMoneyInfoMapper(@Param("outId") String outId,@Param("outPwd") String outPwd,@Param("money") Double money);

    @Select(" select a.* from t_account a\n" +
            " join t_user u\n" +
            " on a.uid=u.uid\n" +
            " where a.aid=#{inId} and u.uname=#{inName}")
    Account accountInfoMapper(@Param("inId") String inId,@Param("inName") String inName);

    @Update("update t_account set money=money-#{money} where aid=#{outId}")
    int transferOutMapper(@Param("outId") String outId,@Param("money") Double money);

    @Update("update t_account set money=money+#{money} where aid=#{inId}")
    int transferInMapper(@Param("inId") String inId,@Param("money") Double money);
}
