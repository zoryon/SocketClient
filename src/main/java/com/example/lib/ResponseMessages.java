package com.example.lib;

public class ResponseMessages {
    private static String OK = "ok";
    private static String ERROR = "error";
    private static String INVALID_CHOICE = "Scelta non valida, perfavore riprovare.";

    public static String getOk() {
        return OK;
    }

    public static String getError() {
        return ERROR;
    }

    public static String getInvalidChoice() {
        return INVALID_CHOICE;
    }
}
