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

    public static String getString(String str) {
        //用回车键来分隔几个元素
        String[] ss = str.split("\n");
        String s = ss[ss.length-2];
        String[] strarray = s.split("：");
        for (int i = 0; i < strarray.length; i++){
             System.out.println("strarray:"+strarray[i]);
        }
        String rtv = strarray[1];
        System.out.println("StringUtil rtv ="+rtv);
        return rtv;
    }
}
