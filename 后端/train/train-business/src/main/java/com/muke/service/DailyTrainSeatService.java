package com.muke.service;

import com.muke.domain.DailyTrainSeat;
import com.muke.req.DailyTrainSeatSaveReq;
import com.muke.req.SeatSellReq;
import com.muke.resp.PageResp;
import com.muke.resp.DailyTrainSeatQueryResp;
import com.muke.req.DailyTrainSeatQueryReq;
import com.muke.resp.SeatSellResp;

import java.util.Date;
import java.util.List;

public interface  DailyTrainSeatService {

    void save(DailyTrainSeatSaveReq req);

    PageResp<DailyTrainSeatQueryResp> queryList(DailyTrainSeatQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String code);

    int countSeat(Date date, String trainCode, String seatType);

    List<DailyTrainSeat> selectByCarriage(Date date, String trainCode, Integer carriageIndex);

    List<SeatSellResp> querySeatSell(SeatSellReq req);
}
