package com.softlab.lyzy.common.util;

/**
 * @author : Ar1es
 * @date : 2019/6/24
 * @since : Java 8
 */
public class StringUtil {

    public static String replace(String str){
        String str1 = str.replace("[", "");
        String str2 = str1.replace("]", "");
        String str3 = str2.replace("{", "");
        String str4 = str3.replace(",", "");
        String str5 = str4.replace("=", ":");
        return str5.replace("}", "<br/>");
    }
}
