package com.muke.service;

import com.muke.req.TrainStationSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.TrainStationQueryResp;
import com.muke.req.TrainStationQueryReq;

public interface  TrainStationService {

    void save(TrainStationSaveReq req);

    PageResp<TrainStationQueryResp> queryList(TrainStationQueryReq req);

    void delete(Long id);
}
