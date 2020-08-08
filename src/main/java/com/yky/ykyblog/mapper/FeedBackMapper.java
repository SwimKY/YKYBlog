package com.yky.ykyblog.mapper;

import com.yky.ykyblog.model.FeedBack;
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
public interface FeedBackMapper {

    @Insert("insert into feedback(feedbackContent,contactInfo,personId,feedbackDate) values(#{feedbackContent},#{contactInfo},#{personId},#{feedbackDate})")
    void save(FeedBack feedBack);

    @Select("select * from feedback order by id desc")
    List<FeedBack> getAllFeedback();

}
