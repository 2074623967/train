package com.muke.service;

import com.muke.req.TrainCarriageSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.TrainCarriageQueryResp;
import com.muke.req.TrainCarriageQueryReq;

public interface  TrainCarriageService {

    void save(TrainCarriageSaveReq req);

    PageResp<TrainCarriageQueryResp> queryList(TrainCarriageQueryReq req);

    void delete(Long id);
}
