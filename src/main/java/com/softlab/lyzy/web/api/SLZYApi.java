package com.softlab.lyzy.web.api;

import com.softlab.lyzy.common.slzyCalculate;
import com.softlab.lyzy.common.util.RestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class SLZYApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @PostMapping(value = "/value")
    public RestData value(@RequestParam(value = "str") String str, @RequestParam(value = "n") Integer n, @RequestParam(value = "k") Double k){
        logger.info( "n: "+ String.valueOf(n) + "\t" + "k: " + String.valueOf(k));
        String[] arr = str.split(",");
        if (arr.length != n) {
            return new RestData(0, "输入格式有误");
        }
        double[] c = new double[n];
        for (int i=0; i < arr.length; i++){
            if (arr[i].isEmpty()){
                return new RestData(0, "输入格式有误");
            }
            c[i] = Double.parseDouble(arr[i]);
        }
        return new RestData(slzyCalculate.lmjz(n, c, k));
    }
}
