package com.softlab.lyzy.service;

import java.util.List;
import java.util.Map;

/**
 * @author : Ar1es
 * @date : 2019/6/24
 * @since : Java 8
 */
public interface ArgicsService {

    List<Map<String, Object>> selectArgics(String str);

    List<Map<String,Object>> selectAllLzqVo(String str);

    List<Map<String,Object>> selectAllLzVo(String str);
}
