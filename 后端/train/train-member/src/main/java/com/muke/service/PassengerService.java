package com.muke.service;

import com.muke.req.PassengerSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.PassengerQueryResp;
import com.muke.req.PassengerQueryReq;

public interface  PassengerService {

    void save(PassengerSaveReq req);

    PageResp<PassengerQueryResp> queryList(PassengerQueryReq req);

    void delete(Long id);
}
