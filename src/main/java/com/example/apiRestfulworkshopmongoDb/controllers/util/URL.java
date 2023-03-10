package com.example.apiRestfulworkshopmongoDb.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8"); //texto que quero decodificar / o padrao
        } catch (UnsupportedEncodingException ex) {
           return "";
        }
    }

    public static Date converteDate(String textDate, Date defaultValue){
        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
        stf.setTimeZone(TimeZone.getTimeZone("UTF-8"));
        try {
            return stf.parse(textDate);
        } catch (ParseException ex) {
            return defaultValue;
        }
    }


}
