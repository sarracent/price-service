package com.cloudx.priceservice.constants;

public class Constants {

    public static final String SESSION_NAME = "Session-Id";
    public static final String SESSION_DESCR = "Session-Id sent by client. It is the field that is used to keep track of the request made in the application.";

    public static final String CHANNEL_NAME = "Channel-Id";
    public static final String CHANNEL_DESCR = "Channel-Id sent by client. It is the field that is used to indicate the channel that the application consumes.";

    public static final String SERVICE_NAME = "Service-Id";
    public static final String SERVICE_DESCR = "Service-Id sent by client. It is the field that is used to indicate the name of the service that the application consumes.";


    public static final String SUCCESS_CODE = "200";
    public static final String SUCCESS_MSG = "Success";
    public static final String BADREQUEST_CODE = "400";
    public static final String BADREQUEST_MSG = "Bad Request";
    public static final String INTERNALSERVER_CODE = "500";
    public static final String INTERNALSERVER_MSG = "Internal Server Error";

    public static final String OK_MSG = "OK";
    public static final String ZERO_MSG = "0";

    public static final String EMPTY = "";
    public static final String Y = "Y";
    public static final String N = "N";
    public static final String OPNAME = "%s.%s";
    public static final String PARSE_EXCEPTION = "%s - Line Code Error: %s";

    public static final String FORWARD_SLASH = "/";
    public static final String HASH = "#";
    public static final String SEMICOLON = ";";
    public static final String COMMA = ",";

    public static final String FLAG_FEATURE_CELLULAR_NAME = "Cellular-number";
    public static final String FLAG_FEATURE_FUNCIONALITY_NAME = "Funcionality";
    public static final String FLAG_FEATURE_FUNCIONALITY = "FLAG_FEATURE_CR";
    public static final String PREFIJO_CACHE_PARAMETER="pre:parameters:1";
    public static final String CACHE_ID_PARAMETERS="PARAMETERS";

    private Constants() {
    }
}
