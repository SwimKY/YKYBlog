package com.yky.ykyblog.mapper;

import com.yky.ykyblog.model.DailySpeech;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: TODO
 */
@Mapper
@Repository
public interface TodayMapper {

    @Insert("insert into daily_speech(content,mood,picsUrl,publishDate) values(#{content}, #{mood}, #{picsUrl}, #{publishDate})")
    void save(DailySpeech dailySpeech);

    @Select("select * from daily_speech order by id desc")
    List<DailySpeech> getTodayInfo();

}
