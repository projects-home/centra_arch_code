package com.ifudata.ic.smc.api.policymanage.param;

import com.ifudata.dvp.base.vo.BaseResponse;
import com.ifudata.dvp.base.vo.PageInfo;

public class PolicyListQueryResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 政策列表信息
     */
    PageInfo<PolicyListQueryInfo> pageInfo;

    public PageInfo<PolicyListQueryInfo> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<PolicyListQueryInfo> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
