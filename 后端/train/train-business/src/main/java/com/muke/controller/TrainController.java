package com.muke.controller;

import com.muke.req.TrainQueryReq;
import com.muke.resp.CommonResp;
import com.muke.resp.PageResp;
import com.muke.resp.TrainQueryResp;
import com.muke.service.TrainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Resource
    private TrainService trainService;

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainQueryResp>> queryList(@Valid TrainQueryReq req) {
        PageResp<TrainQueryResp> list = trainService.queryList(req);
        return new CommonResp<>(list);
    }
}
