package com.muke.controller;

import com.muke.context.LoginMemberContext;
import com.muke.req.TicketQueryReq;
import com.muke.resp.CommonResp;
import com.muke.resp.PageResp;
import com.muke.resp.TicketQueryResp;
import com.muke.service.TicketService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 我的余票
 *
 * @author tangcj
 * @date 2024/01/21 21:44
 **/
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Resource
    private TicketService ticketService;

    @GetMapping("/query-list")
    public CommonResp<PageResp<TicketQueryResp>> query(@Valid TicketQueryReq req) {
        CommonResp<PageResp<TicketQueryResp>> commonResp = new CommonResp<>();
        req.setMemberId(LoginMemberContext.getId());
        PageResp<TicketQueryResp> pageResp = ticketService.queryList(req);
        commonResp.setContent(pageResp);
        return commonResp;
    }

}
