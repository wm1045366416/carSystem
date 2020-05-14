package com.jkxy.car.api.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


public class StringUnit {

    public static boolean isEmpty(String str){
        if(str==null||"".equals(str)){
            return true;
        }else{
            return false;
        }
    }
}