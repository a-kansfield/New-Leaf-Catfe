package com.newleaf.catfe.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
}
