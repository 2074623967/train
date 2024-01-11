package com.muke.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.muke.domain.Member;
import com.muke.domain.MemberExample;
import com.muke.exception.BusinessException;
import com.muke.exception.BusinessExceptionEnum;
import com.muke.mapper.MemberMapper;
import com.muke.req.MemberRegisterReq;
import com.muke.service.MemberService;
import com.muke.util.SnowUtil;
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
    public long register(MemberRegisterReq req) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(req.getMobile());
        List<Member> list = memberMapper.selectByExample(memberExample);
        if (CollUtil.isNotEmpty(list)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(req.getMobile());
        memberMapper.insert(member);
        return member.getId();
    }
}
