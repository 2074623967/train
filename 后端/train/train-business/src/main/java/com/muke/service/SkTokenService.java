package com.muke.service;

import com.muke.req.SkTokenSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.SkTokenQueryResp;
import com.muke.req.SkTokenQueryReq;

import java.util.Date;

public interface  SkTokenService {

    void save(SkTokenSaveReq req);

    PageResp<SkTokenQueryResp> queryList(SkTokenQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String trainCode);

    boolean validSkToken(Date date, String trainCode, Long memberId);
}
