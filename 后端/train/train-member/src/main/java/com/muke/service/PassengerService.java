package com.muke.service;

import com.muke.req.PassengerQueryReq;
import com.muke.req.PassengerSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.PassengerQueryResp;

public interface PassengerService {

    void save(PassengerSaveReq req);

    PageResp<PassengerQueryResp> queryList(com.muke.req.PassengerQueryReq req);
}
