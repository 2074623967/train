package com.muke.service.impl;

import com.muke.mapper.MemberMapper;
import com.muke.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 会员模块
 *
 * @author tangcj
 * @date 2024/01/11 11:29
 **/
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public Integer count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }
}
