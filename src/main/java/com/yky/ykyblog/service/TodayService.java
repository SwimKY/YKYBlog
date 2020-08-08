package com.yky.ykyblog.service;


import com.yky.ykyblog.model.DailySpeech;
import com.yky.ykyblog.utils.DataMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe: 藏心阁-今日
 */
public interface TodayService {

    DataMap publishISay(DailySpeech dailySpeech);

    DataMap getTodayInfo(int rows, int pageNum);

}
