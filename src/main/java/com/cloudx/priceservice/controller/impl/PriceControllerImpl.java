package com.cloudx.priceservice.controller.impl;

import com.cloudx.priceservice.annotations.auditable.AuditableApi;
import com.cloudx.priceservice.annotations.auditable.AuditableParamIgnore;
import com.cloudx.priceservice.annotations.auditable.AuditableReturn;
import com.cloudx.priceservice.controller.PriceController;
import com.cloudx.priceservice.model.request.PriceRequest;
import com.cloudx.priceservice.model.response.PriceResponse;
import com.cloudx.priceservice.service.PriceService;
import com.cloudx.priceservice.service.Resilience4jService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

import static com.cloudx.priceservice.commons.resolver.CustomHeadersResolver.getHeadersMap;
import static com.cloudx.priceservice.commons.resolver.CustomHeadersResolver.validateHeaders;
import static com.cloudx.priceservice.constants.Constants.OK_MSG;
import static com.cloudx.priceservice.constants.Constants.ZERO_MSG;

@RestController
@AllArgsConstructor
public class PriceControllerImpl implements PriceController {
    private final PriceService priceService;
    private final Resilience4jService resilience4JService;

    @Override
    @AuditableApi(
            description = "getCellularByCellularNumber Api",
            parameterIgnore = @AuditableParamIgnore(nameToAudit = "httpHeadersMap", type = Map.class),
            returnMethod = @AuditableReturn(type = PriceResponse.class))
    public ResponseEntity<PriceResponse> getPrices(final Map<String, Object> httpHeadersMap,
                                                   final LocalDateTime applicationDate,
                                                   final Long productId,
                                                   final Long brandId) {

        final Map<String, String> headersMap = getHeadersMap(httpHeadersMap);
        validateHeaders(headersMap);

        var request = PriceRequest.builder()
                .applicationDate(applicationDate)
                .productId(productId)
                .brandId(brandId).build();
        var response = PriceResponse.builder()
                .prices(resilience4JService.executePrices(() -> priceService.findPricesByParameters(request)))
                .resultCode(ZERO_MSG)
                .resultMessage(OK_MSG)
                .build();

        return ResponseEntity.ok()
                .body(response);
    }
}
