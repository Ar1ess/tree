package com.softlab.lyzy.common;

import com.softlab.lyzy.common.util.JsonUtil;

public class slzyCalculate {

    public static double lmjz(int n, double[] c, double k){
        double sum = 0;
        for (int i = 0; i < c.length; i++){
            sum += c[i];
        }
        System.out.println(JsonUtil.getJsonString(c));
        return sum * k;
    }
}
