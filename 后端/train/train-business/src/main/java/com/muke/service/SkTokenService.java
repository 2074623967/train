package com.muke.service;

import com.muke.req.SkTokenSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.SkTokenQueryResp;
import com.muke.req.SkTokenQueryReq;

public interface  SkTokenService {

    void save(SkTokenSaveReq req);

    PageResp<SkTokenQueryResp> queryList(SkTokenQueryReq req);

    void delete(Long id);
}
