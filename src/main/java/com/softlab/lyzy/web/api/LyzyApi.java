package com.softlab.lyzy.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.softlab.lyzy.common.util.JsonUtil;
import com.softlab.lyzy.common.util.RestData;
import com.softlab.lyzy.common.util.StringUtil;
import com.softlab.lyzy.core.mapper.LyzyMapper;
import com.softlab.lyzy.core.model.BolixianXBM;
import com.softlab.lyzy.service.ArgicsService;
import com.softlab.lyzy.service.LyzyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class LyzyApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final LyzyService lyzyService;
    private final LyzyMapper lyzyMapper;
    private final ArgicsService argicsService;

    @Autowired
    public LyzyApi(LyzyService lyzyService, LyzyMapper lyzyMapper, ArgicsService argicsService) {
        this.lyzyService = lyzyService;
        this.lyzyMapper = lyzyMapper;
        this.argicsService = argicsService;
    }




    /**
     * 多条件查询
     *
     * @param bolixianXBM
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public RestData selectAllNew(@RequestBody BolixianXBM bolixianXBM) {
        logger.info("select：" + JsonUtil.getJsonString(bolixianXBM));
        List<BolixianXBM> list = lyzyService.selectAll(bolixianXBM);
        return new RestData(list);
    }


    /**
     * 修改
     * （暂时无用）
     * 写的不对，暂时没用
     *
     * @param bolixianXBM
     * @return
     */
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public RestData update(@RequestBody BolixianXBM bolixianXBM) {
//        int flag = lyzyService.updateByCondition(bolixianXBM);
//        return new RestData(flag);
//    }


    /**
     * 小班面积汇总表
     *
     * @return
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public RestData show() {
        logger.info("show: 小班面积");
        List<Map<String, Object>> mapList = lyzyService.show();
        return new RestData(mapList);
    }


    @RequestMapping(value = "/show1", method = RequestMethod.GET)
    public RestData show1() {
        logger.info("show1: 小班面积");
        List<Map<String, Object>> mapList = lyzyService.showBaiduApi();
        return new RestData(mapList);
    }

    /**
     * 小班林班号
     *
     * @param bolixianXBM
     * @return
     */

    @RequestMapping(value = "/XB", method = RequestMethod.POST)
    public RestData selectXB(@RequestBody BolixianXBM bolixianXBM) {
        logger.info("select：" + JsonUtil.getJsonString(bolixianXBM));
        if (bolixianXBM.getXB() != null && bolixianXBM.getLB() != null){
            QueryWrapper<BolixianXBM> qw = new QueryWrapper<>();
            qw.and(wrapper -> wrapper.eq("XB",bolixianXBM.getXB()));
            qw.and(wrapper -> wrapper.eq("LB",bolixianXBM.getLB()));
            List<BolixianXBM> list = lyzyMapper.selectList(qw);
            return new RestData(list);
        }
        return new RestData(1, "数据有误");
        

    }

    @RequestMapping(value = "/argics", method = RequestMethod.GET)
    public RestData argics(@RequestParam(value="str") String str) {
        logger.info("str : " + str);
        List<Map <String, Object> > rtv = argicsService.selectArgics(str);
        return new RestData(StringUtil.replace(rtv.toString()));
    }

    @RequestMapping(value = "/lzq", method = RequestMethod.GET)
    public RestData selectAllLZQ(@RequestParam(value="str") String str){
        logger.info("str : " + str);
        List<Map <String, Object> > rtv = argicsService.selectAllLzqVo(str);
        return new RestData(StringUtil.replace(rtv.toString()));
    }

    @RequestMapping(value = "/lz", method = RequestMethod.GET)
    public RestData selectAllLZ(@RequestParam(value="str") String str){
        logger.info("str : " + str);
        List<Map <String, Object> > rtv = argicsService.selectAllLzVo(str);
        return new RestData(StringUtil.replace(rtv.toString()));
    }


}