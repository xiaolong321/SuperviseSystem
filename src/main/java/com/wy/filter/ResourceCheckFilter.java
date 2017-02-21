package com.wy.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于检查是否是否有相应的资源的过滤器
 * Created by Administrator on 2017/2/21.
 */
public class ResourceCheckFilter extends AccessControlFilter{

    private String errorUrl;

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    public static Logger getLogger() {
        return logger;
    }

    private static final Logger logger = LoggerFactory.getLogger(ResourceCheckFilter.class);

    /**
     * 表示是否允许访问，如果允许访问返回true，否则返回false。
     */
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject=getSubject(servletRequest,servletResponse);
        String url=getPathWithinApplication(servletRequest);
        logger.debug("当前的用户正在访问url==>"+url);
        return subject.isPermitted(url);
    }

    /**
     * 表示当访问拒绝时是否已经处理了；如果返回 true 表示需要继续处理；如果返回 false 表示该拦截器实例已经处理了，将直接返回即可。
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        logger.debug("当isAccessAllowed方法返回false的时候，才会执行onAccessDenied方法");
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse= (HttpServletResponse) servletResponse;
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+this.errorUrl);
        // 返回 false 表示已经处理，例如页面跳转啥的，表示不在走以下的拦截器了（如果还有配置的话）
        return false;
    }
}
