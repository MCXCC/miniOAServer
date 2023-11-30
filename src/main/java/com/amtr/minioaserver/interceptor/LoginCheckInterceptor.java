package com.amtr.minioaserver.interceptor;

import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.amtr.minioaserver.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        log.info("请求为：{}", url);
        String jwt = request.getHeader("Authorization");
        if (jwt != null && jwt.startsWith("Bearer ")) {
            // Remove "Bearer " prefix
            jwt = jwt.substring(7);
            // Process the token here
        }
        // 检查 JWT 是否存在
        if (jwt == null || jwt.isEmpty()) {
            // 用户未登录，返回相应的错误信息或执行相关操作
            log.info("未登录的用户");
            Result error = Result.noLogin();
            String noLogin = JSONUtil.toJsonStr(error.getBody());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write(noLogin);
            return false;
        }

        // 检查 JWT 的是否有效
        if (!JWTUtil.verify(jwt, "5531".getBytes())) {
            // 无效的jwt令牌
            log.info("伪造令牌的非法用户");
            Result error = Result.noLogin();
            String noLogin = JSONUtil.toJsonStr(error.getBody());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write(noLogin);
            return false;
        }

        // 检查 JWT 的是否过期
        final JWT jwt0 = JWTUtil.parseToken(jwt);
        Object expireTime = jwt0.getPayload("expire_time");
        if (((NumberWithFormat) expireTime).longValue() < System.currentTimeMillis()) {
            // 过期的jwt令牌
            log.info("过期令牌的非法用户");
            Result error = Result.noLogin();
            String noLogin = JSONUtil.toJsonStr(error.getBody());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write(noLogin);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
