package com.muke.service;

import com.muke.domain.TrainCarriage;
import com.muke.req.TrainCarriageSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.TrainCarriageQueryResp;
import com.muke.req.TrainCarriageQueryReq;

import java.util.List;

public interface  TrainCarriageService {

    void save(TrainCarriageSaveReq req);

    PageResp<TrainCarriageQueryResp> queryList(TrainCarriageQueryReq req);

    void delete(Long id);

    List<TrainCarriage> selectByTrainCode(String trainCode);
}
