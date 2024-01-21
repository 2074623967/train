package com.muke.service.impl;

import com.muke.domain.DailyTrainSeat;
import com.muke.mapper.ConfirmOrderMapper;
import com.muke.mapper.DailyTrainSeatMapper;
import com.muke.service.AfterConfirmOrderService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 选座之后的处理
 *
 * @author tangcj
 * @date 2024/01/21 20:02
 **/
@Service
public class AfterConfirmOrderServiceImpl implements AfterConfirmOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(ConfirmOrderServiceImpl.class);

    @Resource
    private DailyTrainSeatMapper dailyTrainSeatMapper;

    @Resource
    private ConfirmOrderMapper confirmOrderMapper;

    /**
     * 选中座位后事务处理:
     * 座位表修改售卖情况sell:
     * 余票详情表修改余票:
     * 为会员增加购票记录
     * 更新确定订单表为成功
     *
     * @param finalSeatList
     * @throws Exception
     */
    @Transactional
    @Override
    public void afterDoConfirm(List<DailyTrainSeat> finalSeatList) {
        for (DailyTrainSeat dailyTrainSeat:finalSeatList) {
            DailyTrainSeat seatForUpdate = new DailyTrainSeat();
            seatForUpdate.setId(dailyTrainSeat.getId());
            seatForUpdate.setSell(dailyTrainSeat.getSell());
            seatForUpdate.setUpdateTime(new Date());
            dailyTrainSeatMapper.updateByPrimaryKeySelective(seatForUpdate);
        }
    }
}
