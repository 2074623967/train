package com.muke.service;

import com.muke.req.DailyTrainCarriageSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.DailyTrainCarriageQueryResp;
import com.muke.req.DailyTrainCarriageQueryReq;

public interface  DailyTrainCarriageService {

    void save(DailyTrainCarriageSaveReq req);

    PageResp<DailyTrainCarriageQueryResp> queryList(DailyTrainCarriageQueryReq req);

    void delete(Long id);
}
