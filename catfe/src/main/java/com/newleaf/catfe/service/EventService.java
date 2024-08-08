package com.newleaf.catfe.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventService {

//    public Date convertDate(String date){
//        Date result = new Date();
//        String pattern = "yyyy-MM-dd HH:mm:ss";
//        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
////        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//        date = date + ":00";
//        log.debug("Date String: " + date);
//        try {
////            result = dateFormat.parse(date);
//            result = DateUtils.parseDate(date, new String[] {"yyyy-MM-dd HH:mm:ss"});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//        return result;
//    }

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
