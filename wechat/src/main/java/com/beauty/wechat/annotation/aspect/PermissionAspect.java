package com.beauty.wechat.annotation.aspect;

import com.beauty.wechat.annotation.Permission;
import com.beauty.wechat.annotation.SourceType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/10/30 4:19 下午
 */
@Slf4j
@Aspect
@Component
public class PermissionAspect {

    // 注解声明切点，注解的全限定名
    @Pointcut("@annotation(com.beauty.wechat.annotation.Permission)")
    public void annotationPointcut() {
    }

    @Around("annotationPointcut()&& @annotation(permission)")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint, Permission permission) {

        final ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (servletRequestAttributes == null) {
            return ResponseEntity.internalServerError();
        }

        HttpServletRequest request = servletRequestAttributes.getRequest();
        String token = request.getHeader("token");

        final SourceType sourceType = permission.sourceType();
        boolean hasPermission = false;

        switch (sourceType) {
            case WECHAT:
                hasPermission = hasWeChatPermission(token);
                break;
            case OPEN:
                hasPermission = hasOpenPermission(token);
                break;
            default:
                break;
        }

        if (hasPermission) {
            try {
                return proceedingJoinPoint.proceed();
            } catch (Throwable e) {
                log.warn(String.valueOf(e));
            }
        }
        return ResponseEntity.internalServerError();

    }

    private Boolean hasWeChatPermission(String token) {
        if (!StringUtils.hasLength(token)) {
            return false;
        }
        log.info("wechat 鉴权通过");

        // 鉴权逻辑
        return true;

    }

    private Boolean hasOpenPermission(String token) {
        if (!StringUtils.hasLength(token)) {
            return false;
        }

        log.info("open 鉴权通过");
        // 鉴权逻辑
        return true;

    }

}
