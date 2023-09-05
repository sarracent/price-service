package com.cloudx.priceservice.service.impl;

import com.cloudx.priceservice.service.Resilience4jService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class Resilience4jServiceImpl implements Resilience4jService {

    private static final String PRICES_API = "prices";

    @Override
    @CircuitBreaker(name = PRICES_API)
    @RateLimiter(name = PRICES_API)
    @Bulkhead(name = PRICES_API)
    @Retry(name = PRICES_API)
    public <T> T executePrices(Supplier<T> operation) {
        return operation.get();
    }


}
