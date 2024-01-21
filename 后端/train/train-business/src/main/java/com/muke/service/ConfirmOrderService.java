package com.muke.service;

import com.muke.req.ConfirmOrderSaveReq;
import com.muke.resp.PageResp;
import com.muke.resp.ConfirmOrderQueryResp;
import com.muke.req.ConfirmOrderQueryReq;

public interface  ConfirmOrderService {

    void save(ConfirmOrderSaveReq req);

    PageResp<ConfirmOrderQueryResp> queryList(ConfirmOrderQueryReq req);

    void delete(Long id);
}
