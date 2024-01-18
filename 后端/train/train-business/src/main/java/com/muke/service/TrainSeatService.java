package com.muke.service;

import com.muke.domain.TrainSeat;
import com.muke.req.TrainSeatSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.TrainSeatQueryResp;
import com.muke.req.TrainSeatQueryReq;

import java.util.List;

public interface  TrainSeatService {

    void save(TrainSeatSaveReq req);

    PageResp<TrainSeatQueryResp> queryList(TrainSeatQueryReq req);

    void delete(Long id);

    void genTrainSeat(String trainCode);

    List<TrainSeat> selectByTrainCode(String trainCode);
}
