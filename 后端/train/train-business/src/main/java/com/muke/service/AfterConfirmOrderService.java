package com.muke.service;

import com.muke.domain.ConfirmOrder;
import com.muke.domain.DailyTrainSeat;
import com.muke.domain.DailyTrainTicket;
import com.muke.req.ConfirmOrderTicketReq;

import java.util.List;

public interface AfterConfirmOrderService {

    void afterDoConfirm(DailyTrainTicket dailyTrainTicket, List<DailyTrainSeat> finalSeatList,
                        List<ConfirmOrderTicketReq> tickets,ConfirmOrder confirmOrder);
}
