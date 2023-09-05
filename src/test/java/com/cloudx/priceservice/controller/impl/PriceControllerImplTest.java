package com.cloudx.priceservice.controller.impl;

import com.cloudx.priceservice.model.bo.PriceDTO;
import com.cloudx.priceservice.model.request.PriceRequest;
import com.cloudx.priceservice.model.response.PriceResponse;
import com.cloudx.priceservice.service.Resilience4jService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceControllerImplTest {

    @InjectMocks
    private PriceControllerImpl priceController;

    @Mock
    private Resilience4jService resilience4JService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testGetPricesRequestAt10AMOnDay14() {
        // Create test data
        Map<String, Object> httpHeadersMap = Map.of("service-id","price-service");
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        Long productId = 1L;
        Long brandId = 2L;

        // Mock the behavior of priceService and resilience4JService
        PriceRequest expectedRequest = PriceRequest.builder()
                .applicationDate(applicationDate)
                .productId(productId)
                .brandId(brandId)
                .build();
        PriceResponse expectedResponse = PriceResponse.builder()
                .prices(List.of(PriceDTO.builder()
                        .productId(35455L)
                        .brandId(1L)
                        .priceList(1L)
                        .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                        .endDate(LocalDateTime.of(2020, 12, 31, 0, 0, 0))
                        .price(35.5)
                        .build()))
                .resultCode("0")
                .resultMessage("OK")
                .build();

        when(resilience4JService.executePrices(any())).thenReturn(List.of(PriceDTO.builder()
                .productId(35455L)
                .brandId(1L)
                .priceList(1L)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 0, 0, 0))
                .price(35.5)
                .build())); // Provide your expected response here

        // Call the method to test
        var responseEntity = priceController.getPrices(httpHeadersMap, expectedRequest.getApplicationDate()
                , expectedRequest.getProductId(), expectedRequest.getBrandId());

        // Assert the response
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        assertEquals(expectedResponse, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals(expectedResponse.getPrices().size(), responseEntity.getBody().getPrices().size());
        assertEquals(expectedResponse.getPrices().get(0).getProductId(),
                responseEntity.getBody().getPrices().get(0).getProductId());
        assertEquals(expectedResponse.getPrices().get(0).getBrandId(),
                responseEntity.getBody().getPrices().get(0).getBrandId());
        assertEquals(expectedResponse.getPrices().get(0).getPriceList(),
                responseEntity.getBody().getPrices().get(0).getPriceList());
        assertEquals(expectedResponse.getPrices().get(0).getStartDate(),
                responseEntity.getBody().getPrices().get(0).getStartDate());
        assertEquals(expectedResponse.getPrices().get(0).getEndDate(),
                responseEntity.getBody().getPrices().get(0).getEndDate());
        assertEquals(expectedResponse.getPrices().get(0).getPrice(),
                responseEntity.getBody().getPrices().get(0).getPrice());
    }
}