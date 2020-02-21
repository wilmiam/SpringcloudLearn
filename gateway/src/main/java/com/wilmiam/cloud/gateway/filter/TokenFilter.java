package com.wilmiam.cloud.gateway.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器
 * 排序同级的时候全局路由优先于指定路由
 */
@Configuration // 将自定义过滤器注入到spring IOC容器
public class TokenFilter implements GlobalFilter, Ordered {

    private static final Log log = LogFactory.getLog(TokenFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String jwtToken = exchange.getRequest().getHeaders().getFirst("Authorization"); //获取Authorization中的token
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        log.info("经过全局路由，token：" + token);
        if (token == null || token.isEmpty()) {
            //不合法(响应未登录的异常)
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //设置headers
            HttpHeaders httpHeaders = response.getHeaders();
            httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
            httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
            //设置body
            String warningStr = "未登录或登录超时";
            DataBuffer bodyDataBuffer = response.bufferFactory().wrap(warningStr.getBytes());
            return response.writeWith(Mono.just(bodyDataBuffer));
        }
        return chain.filter(exchange);
    }

    /**
     * 给过滤器设定优先级别的，值越大则优先级越低
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }

}

