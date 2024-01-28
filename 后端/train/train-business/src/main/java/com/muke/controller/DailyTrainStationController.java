package com.muke.controller;

import com.muke.req.DailyTrainStationQueryAllReq;
import com.muke.resp.CommonResp;
import com.muke.resp.DailyTrainStationQueryResp;
import com.muke.service.DailyTrainStationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 车站
 *
 * @author tangcj
 * @date 2024/01/28 10:39
 **/
@RestController
@RequestMapping("/daily-train-station")
public class DailyTrainStationController {

    @Autowired
    private DailyTrainStationService dailyTrainStationService;

    @GetMapping("/query-by-train-code")
    public CommonResp<List<DailyTrainStationQueryResp>> queryByTrain(@Valid DailyTrainStationQueryAllReq req) {
        List<DailyTrainStationQueryResp> list = dailyTrainStationService.queryByTrain(req.getDate(), req.getTrainCode());
        return new CommonResp<>(list);
    }

}
