package com.muke.controller.admin;

import com.muke.mapper.TrainCarriageMapper;
import com.muke.mapper.TrainMapper;
import com.muke.req.DailyTrainQueryReq;
import com.muke.req.DailyTrainSaveReq;
import com.muke.resp.CommonResp;
import com.muke.resp.DailyTrainQueryResp;
import com.muke.resp.PageResp;
import com.muke.service.DailyTrainService;
import com.muke.service.TrainSeatService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/daily-train")
public class DailyTrainAdminController {

    @Resource
    private DailyTrainService dailyTrainService;

    @Resource
    private TrainMapper trainMapper;

    @Resource
    private TrainSeatService trainSeatService;

    @Resource
    private TrainCarriageMapper trainCarriageMapper;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody DailyTrainSaveReq req) {
        dailyTrainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainQueryResp>> queryList(@Valid DailyTrainQueryReq req) {
        PageResp<DailyTrainQueryResp> list = dailyTrainService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        dailyTrainService.delete(id);
        return new CommonResp<>();
    }

    @GetMapping("/gen-daily/{date}")
    public CommonResp<Object> genDaily(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        dailyTrainService.genDaily(date);
        return new CommonResp<>();
    }
}
