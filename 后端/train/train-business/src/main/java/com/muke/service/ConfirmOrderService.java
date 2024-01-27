package com.muke.service;

import com.muke.dto.ConfirmOrderMQDto;
import com.muke.req.ConfirmOrderDoReq;
import com.muke.req.ConfirmOrderQueryReq;
import com.muke.resp.ConfirmOrderQueryResp;
import com.muke.resp.PageResp;

public interface  ConfirmOrderService {

    void save(ConfirmOrderDoReq req);

    PageResp<ConfirmOrderQueryResp> queryList(ConfirmOrderQueryReq req);

    void delete(Long id);

    void doConfirm(ConfirmOrderMQDto dto);

    Integer queryLineCount(Long id);
}
