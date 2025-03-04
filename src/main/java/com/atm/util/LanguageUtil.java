package com.atm.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageUtil {
    public static ResourceBundle getBundle(String lang) {
        Locale locale = new Locale(lang);
        return ResourceBundle.getBundle("messages", locale);
    }
}