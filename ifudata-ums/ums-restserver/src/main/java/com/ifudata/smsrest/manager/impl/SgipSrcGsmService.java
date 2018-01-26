package com.ifudata.smsrest.manager.impl;


import com.ifudata.smsrest.db.mapper.bo.SgipSrcGsmCriteria;

import com.ifudata.smsrest.manager.ISgipSrcGsm;
import com.ifudata.smsrest.db.interfaces.SgipSrcGsmMapper;
import com.ifudata.smsrest.db.mapper.bo.SgipSrcGsm;
import com.ifudata.smsrest.util.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

/**
 * 短信接口服务
 */
public class SgipSrcGsmService implements ISgipSrcGsm {
	private static Log log = LogFactory.getLog(SgipSrcGsmService.class);
	@Autowired
	private SgipSrcGsmMapper sgipSrcGsmMapper;
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 按照serviceTypeList返回指定行数的短信接口内容
	 *
	 * @param serviceTypeList
	 *            运营商标识
	 * @param nBatch
	 *            批次大小
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, timeout = 20)
	public List<SgipSrcGsm> getSgipSrc(List<String> serviceTypeList, int nBatch) {
		SgipSrcGsmCriteria criteria = new SgipSrcGsmCriteria();
		criteria.createCriteria().andFlagEqualTo(0).andServicetypeIn(serviceTypeList);
		criteria.setLimitStart(0);
		criteria.setLimitEnd(nBatch);
		criteria.setOrderByClause(" Priority asc");

		List<SgipSrcGsm> records = sgipSrcGsmMapper.selectByExample(criteria);
		return records;
	}

	/**
	 * 按照短信接口唯一标识返回指定记录
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, timeout = 20)
	public SgipSrcGsm getSgipSrc(BigDecimal id) {
		SgipSrcGsmCriteria criteria = new SgipSrcGsmCriteria();
		criteria.createCriteria().andVerifyidEqualTo(id);
		criteria.setOrderByClause("priority asc");
		List<SgipSrcGsm> records = sgipSrcGsmMapper.selectByExample(criteria);
		if ((records == null) || (records.isEmpty())) {
			return null;
		}

		return records.get(0);
	}

	@Override
	public Integer updateSgipSrc(SgipSrcGsm rec) throws Exception {
		throw new Exception();
	}

	/**
	 * 删除短信接口表内容
	 * 
	 * @param rec
	 * @return
	 * @throws DeleteException
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer deleteSgipSrc(SgipSrcGsm rec) throws Exception {
		SgipSrcGsmCriteria criteria = new SgipSrcGsmCriteria();
		criteria.clear();
		criteria.createCriteria().andVerifyidEqualTo(rec.getVerifyid());
		// criteria.createCriteria().andCreateTimeIsNotNull();
		int nRet = sgipSrcGsmMapper.deleteByExample(criteria);
		if (nRet <= 0) {
			//todo zhanghy6 使用其它方式删除
			criteria.clear();
			criteria.createCriteria().andGsmcontentEqualTo(rec.getGsmcontent())
									 .andServicetypeEqualTo(rec.getServicetype())
									 .andPhoneEqualTo(rec.getPhone())
									 .andSrcNameEqualTo(rec.getSrcName())
									 .andTemplateIdEqualTo(rec.getTemplateId());
			nRet = sgipSrcGsmMapper.deleteByExample(criteria);
			if (nRet <= 0) {
				//throw new DeleteException("删除失败Verifyid[" + rec.getVerifyid() + "]");
				log.error("删除失败Verifyid[" + rec.getVerifyid() + "]");
			}
		}
		return nRet;
	}

	/**
	 * 将短信接口内容备份到历史表
	 * 
	 * @param recs
	 * @return
	 * @throws InsertException
	 * @throws DeleteException
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer moveSgipSrc(List<SgipSrcGsm> recs) throws Exception {
		Iterator<SgipSrcGsm> iterator = recs.iterator();
		while (iterator.hasNext()) {
			moveSgipSrc(iterator.next());
		}
		return 1;
	}

	/**
	 * 将短信接口内容备份到历史表
	 * 
	 * @param recs
	 * @return
	 * @throws InsertException
	 * @throws DeleteException
	 */
	@Transactional(rollbackFor = Exception.class)
	public Integer moveSgipSrc(SgipSrcGsm recs) throws Exception {
		String currmonth = DateUtils.getCurrMonth();

		// 插入到历史表
		int nRet = sgipSrcGsmMapper.insertToBackup(currmonth, recs);
		if (nRet <= 0) {
			//throw new InsertException("备份不成功");
			log.error("备份不成功");
		}
		nRet = deleteSgipSrc(recs);
		return nRet;
	}

	@Override
	public SqlSessionTemplate getSqlSessionTemplate() {
		return this.sqlSessionTemplate;
	}

	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate session) {
		this.sqlSessionTemplate = session;
	}
	
	public Integer insertSgipSrc(List<SgipSrcGsm> sctlist) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		for (SgipSrcGsm sct : sctlist) {
			log.debug("******** 进入保存SMSCommTask方法  将要保存的SmsCommTask信息 " + sct.toString() + " ********");
			if (sgipSrcGsmMapper.insert(sct) <= 0) {
				throw new Exception("插入结果表不成功   " + sct.toString());
			} else {
				count++;
			}
		}
		if (count < sctlist.size()) {
			throw new Exception("插入结果表数目不对   " + sctlist.toString());
		}
		return count;
	}	
}
