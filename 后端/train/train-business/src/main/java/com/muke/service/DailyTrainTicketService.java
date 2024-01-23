package com.muke.service;

import com.muke.domain.DailyTrain;
import com.muke.domain.DailyTrainTicket;
import com.muke.req.DailyTrainTicketSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.DailyTrainTicketQueryResp;
import com.muke.req.DailyTrainTicketQueryReq;

import java.util.Date;

public interface  DailyTrainTicketService {

    void save(DailyTrainTicketSaveReq req);

    PageResp<DailyTrainTicketQueryResp> queryList2(DailyTrainTicketQueryReq req);
    PageResp<DailyTrainTicketQueryResp> queryList(DailyTrainTicketQueryReq req);

    void delete(Long id);

    void genDaily(DailyTrain dailyTrain, Date date, String trainCode);

    DailyTrainTicket selectByUnique(Date date, String trainCode, String start, String end);
}
