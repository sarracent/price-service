package com.cloudx.priceservice.model.response;

import com.cloudx.priceservice.model.bo.PriceDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Object containing PriceResponse")
public class PriceResponse extends ServiceResponse {
    @Schema(description = "List of Prices")
    private List<PriceDTO> pricesList;
}
