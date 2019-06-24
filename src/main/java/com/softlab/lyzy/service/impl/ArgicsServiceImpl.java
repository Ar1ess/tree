package com.softlab.lyzy.service.impl;

import com.softlab.lyzy.common.util.StringUtil;
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
    public List<Map<String, Object>> selectArgics(String s) {
        String str = StringUtil.getString(s);
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
            map.put("每公顷蓄积", String.format("%.2f", b.getAvgXj()));
            map.put("每公顷株数", String.format("%.2f", b.getAvgZs()));
            list.add(map);
        }
        if (null != ysl.get(0)) {
            Map<String, Object> map = new HashMap<>();
            BolixianXBM b1 = ysl.get(0);
            map.put("优势树种组", b1.getYSSZZ());
            map.put("每公顷蓄积", String.format("%.2f", b1.getAvgXj()));
            map.put("每公顷株数", String.format("%.2f", b1.getAvgZs()));
            list.add(map);
        }
        if (null != lys.get(0)) {
            Map<String, Object> map = new HashMap<>();
            BolixianXBM b2 = lys.get(0);
            map.put("优势树种组", b2.getYSSZZ());
            map.put("每公顷蓄积", String.format("%.2f", b2.getAvgXj()));
            map.put("每公顷株数", String.format("%.2f", b2.getAvgZs()));
            list.add(map);
        }
        if (null != zzs.get(0)) {
            Map<String, Object> map = new HashMap<>();
            BolixianXBM b3 = zzs.get(0);
            map.put("优势树种组", b3.getYSSZZ());
            map.put("每公顷蓄积", String.format("%.2f", b3.getAvgXj()));
            map.put("每公顷株数", String.format("%.2f", b3.getAvgZs()));
            list.add(map);
        }
        if (null != rkl.get(0)) {
            Map<String, Object> map = new HashMap<>();
            BolixianXBM b4 = rkl.get(0);
            map.put("优势树种组", b4.getYSSZZ());
            map.put("每公顷蓄积", String.format("%.2f", b4.getAvgXj()));
            map.put("每公顷株数", String.format("%.2f", b4.getAvgZs()));
            list.add(map);
        }
        System.out.println(list.toString());
        return list;
    }

    @Override
    public List<Map<String, Object>> selectAllLzqVo(String s) {
        String str = StringUtil.getString(s);
        List<Map<String, Object>> rtv = new ArrayList<>();
        List<BolixianXBM> list = argicsMapper.selectAllLZQVo(str);
        if(null != list){
            for(BolixianXBM b : list){
                Map<String, Object> map = new HashMap<>();
                map.put("林种区",b.getLZQ());
                map.put("每公顷蓄积", String.format("%.2f", b.getAvgXj()));
                map.put("每公顷株数", String.format("%.2f", b.getAvgZs()));
                rtv.add(map);
            }
        }
        return rtv;
    }

    @Override
    public List<Map<String, Object>> selectAllLzVo(String s) {
        String str = StringUtil.getString(s);
        List<Map<String, Object>> rtv = new ArrayList<>();
        List<BolixianXBM> list = argicsMapper.selectAllLZVo(str);
        if(null != list){
            for(BolixianXBM b : list){
                Map<String, Object> map = new HashMap<>();
                map.put("龄组",b.getLZ());
                map.put("每公顷蓄积", String.format("%.2f", b.getAvgXj()));
                map.put("每公顷株数", String.format("%.2f", b.getAvgZs()));
                rtv.add(map);
            }
        }
        return rtv;
    }


}
