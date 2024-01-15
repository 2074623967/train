package com.muke.service;

import com.muke.req.${Domain}SaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.${Domain}QueryResp;
import com.muke.req.${Domain}QueryReq;

public interface  ${Domain}Service {

    void save(${Domain}SaveReq req);

    PageResp<${Domain}QueryResp> queryList(${Domain}QueryReq req);

    void delete(Long id);
}
