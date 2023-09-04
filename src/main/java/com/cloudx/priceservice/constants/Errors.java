package com.cloudx.priceservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Errors {
    ERROR_BUSINESS_VALIDATION("100000", "Error el campo %s es obligatorio"),
    ERROR_BUSINESS_VALIDATION_NULL("100001", "Error el campo %s es nulo"),
    ERROR_BUSINESS_VALIDATION_EMPTY("100002", "Error el campo %s es vacio"),
    ERROR_BUSINESS_VALIDATION_NULL_OR_EMPTY("100003", "Error el campo %s es nulo o vacio"),
    ERROR_BUSINESS_VALIDATION_INCORRECT("100004", "Error el campo %s es incorrecto"),
    ERROR_BUSINESS_VALIDATION_INCORRECT_TYPE("100005", "Error el campo %s es incorrecto, no es del tipo %s"),
    ERROR_BUSINESS_VALIDATION_LINE_NUMBER("100010", "Error la linea %s debe ser un numero"),
    ERROR_BUSINESS_VALIDATION_LINE_NUMBER_INCORRECT("100011", "Error la linea %s es incorrecta"),
    ERROR_BUSINESS_VALIDATION_LINE_NUMBER_NULL("100012", "Error la linea no puede ser nulo o vacio"),
    ERROR_BUSINESS_VALIDATION_CHANNEL("100050", "Error el canal %s, no esta permitido en el sistema"),
    ERROR_BUSINESS_VALIDATION_COUNTRY("100060", "Error el pais %s, no esta permitido en el sistema"),
    ERROR_BUSINESS_VALIDATION_COUNTRY_NOT_FOUND("100061", "Error el pais %s, no se encuentra cargado en el sistema"),
    ERROR_BUSINESS_VALIDATION_BUSINESS("100070", "Error la línea %s posee el tipo de negocio %s, no esta permitido en el sistema"),


    ERROR_DATABASE_GENERAL("200000", "Error al consultar la base de datos -> [%s] %s"),
    ERROR_DATABASE_GENERAL_NOT_FOUND("200001", "Error la consulta de la base no produjo resultados"),
    ERROR_DATABASE_GENERAL_DUPLICATE("200002", "Error la consulta de la base se encontraron 2 o mas resultados"),
    ERROR_DATABASE_GENERAL_NOT_VALUE("200003", "Error no se encontraron datos cargados en el registro con el valor %s"),
    ERROR_DATABASE_PARAMETERS("200100", "Error al consultar la base de datos CCARD ParametersDAO -> [%s] %s"),
    ERROR_DATABASE_PARAMETERS_NOT_FOUND("200101", "Error no se encontraron registros en PREPAY_PARAMETERS con el valor %s"),
    ERROR_DATABASE_PARAMETERS_DUPLICATE("200102", "Error se encontraron 2 o mas registros en PREPAY_PARAMETERS con el valor %s"),
    ERROR_DATABASE_PARAMETERS_NOT_VALUE("200103", "Error no se encontraron datos cargados en el registro de PREPAY_PARAMETERS con el valor %s"),
    ERROR_DATABASE_CELLULARS("200200", "Error al consultar la base de datos PROD CellularsDAO -> [%s] %s"),
    ERROR_DATABASE_CELLULARS_NOT_FOUND("200201", "Error no se encontraron registros en CELLULARS con el valor %s"),
    ERROR_DATABASE_CELLULARS_DUPLICATE("200202", "Error se encontraron 2 o mas registros en CELLULARS con el valor %s"),
    ERROR_DATABASE_CELLULARS_PLANS("200210", "Error al consultar la base de datos PROD CellularsPlansDAO -> [%s] %s"),
    ERROR_DATABASE_CELLULARS_PLANS_NOT_FOUND("200211", "Error no se encontraron registros en CELLULARS_PLANS, CELLULARS con el valor %s"),
    ERROR_DATABASE_CELLULARS_PLANS_DUPLICATE("200212", "Error se encontraron 2 o mas registros en CELLULARS_PLANS, CELLULARS con el valor %s"),

    ERROR_TN3_CELLULARS_NOT_FOUND("200301", "Error no se encontraron datos en Tn3 para la linea %s"),

    ERROR_EXTERNAL_API_GENERAL("400000", "Error General en el servicio -> [%s] %s"),
    ERROR_EXTERNAL_PARAMETERS_GENERAL("400100", "Error General en el servicio Parameters -> [%s] %s"),
    ERROR_EXTERNAL_PARAMETERS_CLIENT("400101", "Error en el servicio Parameters -> [%s] %s"),
    ERROR_EXTERNAL_PARAMETERS_RESULT("400102", "Error en el servicio Parameters: %s, no produjo resultados"),
    ERROR_EXTERNAL_PARAMETERS_R4J("400105", "Error External Api Parameters Resilience4j -> [%s] %s"),
    ERROR_EXTERNAL_PARAMETERS_R4J_CIRCUIT_BREAKER("400106", "Error External Api Parameters Circuit-Breaker -> [%s] %s"),
    ERROR_EXTERNAL_PARAMETERS_R4J_RATELIMITER("400107", "Error External Api Parameters Rater Limiter-> [%s] %s"),

    ERROR_FLAG_FEATURE_SERVICE("400100", "Error al llamar al servicio sp-flag-feature-service para la linea %s -> %s"),

    ERROR_GENERAL("900000", "Error General -> [%s] %s");

    private final String code;
    private final String message;

}