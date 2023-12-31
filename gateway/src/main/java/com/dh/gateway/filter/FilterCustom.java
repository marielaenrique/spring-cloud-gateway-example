package com.dh.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Component
public class FilterCustom extends AbstractGatewayFilterFactory<FilterCustom.Config> {

    private static Logger log = Logger.getLogger(FilterCustom.class.getName());

    private static AtomicInteger COUNT_CALL_GATEWAY = new AtomicInteger(0);

    public FilterCustom() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {
            log.info("Path requested: " + exchange.getRequest().getPath());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("Cantidad de llamadas al Gateway: " + COUNT_CALL_GATEWAY.incrementAndGet());

                log.info("Time response: " + Calendar.getInstance().getTime());
            }));
        };
    }

    public static class Config {

    }

}