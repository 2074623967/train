package com.muke.service;

import com.muke.req.DailyTrainTicketSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.DailyTrainTicketQueryResp;
import com.muke.req.DailyTrainTicketQueryReq;

public interface  DailyTrainTicketService {

    void save(DailyTrainTicketSaveReq req);

    PageResp<DailyTrainTicketQueryResp> queryList(DailyTrainTicketQueryReq req);

    void delete(Long id);
}
