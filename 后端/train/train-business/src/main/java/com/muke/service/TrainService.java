package com.muke.service;

import com.muke.domain.Train;
import com.muke.req.TrainSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.TrainQueryResp;
import com.muke.req.TrainQueryReq;

import java.util.List;

public interface  TrainService {

    void save(TrainSaveReq req);

    PageResp<TrainQueryResp> queryList(TrainQueryReq req);

    void delete(Long id);

    List<TrainQueryResp> queryAll();

    List<Train> selectAll();
}
