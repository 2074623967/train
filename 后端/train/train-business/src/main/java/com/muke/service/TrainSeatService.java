package com.muke.service;

import com.muke.req.TrainSeatSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.TrainSeatQueryResp;
import com.muke.req.TrainSeatQueryReq;

public interface  TrainSeatService {

    void save(TrainSeatSaveReq req);

    PageResp<TrainSeatQueryResp> queryList(TrainSeatQueryReq req);

    void delete(Long id);
}
