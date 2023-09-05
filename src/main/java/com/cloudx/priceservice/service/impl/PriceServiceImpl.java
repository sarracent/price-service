package com.cloudx.priceservice.service.impl;

import com.cloudx.priceservice.annotations.log.LogService;
import com.cloudx.priceservice.model.Price;
import com.cloudx.priceservice.model.bo.PriceDTO;
import com.cloudx.priceservice.model.request.PriceRequest;
import com.cloudx.priceservice.repository.PriceRepository;
import com.cloudx.priceservice.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    @LogService
    @Override
    public List<PriceDTO> findPricesByParameters(PriceRequest request) {
        List<Price> priceList = priceRepository.findPriceInfo(request.getApplicationDate(), request.getProductId(), request.getBrandId());
        return mapToPriceDTO(priceList);
    }

    private List<PriceDTO> mapToPriceDTO(List<Price> priceList) {
        return priceList.stream()
                .map(this::mapRowToPriceDTO)
                .collect(Collectors.toList());
    }

    private PriceDTO mapRowToPriceDTO(Price row) {
        return PriceDTO.builder()
                .productId(row.getProductId())
                .brandId(row.getBrandId())
                .priceList(row.getPriceList())
                .startDate(row.getStartDate())
                .endDate(row.getEndDate())
                .price(row.getPrice())
                .build();
    }
}
