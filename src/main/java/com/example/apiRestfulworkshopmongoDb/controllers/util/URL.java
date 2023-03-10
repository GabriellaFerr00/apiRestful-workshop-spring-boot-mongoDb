package com.example.apiRestfulworkshopmongoDb.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8"); //texto que quero decodificar / o padrao
        } catch (UnsupportedEncodingException ex) {
           return "";
        }
    }
}
