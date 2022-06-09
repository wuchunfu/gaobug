package com.imantou.auth.handler;

import com.imantou.api.vo.PlatformUserVO;
import com.imantou.auth.dto.PlatformLoginForm;
import com.imantou.auth.vo.PlatformUserContextVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * github登录
 *
 * @author gaobug
 */
@Slf4j
@Service
public class GithubLoginHandler extends AbstractLoginHandler {

    @Override
    public PlatformUserVO getLoginUser(PlatformLoginForm form) {
        return null;
    }
}