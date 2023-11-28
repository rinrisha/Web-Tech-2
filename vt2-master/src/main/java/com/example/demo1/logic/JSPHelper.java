package com.example.demo1.logic;

import com.example.demo1.Jsp.impl.*;

import java.util.HashMap;
import java.util.Map;

public class JSPHelper {

    private static final JSPHelper jspHelper = new JSPHelper();
    private Map<JSPName, JSPPAge> pages = new HashMap<>();


    public JSPHelper() {
        // Initializing predefined JSP pages
        pages.put(JSPName.MAIN_PAGE, new MainPage());
        pages.put(JSPName.ERROR_PAGE, new ErrorPage());
        pages.put(JSPName.BASKET_PAGE, new BasketPage());
        pages.put(JSPName.SINGLE_CATEGORY, new SingleCotegoryPage());
        pages.put(JSPName.LOG_IN, new LoginPage());
        pages.put(JSPName.REGISTRATION, new RegistrationPage());
        pages.put(JSPName.ADMIN, new AdminPage());
    }

    /**
     * Retrieves the singleton instance of the JSPHelper class.
     *
     * @return The singleton instance of JSPHelper.
     */
    public static JSPHelper getJspHelper() {
        return jspHelper;
    }

    /**
     * Retrieves the JSPPAge implementation associated with the given mapping.
     *
     * @param mapping The mapping or name of the JSP page.
     * @return The JSPPAge implementation corresponding to the mapping.
     *         Returns the error page if the mapping is invalid or not found.
     */
    public JSPPAge getPage(String mapping) {
        JSPName pageName = null;
        JSPPAge page = null;

        try {
            pageName = JSPName.fromURI(mapping);
            page = pages.get(pageName);
        } catch (IllegalArgumentException | NullPointerException e) {
            // Log the exception or invalid mapping
            page = pages.get(JSPName.ERROR_PAGE);
        }

        return page;
    }
}



