package com.muke.service;

import com.muke.req.MemberRegisterReq;

public interface MemberService {

    Integer count();

    long register(MemberRegisterReq req);
}
