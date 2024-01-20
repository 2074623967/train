package com.muke.service;

import com.muke.req.DailyTrainSeatSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.DailyTrainSeatQueryResp;
import com.muke.req.DailyTrainSeatQueryReq;

import java.util.Date;

public interface  DailyTrainSeatService {

    void save(DailyTrainSeatSaveReq req);

    PageResp<DailyTrainSeatQueryResp> queryList(DailyTrainSeatQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String code);

    int countSeat(Date date, String trainCode, String seatType);
}
