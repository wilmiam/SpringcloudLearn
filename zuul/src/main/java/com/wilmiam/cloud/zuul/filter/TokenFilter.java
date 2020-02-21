package com.wilmiam.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TokenFilter extends ZuulFilter {

    /**
     * 返回一个字符串代表过滤的类型
     * pre：路由之前
     * routing(route)：路由之时
     * post：路由之后
     * error：发送(打错，可能是发生)错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断是否要过滤
     * return true过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤的逻辑，可用很复杂，包括查sql，nosql去判断该请求有没有权限访问
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL()));
        String token = request.getParameter("token");
        if (token == null) {
            System.out.println("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("OK");
        return null;
    }
}
