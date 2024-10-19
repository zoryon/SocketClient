package com.example.lib;

public class ResponseMessages {
    private static String OK = "ok";
    private static String ERROR = "error";
    private static String INVALID_CHOICE = "Errore nella richiesta, perfavore riprovare.";
    private static String DEFAULT_CHOICE = "Scelta non valida, perfavore riprovare.";

    public static String getOk() {
        return OK;
    }

    public static String getError() {
        return ERROR;
    }

    public static String getINVALID_CHOICE() {
        return INVALID_CHOICE;
    }

    public static String getDEFAULT_CHOICE() {
        return DEFAULT_CHOICE;
    }
}
