package com.ifudata.dvp.pay.service.atom.interfaces;

import java.util.List;

import com.ifudata.dvp.pay.dao.mapper.bo.PayCenterLog;

/**
 * 支付中心流水基础服务接口定义
 * Date: 2015年8月18日 <br>
 */
public interface IPayCenterLogSV {

    void savePayCenterLog(PayCenterLog log); 
    
    void modifyPayCenterLog(PayCenterLog log); 
    
    PayCenterLog getPayCenterLogByMerchantOrderId(String tenantId, String merchantOrderId);
    
    PayCenterLog getPayCenterLogByTradeOrderId(String tenantId, String tradeOrderId);
    
    List<PayCenterLog> getPayCenterLogsByBatchNo(String tenantId, String batchNo,
            String payOrgSerial);
    
    PayCenterLog getPayCenterLogByPayId(long payId);
}
