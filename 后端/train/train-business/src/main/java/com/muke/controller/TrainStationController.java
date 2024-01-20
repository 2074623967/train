package com.muke.controller;

import com.muke.req.TrainStationQueryReq;
import com.muke.resp.CommonResp;
import com.muke.resp.PageResp;
import com.muke.resp.TrainStationQueryResp;
import com.muke.service.TrainStationService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train-station")
public class TrainStationController {

    @Resource
    private TrainStationService trainStationService;

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainStationQueryResp>> queryList(@Valid TrainStationQueryReq req) {
        PageResp<TrainStationQueryResp> list = trainStationService.queryList(req);
        return new CommonResp<>(list);
    }

}
