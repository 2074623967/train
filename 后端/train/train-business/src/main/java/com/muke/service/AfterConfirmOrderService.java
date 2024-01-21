package com.muke.service;

import com.muke.domain.DailyTrainSeat;
import com.muke.domain.DailyTrainTicket;

import java.util.List;

public interface AfterConfirmOrderService {

    void afterDoConfirm(DailyTrainTicket dailyTrainTicket, List<DailyTrainSeat> finalSeatList);
}
