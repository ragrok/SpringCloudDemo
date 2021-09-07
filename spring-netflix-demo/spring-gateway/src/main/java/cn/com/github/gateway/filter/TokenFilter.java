package cn.com.github.gateway.filter;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class TokenFilter implements GlobalFilter, Ordered {

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log .info("request = {}", JSONUtil.toJsonStr(exchange.getRequest()) );
        String token = exchange.getRequest().getQueryParams().getFirst("authToken");
        //向headers中放文件，记得build
        ServerHttpRequest host = exchange
                .getRequest()
                .mutate()
                .header("a", "888")
                .build();
        //将现在的request 变成 change对象
        ServerWebExchange build = exchange.mutate().request(host).build();
        return chain.filter(build);
    }

    public int getOrder() {
        return 0;
    }
}
