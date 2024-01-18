package com.muke.service;

import com.muke.domain.TrainStation;
import com.muke.req.TrainStationSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.TrainStationQueryResp;
import com.muke.req.TrainStationQueryReq;

import java.util.List;

public interface  TrainStationService {

    void save(TrainStationSaveReq req);

    PageResp<TrainStationQueryResp> queryList(TrainStationQueryReq req);

    void delete(Long id);

    List<TrainStation> selectByTrainCode(String trainCode);
}
