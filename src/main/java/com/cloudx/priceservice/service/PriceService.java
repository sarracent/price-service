package com.cloudx.priceservice.service;

import com.cloudx.priceservice.model.bo.PriceDTO;
import com.cloudx.priceservice.model.request.PriceRequest;

import java.util.List;

public interface PriceService {
    List<PriceDTO> findPricesByParameters(PriceRequest request);
}
