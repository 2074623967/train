package com.muke.controller;

import com.muke.req.PassengerQueryReq;
import com.muke.req.PassengerSaveReq;
import com.muke.resp.CommonResp;
import com.muke.resp.PageResp;
import com.muke.resp.PassengerQueryResp;
import com.muke.service.PassengerService;
import com.muke.context.LoginMemberContext;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 乘车人模块
 *
 * @author tangcj
 * @date 2024/01/13 11:01
 **/
@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Resource
    private PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req) {
        passengerService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<PassengerQueryResp>> queryList(@Valid PassengerQueryReq req) {
        req.setMemberId(LoginMemberContext.getId());
        PageResp<PassengerQueryResp> list = passengerService.queryList(req);
        return new CommonResp<>(list);
    }
}
