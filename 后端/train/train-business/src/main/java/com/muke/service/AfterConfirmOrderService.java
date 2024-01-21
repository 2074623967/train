package com.muke.service;

import com.muke.domain.DailyTrainSeat;

import java.util.List;

public interface AfterConfirmOrderService {

    void afterDoConfirm(List<DailyTrainSeat> finalSeatList);
}
