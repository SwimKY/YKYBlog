package com.yky.ykyblog.mapper;

import com.yky.ykyblog.model.FriendLink;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 友链
 */
@Repository
@Mapper
public interface FriendLinkMapper {

    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, statementType = StatementType.STATEMENT,resultType=int.class)
    @Insert("insert into friendlink(blogger,url) values(#{blogger},#{url})")
    int save(FriendLink friendLink);

    @Update("update friendlink set blogger=#{friendLink.blogger},url=#{friendLink.url} where id=#{id}")
    void updateFriendLink(@Param("friendLink") FriendLink friendLink, @Param("id") int id);

    @Select("select * from friendlink")
    @Cacheable(key = "#root.methodName", value = {"getAllFriendLink"})
    List<FriendLink> getAllFriendLink();

    @Select("select IFNULL((select id from friendlink where blogger=#{blogger}), 0)")
    int findIsExistByBlogger(String blogger);

    @Delete("delete from friendlink where id=#{id}")
    void deleteFriendLinkById(int id);

}
