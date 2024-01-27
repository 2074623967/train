package com.muke.service;

import com.muke.req.ConfirmOrderDoReq;

public interface BeforeConfirmOrderService {

    void beforeDoConfirm(ConfirmOrderDoReq req);
}
