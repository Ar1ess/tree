package com.softlab.lyzy.core.mapper;

import com.softlab.lyzy.core.model.BolixianXBM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Ar1es
 * @date : 2019/6/24
 * @since : Java 8
 */

@Mapper
@Repository
public interface ArgicsMapper {

    @Select("select AVG(MGQXJ) as avgXj, AVG(Z_MGQZS) as avgZs, YSSZZ from bolixian_xbm2017 where XIANG_NAME = #{str} AND YSSZZ = '杨树林'")
    List<BolixianXBM> selectArgicsYsl(String str);

    @Select("select AVG(MGQXJ) as avgXj, AVG(Z_MGQZS) as avgZs, YSSZZ from bolixian_xbm2017 where XIANG_NAME = #{str} AND YSSZZ = '落叶松林'")
    List<BolixianXBM> selectArgicsLys(String str);

    @Select("select AVG(MGQXJ) as avgXj, AVG(Z_MGQZS) as avgZs, YSSZZ from bolixian_xbm2017 where XIANG_NAME = #{str} AND YSSZZ = '樟子松林'")
    List<BolixianXBM> selectArgicsZzs(String str);

    @Select("select AVG(MGQXJ) as avgXj, AVG(Z_MGQZS) as avgZs, YSSZZ from bolixian_xbm2017 where XIANG_NAME = #{str} AND YSSZZ = '软阔叶混交林'")
    List<BolixianXBM> selectArgicsRkl(String str);

    @Select("select AVG(MGQXJ) as avgXj, AVG(Z_MGQZS) as avgZs, YSSZZ from bolixian_xbm2017 where XIANG_NAME = #{str} AND YSSZZ = '柞树林'")
    List<BolixianXBM> selectArgicsZsl(String str);

    @Select("select AVG(MGQXJ) as avgXj,AVG(Z_MGQZS) as avgZs, LZ from bolixian_xbm2017 WHERE XIANG_NAME=#{xiangName} and LZ is not null GROUP BY LZ")
    List<BolixianXBM> selectAllLZVo(String xiangName);

    @Select("select AVG(MGQXJ) as avgXj,AVG(Z_MGQZS) as avgZs,LZQ from bolixian_xbm2017 WHERE XIANG_NAME=#{xiangName} and LZQ is not null GROUP BY LZQ")
    List<BolixianXBM> selectAllLZQVo(String xiangName);
}
