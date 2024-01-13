package com.muke.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.muke.domain.Passenger;
import com.muke.mapper.PassengerMapper;
import com.muke.req.PassengerSaveReq;
import com.muke.service.PassengerService;
import com.muke.util.SnowUtil;
import context.LoginMemberContext;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 乘车人业务层
 *
 * @author tangcj
 * @date 2024/01/13 10:47
 **/
@Service
public class PassengerServiceImpl implements PassengerService {

    private static final Logger LOG = LoggerFactory.getLogger(PassengerServiceImpl.class);

    @Resource
    private PassengerMapper passengerMapper;

    public void save(PassengerSaveReq req) {
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        if (ObjectUtil.isNull(passenger.getId())) {
            passenger.setMemberId(LoginMemberContext.getId());
            passenger.setId(SnowUtil.getSnowflakeNextId());
            passenger.setCreateTime(now);
            passenger.setUpdateTime(now);
            passengerMapper.insert(passenger);
        } else {
            passenger.setUpdateTime(now);
            passengerMapper.updateByPrimaryKey(passenger);
        }
    }
}
