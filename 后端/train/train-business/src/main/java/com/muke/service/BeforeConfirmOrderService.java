package com.muke.service;

import com.muke.req.ConfirmOrderDoReq;

public interface BeforeConfirmOrderService {

    Long beforeDoConfirm(ConfirmOrderDoReq req);
}
