package com.muke.service;

import com.muke.req.DailyTrainStationSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.DailyTrainStationQueryResp;
import com.muke.req.DailyTrainStationQueryReq;

public interface  DailyTrainStationService {

    void save(DailyTrainStationSaveReq req);

    PageResp<DailyTrainStationQueryResp> queryList(DailyTrainStationQueryReq req);

    void delete(Long id);
}
