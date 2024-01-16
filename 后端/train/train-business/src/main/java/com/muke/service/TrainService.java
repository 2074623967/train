package com.muke.service;

import com.muke.req.TrainSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.TrainQueryResp;
import com.muke.req.TrainQueryReq;

public interface  TrainService {

    void save(TrainSaveReq req);

    PageResp<TrainQueryResp> queryList(TrainQueryReq req);

    void delete(Long id);
}
