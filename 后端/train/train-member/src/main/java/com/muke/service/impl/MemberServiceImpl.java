package com.muke.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.muke.domain.Member;
import com.muke.domain.MemberExample;
import com.muke.mapper.MemberMapper;
import com.muke.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public long register(String mobile) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if (CollUtil.isNotEmpty(list)) {
            throw new RuntimeException("手机号已注册");
        }
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
