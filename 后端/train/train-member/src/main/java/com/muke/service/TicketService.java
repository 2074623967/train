package com.muke.service;

import com.muke.req.MemberTicketReq;
import com.muke.req.TicketQueryReq;
import com.muke.resp.PageResp;
import com.muke.resp.TicketQueryResp;

public interface  TicketService {

    void save(MemberTicketReq req);

    PageResp<TicketQueryResp> queryList(TicketQueryReq req);


}
