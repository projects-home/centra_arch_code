package com.ifudata.dvp.pay.test.api.terminalorgrelquery.impl;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ifudata.dvp.pay.api.terminalorgrelquery.interfaces.ITerminalOrgRelQuerySV;
import com.ifudata.dvp.pay.api.terminalorgrelquery.param.TerminalOrgRelQryParam;
import com.ifudata.dvp.pay.api.terminalorgrelquery.param.TerminalOrgRelVo;
import com.ifudata.dvp.pay.cache.PayTerminalOrgRelCache;
import com.ifudata.dvp.sdk.appserver.CacheServiceStart;

/**
 * 终端与支付机构关系查询服务测试类
 * Date: 2015年8月20日 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class TerminalOrgRelQuerySVImplTest {

    private static final Log LOG = LogFactory.getLog(TerminalOrgRelQuerySVImplTest.class);
    
    @Autowired
    private ITerminalOrgRelQuerySV terminalOrgRelQuerySV;
    
    @Autowired
    private PayTerminalOrgRelCache terminalOrgRelCache;
    
    @Test
    public void testWrite() throws Exception {
        CacheServiceStart.main(new String[] {});
    }
    
    @Test
    public void testWriteTerminalOrgRel() {
        try {
            terminalOrgRelCache.write();
        } catch (Exception e) {
            LOG.error("缓存写入错误", e);
        }
    }
    
    @Test
    public void testQueryTerminalOrgRels() {
        TerminalOrgRelQryParam qryParam = new TerminalOrgRelQryParam();
        qryParam.setTenantId("BIS-ST");
        qryParam.setRequestSource("1");
        LOG.info(JSON.toJSONString(qryParam));
        List<TerminalOrgRelVo> relVoList = this.terminalOrgRelQuerySV.queryTerminalOrgRels(qryParam);
        assertTrue(relVoList.size() > 0);
        LOG.info(JSONArray.toJSONString(relVoList));        
    }

}
