package com.muke.service;

import com.muke.req.MemberLoginReq;
import com.muke.req.MemberRegisterReq;
import com.muke.req.MemberSendCodeReq;
import com.muke.resp.MemberLoginResp;

public interface MemberService {

    Integer count();

    long register(MemberRegisterReq req);

    void sendCode(MemberSendCodeReq req);

    MemberLoginResp login(MemberLoginReq req);
}
