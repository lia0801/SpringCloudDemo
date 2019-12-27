package com.hp.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤
 */
@Component
public class ZuulUser extends ZuulFilter {

    @Override
    public String filterType() {
        //请求在被路由之前执行
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //请求头之前，查看请求参数
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletRequest request = currentContext.getRequest();
        String parameter = request.getParameter("access-token");
        if(StringUtils.isBlank(parameter)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(403);
        }
        return null;
    }
}
