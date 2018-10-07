package com.github.zzycjcg.httpmock.controller;

import com.github.zzycjcg.httpmock.util.Base58;
import com.github.zzycjcg.httpmock.util.RandomUtil;
import com.github.zzycjcg.httpmock.vo.UserAuthRspVo;
import com.github.zzycjcg.httpmock.vo.UserInfoRspVo;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * Created by zzy on  2018/10/06 12:38
 */
@RestController
public class WxApiMockCtrl {
    private static Logger logger = LoggerFactory.getLogger(WxApiMockCtrl.class);

    private final Cache<String, UserInfoRspVo> cache = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(10, TimeUnit.MINUTES).build();

    @GetMapping("/connect/oauth2/authorize")
    public void autoRedirectUrl(@RequestParam("appid") String appId, @RequestParam("redirect_uri") String redirectUri, @RequestParam("state") String state, HttpServletResponse response) throws Exception {
        logger.info("appId={}, redirect_uri={}, state={}", appId, redirectUri, state);
        String code = RandomUtil.getRandomString(8);
        response.sendRedirect(redirectUri + "?code=" + code + "&state=" + state);
    }

    @GetMapping("/sns/oauth2/access_token")
    public UserAuthRspVo userAuth(@RequestParam("appid") String appId, @RequestParam("secret") String secret, @RequestParam("code") String code) throws Exception {
        logger.info("appId={}, secret={}, code={}", appId, secret, code);
        UserAuthRspVo userAuthRspVo = new UserAuthRspVo();
        userAuthRspVo.setAccess_token(Base58.encode(UUID.randomUUID().toString().getBytes("utf-8")));
        userAuthRspVo.setExpires_in(7200);
        userAuthRspVo.setRefresh_token(Base58.encode(UUID.randomUUID().toString().getBytes("utf-8")));
        userAuthRspVo.setOpenid(UUID.randomUUID().toString().replaceAll("-", ""));
        return userAuthRspVo;
    }

    @GetMapping("/sns/userinfo")
    public UserInfoRspVo userAuth(@RequestParam("access_token") String accessToken, @RequestParam("openid") String openId) throws Exception {
        logger.info("accessToken={}, openId={}", accessToken, openId);
        if (openId == null || openId.isEmpty()) {
            throw new IllegalArgumentException("openId is invalid");
        }
        return cache.get(openId, () -> {
            UserInfoRspVo userAuthRspVo = new UserInfoRspVo();
            userAuthRspVo.setOpenid(openId);
            userAuthRspVo.setNickname("voice_of_coder");
            return userAuthRspVo;
        });
    }


}
