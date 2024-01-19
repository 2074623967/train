package com.muke.controller.admin;

import cn.hutool.core.date.DateTime;
import com.muke.domain.Train;
import com.muke.domain.TrainCarriage;
import com.muke.domain.TrainExample;
import com.muke.enums.SeatColEnum;
import com.muke.mapper.TrainCarriageMapper;
import com.muke.mapper.TrainMapper;
import com.muke.req.DailyTrainQueryReq;
import com.muke.req.DailyTrainSaveReq;
import com.muke.resp.CommonResp;
import com.muke.resp.DailyTrainQueryResp;
import com.muke.resp.PageResp;
import com.muke.service.DailyTrainService;
import com.muke.service.TrainSeatService;
import com.muke.util.SnowUtil;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
        // 生成车厢数据
        // 1-10节是一等座，11-18节是二等座
        TrainExample trainSeatExample = new TrainExample();
        List<Train> trainList = trainMapper.selectByExample(trainSeatExample);
        DateTime now = DateTime.now();
        trainList.forEach(train -> {
            for (int i = 0; i < 18; i++) {
                TrainCarriage trainCarriage = new TrainCarriage();
                trainCarriage.setId(SnowUtil.getSnowflakeNextId());
                trainCarriage.setTrainCode(train.getCode());
                trainCarriage.setIndex(i + 1);
                trainCarriage.setColCount(20);
                trainCarriage.setRowCount(5);
                trainCarriage.setCreateTime(now);
                trainCarriage.setUpdateTime(now);
                if (i < 10) {
                    trainCarriage.setSeatType("1");
                } else {
                    trainCarriage.setSeatType("2");
                }
                List<SeatColEnum> seatColEnums = SeatColEnum.getColsByType(trainCarriage.getSeatType());
                trainCarriage.setColCount(seatColEnums.size());
                trainCarriage.setSeatCount(trainCarriage.getColCount() * trainCarriage.getRowCount());
                trainCarriageMapper.insert(trainCarriage);
            }
            // 生成座位数据
            trainSeatService.genTrainSeat(train.getCode());
        });
        dailyTrainService.genDaily(date);
        return new CommonResp<>();
    }
}
