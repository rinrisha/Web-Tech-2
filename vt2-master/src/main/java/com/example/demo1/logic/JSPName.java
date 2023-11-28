package com.example.demo1.logic;

public enum JSPName {
    MAIN_PAGE("/demo1_war/"),   // Represents the main page with the specified URL pattern.
    ERROR_PAGE(""),                // Represents the error page with an empty URL pattern.

    BASKET_PAGE("/demo1_war/basket"),

    SINGLE_CATEGORY("/demo1_war/single-category"),
    LOG_IN("/demo1_war/login"),
    REGISTRATION("/demo1_war/registration"),
    ADMIN("/demo1_war/admin");

    private final String urlPattern;

    JSPName(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public static JSPName fromURI(String uri) {
        for (JSPName mapping : values()) {
            if (mapping.getUrlPattern().equals(uri)) {
                return mapping;
            }
        }
        return null;
    }
}

