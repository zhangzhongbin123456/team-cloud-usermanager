package com.team.usermanager.aop;

import com.team.usermanager.util.UUIDGenerator;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Created By Zzbin
 * @version: v1.0
 * @date: 2019/12/26
 * @description: 日志拦截器
 */
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    /**
     * 日志跟踪标识
     */
    private static final String TRACE_ID = "TRACE_ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String traceId = UUIDGenerator.getUUID();
        if (StringUtils.isEmpty(MDC.get(TRACE_ID))) {
            MDC.put(TRACE_ID, traceId);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        MDC.remove(TRACE_ID);
    }

}
