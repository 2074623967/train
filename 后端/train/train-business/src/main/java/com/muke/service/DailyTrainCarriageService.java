package com.muke.service;

import com.muke.domain.DailyTrainCarriage;
import com.muke.req.DailyTrainCarriageSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.DailyTrainCarriageQueryResp;
import com.muke.req.DailyTrainCarriageQueryReq;

import java.util.Date;
import java.util.List;

public interface  DailyTrainCarriageService {

    void save(DailyTrainCarriageSaveReq req);

    PageResp<DailyTrainCarriageQueryResp> queryList(DailyTrainCarriageQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String code);

    List<DailyTrainCarriage> selectBySeatType (Date date, String trainCode, String seatType);
}
