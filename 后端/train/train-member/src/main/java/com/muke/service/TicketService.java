package com.muke.service;

import com.muke.req.TicketQueryReq;
import com.muke.resp.PageResp;
import com.muke.resp.TicketQueryResp;

public interface  TicketService {

    PageResp<TicketQueryResp> queryList(TicketQueryReq req);

}
