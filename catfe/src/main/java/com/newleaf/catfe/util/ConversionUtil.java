package com.newleaf.catfe.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

//////////////////////////////////////////////
// Utility Class which handles simple conversions
// ex. truncating URLs, and type conversions.
//////////////////////////////////////////////
@Slf4j
@Component
public class ConversionUtil {

    public String boolToString(boolean bool){
        String str;
        if (bool == true) {
            str = "true";
        } else {
            str = null;
        }
        return str;
    }

    public boolean stringToBool(String str){
        boolean bool;
        if (str != null) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    public String truncateURL(String fullURL, String toRemove) {
        String result = fullURL;
        result = result.replace(toRemove, "");
        return result;
    }
}
