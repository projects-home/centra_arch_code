package com.ifudata.ic.pay.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ifudata.ic.pay.dao.mapper.bo.PayTerminalOrgRel;
import com.ifudata.ic.pay.dao.mapper.bo.PayTerminalOrgRelCriteria;

public interface PayTerminalOrgRelMapper {
    int countByExample(PayTerminalOrgRelCriteria example);

    int deleteByExample(PayTerminalOrgRelCriteria example);

    int deleteByPrimaryKey(Long relId);

    int insert(PayTerminalOrgRel record);

    int insertSelective(PayTerminalOrgRel record);

    List<PayTerminalOrgRel> selectByExample(PayTerminalOrgRelCriteria example);

    PayTerminalOrgRel selectByPrimaryKey(Long relId);

    int updateByExampleSelective(@Param("record") PayTerminalOrgRel record, @Param("example") PayTerminalOrgRelCriteria example);

    int updateByExample(@Param("record") PayTerminalOrgRel record, @Param("example") PayTerminalOrgRelCriteria example);

    int updateByPrimaryKeySelective(PayTerminalOrgRel record);

    int updateByPrimaryKey(PayTerminalOrgRel record);
}