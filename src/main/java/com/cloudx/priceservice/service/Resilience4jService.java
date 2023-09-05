package com.cloudx.priceservice.service;

import java.util.function.Supplier;

public interface Resilience4jService {
    <T> T executePrices(Supplier<T> operation);
}
