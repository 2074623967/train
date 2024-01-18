package com.muke.service;

import com.muke.req.DailyTrainSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.DailyTrainQueryResp;
import com.muke.req.DailyTrainQueryReq;

public interface  DailyTrainService {

    void save(DailyTrainSaveReq req);

    PageResp<DailyTrainQueryResp> queryList(DailyTrainQueryReq req);

    void delete(Long id);
}
