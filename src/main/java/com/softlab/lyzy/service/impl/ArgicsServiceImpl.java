package com.softlab.lyzy.service.impl;

import com.softlab.lyzy.core.mapper.ArgicsMapper;
import com.softlab.lyzy.core.model.BolixianXBM;
import com.softlab.lyzy.service.ArgicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Ar1es
 * @date : 2019/6/24
 * @since : Java 8
 */
@Service
public class ArgicsServiceImpl implements ArgicsService {

    private final ArgicsMapper argicsMapper;

    @Autowired
    public ArgicsServiceImpl(ArgicsMapper argicsMapper) {
        this.argicsMapper = argicsMapper;
    }




    @Override
    public List<Map<String, Object>> selectArgics(String str) {
        List<BolixianXBM> zsl = argicsMapper.selectArgicsZsl(str);
        List<BolixianXBM> ysl = argicsMapper.selectArgicsYsl(str);
        List<BolixianXBM> lys = argicsMapper.selectArgicsLys(str);
        List<BolixianXBM> zzs = argicsMapper.selectArgicsZzs(str);
        List<BolixianXBM> rkl = argicsMapper.selectArgicsRkl(str);
        List<Map<String, Object>> list = new ArrayList<>();
        if (null != zsl.get(0)) {
            Map<String, Object> map = new HashMap<>();
            BolixianXBM b = zsl.get(0);
            map.put("优势树种组", b.getYSSZZ());
            map.put("每公顷蓄积", b.getAvgXj());
            map.put("每公顷株数", b.getAvgZs());
            list.add(map);
        }
        if (null != ysl.get(0)) {
            Map<String, Object> map = new HashMap<>();
            BolixianXBM b1 = ysl.get(0);
            map.put("优势树种组", b1.getYSSZZ());
            map.put("每公顷蓄积", b1.getAvgXj());
            map.put("每公顷株数", b1.getAvgZs());
            list.add(map);
        }
        if (null != lys.get(0)) {
            Map<String, Object> map = new HashMap<>();
            BolixianXBM b2 = lys.get(0);
            map.put("优势树种组", b2.getYSSZZ());
            map.put("每公顷蓄积", b2.getAvgXj());
            map.put("每公顷株数", b2.getAvgZs());
            list.add(map);
        }
        if (null != zzs.get(0)) {
            Map<String, Object> map = new HashMap<>();
            BolixianXBM b3 = zzs.get(0);
            map.put("优势树种组", b3.getYSSZZ());
            map.put("每公顷蓄积", b3.getAvgXj());
            map.put("每公顷株数", b3.getAvgZs());
            list.add(map);
        }
        if (null != rkl.get(0)) {
            Map<String, Object> map = new HashMap<>();
            BolixianXBM b4 = rkl.get(0);
            map.put("优势树种组", b4.getYSSZZ());
            map.put("每公顷蓄积", b4.getAvgXj());
            map.put("每公顷株数", b4.getAvgZs());
            list.add(map);
        }
        System.out.println(list.toString());
        return list;
    }
}
