package com.muke.service;

import com.muke.req.DailyTrainStationSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.DailyTrainStationQueryResp;
import com.muke.req.DailyTrainStationQueryReq;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface  DailyTrainStationService {

    void save(DailyTrainStationSaveReq req);

    PageResp<DailyTrainStationQueryResp> queryList(DailyTrainStationQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String code);

    long countByTrainCode(@Param("date") Date date, @Param("trainCode") String trainCode);

    List<DailyTrainStationQueryResp> queryByTrain(Date date, String trainCode);
}
