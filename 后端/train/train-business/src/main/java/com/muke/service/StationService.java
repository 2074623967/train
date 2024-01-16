package com.muke.service;

import com.muke.req.StationSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.StationQueryResp;
import com.muke.req.StationQueryReq;

public interface  StationService {

    void save(StationSaveReq req);

    PageResp<StationQueryResp> queryList(StationQueryReq req);

    void delete(Long id);
}
